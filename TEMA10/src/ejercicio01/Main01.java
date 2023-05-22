package ejercicio01;

import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //Escáner del programa
		
		System.out.println("Introduzca un valor entero: ");
		System.out.println(Utils.readInt(sc)); //Introducimos un valor entero y lo leemos con la función creada en Utils
		
		System.out.println("Introduzca un valor double: ");
		System.out.println(Utils.readDouble(sc)); //Introducimos un valor entero y lo leemos con la función creada en Utils
	}

}
