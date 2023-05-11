package ejercicio01;

import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca un valor entero: ");
		System.out.println(Utils.readInt(sc));
		
		System.out.println("Introduzca un valor double: ");
		System.out.println(Utils.readDouble(sc));
	}

}
