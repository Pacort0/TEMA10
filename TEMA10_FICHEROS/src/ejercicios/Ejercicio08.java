package ejercicios;

import java.io.*;
import java.util.*;

public class Ejercicio08 {

	private static final String FICHERO = "src\\registro"; //Variable final para guardar la ruta relativa del fichero

	public static void main(String[] args) {
		String[] separada = new String[0]; // Array para guardar elementos de una cadena 'split'
		String linea; //Cadena para guardar líneas de texto del fichero
		int opcion; //Guarda la elección del usuario
		String fecha; //Guardará la fecha 
		double tempMaxx; //Guardará la temperatura máxima
		double tempMin; //Guardará la temperatura mínima
		BufferedWriter bw = null; //Para escribir en el fichero
		BufferedReader br = null; //Para leer del fichero
		
		Scanner sc = new Scanner(System.in); //Escáner para leer lo que se escriba en consola

		try {
			bw = new BufferedWriter(new FileWriter(FICHERO, true)); //Indicamos el fichero a leer

			do {
				menu(); //Mostramos el menú
				opcion = sc.nextInt(); //Guardamos la elección del usuario

				switch (opcion) { //Según la opción elegida, haremos una cosa u otra
				case 1:
					System.out.println("Introduzca la fecha del día (aaaa-mm-dd): ");
					fecha = sc.nextLine();
					System.out.println("Intoduzca la temperatura máxima: ");
					tempMaxx = sc.nextDouble();
					System.out.println("Intoduzca la temperatura mínima: ");
					tempMin = sc.nextDouble(); //Pedimos los datos y los guardamos en las variables

					bw.write(fecha + ", " + tempMaxx + ", " + tempMin); //Pasamos los datos al fichero
					bw.newLine(); //Pasamos a la siguiente línea

					bw.flush(); //Hacemos el flush

					break;

				case 2:
					br = new BufferedReader(new FileReader(FICHERO)); //Indicamos el fichero a leer
					linea = br.readLine(); //Leemos la siguiente línea

					while (linea != null) {
						separada = linea.split(", ");

						fecha = separada[0];
						tempMaxx = Double.parseDouble(separada[1]);
						tempMin = Double.parseDouble(separada[2]);

						System.out.println("Fecha " + fecha);
						System.out.println("Temperatura máxima: " + tempMaxx);
						System.out.println("Temperatura mínima: " + tempMin);
						System.out.println("---------------------------------");

						linea = br.readLine();
					}
					break;
				case 3:
					System.out.println("Hasta luego");
					break;
				default:
					System.err.println("Esa opción no está contemplada");
				}
			} while (opcion != 3);

		} catch (IOException e) {
			System.err.println("Error al leer el fichero");
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.err.println("Error al leer el fichero");
				}
			}
		}
		sc.close();

	}

	public static void menu() {
		System.out.println(
				"Elija una opción: " + "\n1. Registra nueva temperatura" + "\n2. Mostrar historial" + "\3. Salir");
	}

}
