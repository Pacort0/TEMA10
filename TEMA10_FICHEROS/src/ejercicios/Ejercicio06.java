package ejercicios;

import java.io.*;
import java.util.*;

public class Ejercicio06 {

	public static void main(String[] args) {
		TreeSet<Integer> listaNums = new TreeSet<>(); // Creamos una colección de tipo TreeSet que guarde valores
														// enteros. Este tipo de colección ordena automáticamente los
														// valores que se le insertan
		BufferedWriter bw = null; // Creamos un objeto BufferedWriter y lo inicializamos a null

		try {
			Scanner sc = new Scanner(new FileReader("numsNoOrden")); // Creamos un escáner para leer los números del
																		// fichero que le pasamos por parámetros

			while (sc.hasNextInt()) { // Mientras siga habiendo números enteros en el fichero
				listaNums.add(sc.nextInt()); // Añadimos los números a la lista
			}

			bw = new BufferedWriter(new FileWriter("numsEnOrden")); // Inicializamos el objeto BufferedWriter y le
																	// pasamos por parámetros el fichero en el que
																	// queremos escribir

			for (Integer ts : listaNums) { // Bucle for each para recorrer la lista y escribir los números en el fichero
				bw.write(Integer.toString(ts) + "\n");
			}

			sc.close(); // Cerramos el escáner
		} catch (FileNotFoundException e) { // Cazamos la excepción
			System.err.println("El fichero indicado no existe");
		} catch (IOException e) { // Cazamos la excepción
			System.err.println("Error de entrada/salida");
		} finally {
			try { // Hacemos flush y cerramos el Writer
				bw.flush();
				bw.close();

			} catch (IOException e) { // Cazamos la excepción
				System.err.println("Error de entrada/salida");
			}
		}
	}

}
