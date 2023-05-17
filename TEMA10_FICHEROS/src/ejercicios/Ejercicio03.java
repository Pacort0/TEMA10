package ejercicios;

import java.io.*;

public class Ejercicio03 {

	public static void main(String[] args) {
		String linea = null;
		String [] nombres = new String[0];
		int sumaEdad = 0; 
		int sumaAltura = 0;
		int contador = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("Alumnos"));
			
			linea = br.readLine();
			
			while (linea != null) {

					nombres = linea.split(" ");
					System.out.println(nombres[0]);
					sumaEdad += Integer.parseInt(nombres[1]);
					sumaAltura += Double.parseDouble(nombres[2]);
					contador++;
					
					linea = br.readLine();
				} 
			
			System.out.println();
			System.out.println("La suma de las edades de los alumnos es: " + sumaEdad + " años");
			System.out.println("La media de edad de los alumnos es: " + (double) sumaEdad / contador + " años");
			System.out.println("La suma de las alturas de los alumnos es: " + sumaAltura + " cm");
			System.out.println("La media de altura de los alumnos es: " + (double) sumaAltura / contador + " cm");
			
			try {
				br.close();
			} catch (IOException e) {
				System.err.println("Error al cerrar el escáner");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		} catch (IOException e1) {
			System.err.println("El fichero está vacío");
		}
	}

}
