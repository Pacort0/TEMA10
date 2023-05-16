package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		double suma = 0;
		double media;
		int contador = 0;
		
		try {
			Scanner sc = new Scanner(new FileReader("..\\..\\ficheros\\NumerosReales.txt"));
			
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