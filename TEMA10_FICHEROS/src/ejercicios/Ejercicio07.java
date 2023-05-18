package ejercicios;

import java.io.*;
import java.util.*;

public class Ejercicio07 {

	final static Scanner SC = new Scanner(System.in);
	public static TreeMap<String, Long> agenda = new TreeMap<>();

	public static void main(String[] args) {
		int opcion = 0;
		String nombre;
		long tlfn;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("agenda.txt"));
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
		}	
		
		do {
			menu();
			opcion = SC.nextInt();
			SC.nextLine();
			
			switch (opcion) {
			case 1:
				System.out.println("Introduzca el nombre del nuevo contacto: ");
				nombre = SC.nextLine();
				System.out.println("Introduzca el número de teléfono del nuevo contacto: ");
				tlfn = SC.nextLong();
				
				if (!agendaCompleta() && !agenda.containsKey(nombre)) {
					agenda.put(nombre, tlfn);
					
				} else {
					System.err.println("La agenda está completa");
				}
				break;
			case 2:
				System.out.println("Introduzca el nombre del contacto a buscar: ");
				if(buscaContacto(SC.nextLine()) != -1) {
					System.out.println(buscaContacto(SC.nextLine()));
				} else {
					System.err.println("El contacto no existe");
				}
				break;
			case 3:
				System.out.println(agenda);
				break;
			}
		} while (opcion != 5);
	}

	public static void menu() {
		System.out.println("Introduzca una opción: " + "\n1. Añadir contacto" + "\n2. Buscar contacto"
				+ "\n3. Mostrar agenda" + "\n4. Guardar datos en la agenda" + "\n5. Salir");

	}

	public static boolean agendaCompleta() {
		boolean completa = false;

		if (agenda.size() >= 20) {
			completa = true;
		}

		return completa;
	}

	public static long buscaContacto(String nombre) {
		long num;

		if (agenda.containsKey(nombre)) {
			num = -1;
		} else {
			num = agenda.get(nombre);
		}

		return num;
	}

}
