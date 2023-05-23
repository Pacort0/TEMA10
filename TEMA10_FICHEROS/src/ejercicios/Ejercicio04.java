package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		String cadena = ""; //Cadena donde se van a ir guardando las líneas de texto que escribamos
		
		BufferedWriter bw = null; //Creamos e iniciamos el BufferedWriter a null
		
		try {
			bw = new BufferedWriter(new FileWriter("escribir-ej4")); //Iniciamos el bufferedWriter y le pasamos un fichero en el que escribir
			Scanner sc = new Scanner(System.in); //Creamos un escáner con el que poder leer lo que escribimos por consola
			
			System.out.println("Introduzca unas líneas de texto: ");
			cadena = sc.nextLine(); //Pedimos al usuario que introduzca una línea de texto y la guardamos
			
			bw.write(cadena); //Escribimos la cadena introducida en el fichero
			
			while(!cadena.equalsIgnoreCase("fin")) { //Mientras la cadena no sea 'fin':
				
				bw.newLine(); //Saltamos a la siguiente línea en el fichero
				
				cadena = sc.nextLine(); //Guardamos la línea que introduzca el usuario
				
				bw.write(cadena); //Escribimos la última cadena en el fichero
			}
			sc.close(); //Cerramos el escáner
		} catch (IOException e) { //Cazamos la excepción
			System.err.println("Error");
			System.out.println(e.getMessage());
		} finally { //Bloque de instrucciones que DEBE ejecutarse
			try {
				bw.flush(); //Hacemos flush y cerramos el WriterS
				bw.close();
			} catch (IOException e) { //Cazamos la excepción
				System.err.println("Error"); 
				System.out.println(e.getMessage());
			}
		}
	}

}
