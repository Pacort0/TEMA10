package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		String cadena = "";
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("escribir-ej4"));
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Introduzca unas líneas de texto: ");
			cadena = sc.nextLine();
			
			bw.write(cadena);
			
			while(!cadena.equalsIgnoreCase("fin")) {
				
				bw.newLine();
				
				cadena = sc.nextLine();
				
				bw.write(cadena);
			}
			sc.close();
		} catch (IOException e) {
			System.err.println("Error");
			System.out.println(e.getMessage());
		} finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				System.err.println("Error");
				System.out.println(e.getMessage());
			}
		}
	}

}
