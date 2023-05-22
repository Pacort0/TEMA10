package ejercicio01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	/**
	 * Método para leer un valor int y capturar los errores de inserción
	 * @param sc Se pasa por parámetro un escáner
	 * @return Devuelve un entero 
	 */
	public static int readInt(Scanner sc) {
		int res = 0; 

		try {
			res = sc.nextInt(); 
		} catch (InputMismatchException e) { //Capturamos los errores de inserción
			System.err.println("El valor introducido no es de tipo int");  //Mostramos un mensaje de error
			sc.nextLine();
		}
 
		return res; //Devolvemos el valor leído, de ser correcto
	}

	/**
	 * Método para leer un valor double y capturar los errores de inserción
	 * @param sc Se pasa por parámetro un escáner
	 * @return Devuelve un double
	 */
	public static double readDouble(Scanner sc) { 
		double res = 0;

		try {
			res = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.err.println("El valor introducido no es de tipo double");
		}

		return res;
	}
}
