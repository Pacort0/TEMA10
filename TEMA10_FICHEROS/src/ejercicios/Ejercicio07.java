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
		BufferedWriter bw;
		String cadena;
		String[] separado = new String[0];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("agenda.txt"));
			
			cadena = br.readLine();
			
			while(cadena != null) {
				
				separado = cadena.split(" --> ");
				
				agenda.put(separado[0], Long.parseLong(separado[1]));
				
				cadena = br.readLine();
			}
			
			br.close();
			
		} catch (FileNotFoundException e1) {
			System.err.println("Fichero no encontrado");
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
				nombre = SC.nextLine();
				
				if(buscaContacto(nombre)) {
					System.out.println("Teléfono: " + agenda.get(nombre));
				} else {
					System.err.println("El contacto no existe");
				}
				break;
			case 3:
				if (agenda.size() == 0) {
					System.err.println("La agenda está vacía");
				} else {
					System.out.println(agenda);
				}
				break;
			case 4:
				try {
					bw = new BufferedWriter(new FileWriter("agenda.txt"));
					
					escribe(bw);
					
					bw.close();
				} catch (IOException e) {
					System.err.println("Error de entrada/salida");
				}
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

	public static boolean buscaContacto(String nombre) {
		boolean existe = false;

		if(agenda.containsKey(nombre)) {
			existe = true;
		}

		return existe;
	}
	
	public static void escribe(BufferedWriter bw) {
		String cadena;
		
		for(String llave : agenda.keySet()) {
			cadena = llave + " --> " + agenda.get(llave);
			try {
				bw.write(cadena);
				bw.newLine();
			} catch (IOException e) {
				System.err.println("Error de entrada/salida");
			}
		}
	}

}
