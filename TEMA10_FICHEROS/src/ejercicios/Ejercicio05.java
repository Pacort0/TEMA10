package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio05 {

	static Scanner sc = new Scanner(System.in);
	static String nombre = "";
	static String edad = "";
	
	public static void main(String[] args) {
		BufferedWriter bw = null;
		
		String ruta = new File("datos.txt").getAbsolutePath();
		System.out.println(ruta);
		
		
		try {
			File fichero = new File(ruta);
			if(fichero.createNewFile()) {
				
				bw = new BufferedWriter(new FileWriter("datos.txt"));
				
				insertaDatos();
				bw.write(nombre);
				bw.write(" ");
				bw.write(edad);
				
				bw.newLine();
			} else {
				bw = new BufferedWriter(new FileWriter("datos.txt", true));
				
				insertaDatos();
				bw.write(nombre);
				bw.write(" ");
				bw.write(edad);
				
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.err.println("Error de Entrada/Salida");
		} finally {
			try {
				bw.flush();
				bw.close();
			} catch (IOException e) {
				System.err.println("Error de Entrada/Salida");
			}
		}
		
	}
	
	public static void insertaDatos() {
		System.out.println("Introduzca su nombre: ");
		nombre = sc.nextLine();
		
		System.out.println("Introduzca su edad: ");
		edad = sc.next();
	}

}
