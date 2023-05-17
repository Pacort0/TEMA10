package ejercicios;

import java.io.*;

public class Ejercicio04 {

	public static void main(String[] args) {
		String cadena = "";
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("escribir-ej4"));
			BufferedReader br = new BufferedReader(new FileReader("escribir-ej4"));
			
			while(!cadena.equalsIgnoreCase("fin")) {
				bw.write(cadena);
			}
		} catch (IOException e) {
			System.err.println("Fichero no encontrado");
		}
	}

}
