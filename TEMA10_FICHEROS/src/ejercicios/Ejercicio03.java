package ejercicios;

import java.io.*;

public class Ejercicio03 {

	public static void main(String[] args) {
		String linea = null; //Irá guardando las líneas que leamos del fichero
		String [] nombres = new String[0]; //Guardaremos los datos de las cadenas leídas por separado
		int sumaEdad = 0; //La suma de las edades introducidas
		int sumaAltura = 0; //La suma de las alturas introducidas
		int contador = 0; //El contador para poder hacer la media
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("Alumnos")); //Creamos un bufferedReader para ir leyendo línea a línea el archivo que le pasemos por parámetros 
			
			linea = br.readLine(); //Guardamos la primera línea en 'linea'
			
			while (linea != null) { //Mientras la última línea leída no sea 'null':

					nombres = linea.split(" "); //Guardamos en el array 'nombres' los elementos del archivo por separado
					System.out.println(nombres[0]); //Mostramos los nombres
					sumaEdad += Integer.parseInt(nombres[1]); //Sumamos las edades de los alumnos
					sumaAltura += Double.parseDouble(nombres[2]); //Sumamos las alturas de los alumnos
					contador++; //Aumentamos el valor del contador en 1
					
					linea = br.readLine(); //Leemos la siguiente línea
				} 
			
			//Mostramos los resultados obtenidos del programa
			System.out.println();
			System.out.println("La suma de las edades de los alumnos es: " + sumaEdad + " años");
			System.out.println("La media de edad de los alumnos es: " + (double) sumaEdad / contador + " años");
			System.out.println("La suma de las alturas de los alumnos es: " + sumaAltura + " cm");
			System.out.println("La media de altura de los alumnos es: " + (double) sumaAltura / contador + " cm"); 
			
			try {
				br.close(); //Cerramos el escáner
			} catch (IOException e) {
				System.err.println("Error al cerrar el escáner");
			}
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		} catch (IOException e1) {
			System.err.println("El fichero está vacío"); 
		} //Cazamos los posibles errores que se puedan dar durante la ejecución del programa
	}

}
