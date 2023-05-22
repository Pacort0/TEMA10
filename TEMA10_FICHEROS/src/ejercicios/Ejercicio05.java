package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio05 {
	
	public static void main(String[] args) {
		String nombre = ""; // Nombre de la persona
		String edad = ""; // Edad de la persona
		
		Scanner sc = new Scanner(System.in); // Escáner del programa  para leer de consola

		BufferedWriter bw = null; // Creamos un objeto BufferedWriter y lo inicializamos a null

		String ruta = new File("datos.txt").getAbsolutePath(); // Guardamos en 'ruta' la ruta del fichero que indicamos
																// entre paréntesis

		try {
			File fichero = new File(ruta); // Creamos un objeto File con la ruta que hemos guardado antes
			if (fichero.createNewFile()) { // Si el fichero no se ha creado antes

				bw = new BufferedWriter(new FileWriter(ruta)); // Inicializamos el BufferedWriter y le pasamos el
																// fichero por parámetros

				System.out.println("Introduzca su nombre: ");
				nombre = sc.nextLine(); // Pedimos y guardamos el nombre de la persona

				System.out.println("Introduzca su edad: ");
				edad = sc.next(); // Pedimos y guardamos la edad de la persona
				bw.write(nombre + " " + edad); // Escribimos los datos en el fichero

				bw.newLine(); // Nos vamos a la siguiente línea
			} else { // Si el fichero ya se ha creado
				bw = new BufferedWriter(new FileWriter(ruta, true)); // Inicializamos el objeto BufferedWriter y le
																		// pasamos el fichero por parámetros, además de
																		// indicar al programa que tiene que escribir
																		// sin borrar los datos anteriores

				System.out.println("Introduzca su nombre: ");
				nombre = sc.nextLine();

				System.out.println("Introduzca su edad: ");
				edad = sc.next();
				bw.write(nombre + " " + edad);

				bw.newLine();
			}

		} catch (IOException e) {
			System.err.println("Error de Entrada/Salida"); // Cazamos la excepción
		} finally {
			try {
				bw.flush(); // Hacemos flush y cerramos el Writer
				bw.close();
			} catch (IOException e) {
				System.err.println("Error de Entrada/Salida"); // Cazamos la excepción
			}
		}
		
		sc.close(); //Cerramos el escáner

	}

}
