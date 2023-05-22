package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		double suma = 0; // Variable para almacenar el resultado de la suma total de los números
							// introducidos
		double media; // Variable para almacenar el resultado de la media de números introducids
		int contador = 0; // Contador para seguir iterando en el bucle

		try {
			Scanner sc = new Scanner(new FileReader("NumerosReales")); // Creamos un escáner que lea datos de un archivo
																		// que le pasamos

			while (sc.hasNextDouble()) { // Mientras siga habiendo números en el documento
				suma += sc.nextDouble(); // Vamos sumando los números que nos encontramos
				contador++; // Aumentamos el valor del contador en 1
			}

			media = suma / contador; // Calculamos la media de los números introducidos
			System.out.println("La suma de los números del fichero es: " + suma
					+ "\nLa media de los números del fichero es: " + media); // Mostramos los resultados del programa

			sc.close(); // Cerramos el escáner
		} catch (FileNotFoundException e) { // Cazamos la excepción que resulta en caso de que no exista el fichero o la
											// ruta indicada
			System.err.println("Fichero no encontrado.");
		}
	}

}
