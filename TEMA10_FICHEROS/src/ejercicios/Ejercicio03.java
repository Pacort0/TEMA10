package ejercicios;

import java.io.*;

public class Ejercicio03 {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("..\\..\\ficheros\\Alumnos.txt"));
			
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("El escáner no se pudo cerrar");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}
	}

}
