package ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		double suma = 0;
		double media;
		int contador = 0;
		
		try {
			Scanner sc = new Scanner(new FileReader("..\\..\\ficheros\\Enteros.txt"));
			
			while(sc.hasNextInt()) {
				suma += sc.nextDouble();
				contador++;
			}
			
			media = suma / contador;
			System.out.println("La suma de los números del fichero es: " + suma + 
					"\nLa media de los números del fichero es: " + media);
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}
	}

}
