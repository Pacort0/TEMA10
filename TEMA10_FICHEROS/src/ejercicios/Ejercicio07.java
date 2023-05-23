package ejercicios;

import java.io.*;
import java.util.*;

public class Ejercicio07 {

	final static Scanner SC = new Scanner(System.in); // Creamos un escáner global para leer datos de consola
	public static TreeMap<String, Long> agenda = new TreeMap<>(); // Creamos un mapa global, guardaremos los datos de la
																	// agenda

	public static void main(String[] args) {
		int opcion = 0; // Guardará la opción que elija el usuario
		String nombre; // Guardará el nombre del contacto
		long tlfn; // Guardará el teléfono del contacto
		BufferedWriter bw = null; // Creamos un objeto BufferedWriter y lo inicializamos a null;
		String cadena; // Guardará las líneas que se vayan leyendo del código
		String[] separado = new String[0]; // String para obtener los valores del fichero por separado

		try {
			BufferedReader br = new BufferedReader(new FileReader("agenda.txt")); // Creamos un BufferedReader y le
																					// pasamos por parámetros el fichero
																					// a utilizar

			cadena = br.readLine(); // Leemos la primera línea del archivo

			while (cadena != null) { // Mientras ésta no sea 'null'

				separado = cadena.split(" --> "); // Guardamos en 'separado' la cadena dividida por '-->'

				agenda.put(separado[0], Long.parseLong(separado[1])); // Guardamos en la agenda los valores obtenido

				cadena = br.readLine(); // Leemos la siguiente línea
			}

			br.close(); // Cerramos el BufferedReader

		} catch (FileNotFoundException e1) { // Capturamos la excepción
			System.err.println("Fichero no encontrado");
		} catch (IOException e) { // Capturamos la excepción
			System.err.println("Error de entrada/salida");
		}

		do {
			menu(); // Mostramos el menú
			opcion = SC.nextInt(); // Guardamos la opción escogida
			SC.nextLine();

			switch (opcion) {
			case 1: // Si la elección es 1
				System.out.println("Introduzca el nombre del nuevo contacto: ");
				nombre = SC.nextLine();
				System.out.println("Introduzca el número de teléfono del nuevo contacto: ");
				tlfn = SC.nextLong(); // Pedimos y guardamos el nombre y el teléfono

				if (!agendaCompleta() && !agenda.containsKey(nombre)) { // Si la agenda tiene hueco y el nombre no ha
																		// sido introducido ya:
					agenda.put(nombre, tlfn); // Introducimos los datos en la agenda
				} else { // Si no, mostramos un mensaje de error
					System.err.println("La agenda está completa o el contacto ya existe");
				}
				break;
			case 2: // Si la opción es 2
				System.out.println("Introduzca el nombre del contacto a buscar: ");
				nombre = SC.nextLine(); // Pedimos y guardamos el nombre del contacto a buscar

				if (buscaContacto(nombre)) { // Si el contacto existe:
					System.out.println("Teléfono: " + agenda.get(nombre)); // Mostramos su teléfono por pantalla
				} else { // Si no existe, mostramos un mensaje de error
					System.err.println("El contacto no existe");
				}
				break;
			case 3: // Si la opción es 3
				if (agenda.size() == 0) { // Si la agenda está vacía, lo comunicamos
					System.err.println("La agenda está vacía");
				} else {
					System.out.println(agenda); // Si tiene datos, los mostramos
				}
				break;
			case 4: // Si la opción es 4
				try { // Inicializamos el objeto BufferedWriter y le pasamos por parámetros el objeto
						// a leer
					bw = new BufferedWriter(new FileWriter("agenda.txt"));

					escribe(bw); // Llamamos a la función 'escribe' y le pasamos por parámetros el BW
				} catch (IOException e) { // Cazamos la excepción
					System.err.println("Error de entrada/salida");
				} finally { // Ejecutamos el bloque finally
					try { // Hacemos flush y cerramos el BW
						bw.flush();
						bw.close();
					} catch (IOException e) { // Cazamos la excepción
						System.err.println("Error de entrada/salida");
					}
				}
				break;
			case 5:
				System.out.println("Introduzca el nombre del contacto a buscar: ");
				nombre = SC.nextLine(); // Pedimos y guardamos el nombre del contacto a buscar

				if (buscaContacto(nombre)) { // Si el contacto existe:
					agenda.remove(nombre); // Eliminamos el contacto
				} else { // Si no existe, mostramos un mensaje de error
					System.err.println("El contacto no existe");
				}
				break;
			case 6: // Si la opción es 5
				System.out.println("Hasta luego"); // Nos despedimos del usuario
				break;
			default: // Si no es ninguna de las opciones anteriores
				System.err.println("Esa opción no está contemplada"); // Mostramos un mensaje de error
			}
		} while (opcion != 6); // El bucle do-while se repetirá mientras la opción sea diferente de 5
	}

	/**
	 * Función que imprime el menú por pantalla
	 */
	public static void menu() {
		System.out.println("Introduzca una opción: " + "\n1. Añadir contacto" + "\n2. Buscar contacto"
				+ "\n3. Mostrar agenda" + "\n4. Guardar datos en la agenda" + "\n5. Borrar contacto" + "\n6. Salir");

	}

	/**
	 * Función que comprueba si la agenda está completa o no
	 * 
	 * @return Devuelve un booleano en función de si la agenda está completa o no
	 */
	public static boolean agendaCompleta() {
		boolean completa = false;

		if (agenda.size() >= 20) {
			completa = true;
		}

		return completa;
	}

	/**
	 * Función que comprueba si el contacto indicado existe o no
	 * 
	 * @param nombre Nombre del contacto que se desea buscar
	 * @return Devuelve un booleano en función de si el contacto existe o no
	 */
	public static boolean buscaContacto(String nombre) {
		boolean existe = false;

		if (agenda.containsKey(nombre)) {
			existe = true;
		}

		return existe;
	}

	/**
	 * Función que escribe los datos que se encuentran en el mapa en el fichero
	 * mediante un bucle for-each
	 * 
	 * @param bw BufferedWriter que se pasa por parámetros
	 * @throws IOException Lanza la excepción IOException
	 */
	public static void escribe(BufferedWriter bw) throws IOException {
		String cadena;

		for (String llave : agenda.keySet()) {
			cadena = llave + " --> " + agenda.get(llave);
			bw.write(cadena);
			bw.newLine();
		}
	}
}
