package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		double suma = 0; // Guardará la suma de todos los números
		double media; // Guardará la mediade todos los números
		int contador = 0; // Contador para seguir iterando en el bucle

		try {
			Scanner sc = new Scanner(new FileReader("Enteros")); // Creamos un escáner para leer de un fichero que le
																	// pasamos por parámetros

			while (sc.hasNextInt()) { // Mientras existan más números enteros en el fichero:
				suma += sc.nextInt(); // Vamos sumando los números
				contador++; // Aumentamos el contador en 1
			}

			media = suma / contador; // Calculamos la media de los números introducidos
			System.out.println("La suma de los números del fichero es: " + suma
					+ "\nLa media de los números del fichero es: " + media); // Mostramos los resultados de los cálculos
																				// del programa

			sc.close(); // Cerramos el escáner
		} catch (FileNotFoundException e) { // Cazamos la excepción que salta cuando no existen el fichero o la ruta
											// indicada
			System.err.println("Fichero no encontrado.");
		}
	}

}
