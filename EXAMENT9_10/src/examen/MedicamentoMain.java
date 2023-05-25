package examen;

import java.io.*;
import java.util.*;

public class MedicamentoMain {

	// Colección tipo TreeMap, ya que nos ordena los elementos según su clave
	static TreeMap<Integer, Medicamento> listaMedicamentos = new TreeMap<>(); // Se guardará un entero como clave y un
																				// objeto Medicamento como valor

	public static void main(String[] args) throws IOException { // Lanza la excepción de entrada/salida para cuando
																// queramos cerrar el BW
		String ruta; // Guarda la ruta hasta el fichero "medicamentos"
		int opcion; // Guarda la opción del menú que elije el usuario
		int codigo; // Guarda el código del medicamento que introduce el usuario
		String nombre; // Guarda el nombre del medicamento que introduce el usuario
		String descripcion; // Guarda la descripción del medicamento que introduce el usuario
		double precio; // Guarda el precio del medicamento que introduce el usuario
		String posologia; // Guarda la posologia del medicamento que introduce el usuario
		BufferedReader br = null; // Para leer del fichero
		BufferedWriter bw = null; // Para escribir en el fichero
		int contador = 0; //Lo usaremos en caso de error con la inserción del código

		Scanner sc = new Scanner(System.in); // Escáner para leer lo que introduce el usuario

		// Damos la bienvenida al programa
		System.out.println("¡Bienvenido al sistema de gestión de medicamentos!");

		// Guardamos en ruta la ruta hasta "src\medicamentos.txt"
		ruta = new File("src\\medicamentos.txt").getAbsolutePath(); // Así no da error de fichero no encontrado
		try {
			File fichero = new File(ruta); // Si no existe, creamos un fichero en la ruta escogida
			if (fichero.createNewFile()) {
				br = new BufferedReader(new FileReader(ruta)); // Inicializamos el lector

				lee(br); // Leemos del fichero y copiamos en la colección
			} else { // Si ya existe el fichero
				br = new BufferedReader(new FileReader(ruta)); // Inicializamos el lector

				lee(br); // Leemos del fichero y copiamos en la colección
			}
			do { // Empieza el do-while
				menu(); // Mostramos el menú por pantalla
				opcion = sc.nextInt(); // Guardamos la elección del usuario

				sc.nextLine();

				switch (opcion) { // Según lo que elija el usuario
				case 1:
					do {
						if(contador > 0) { //Si el contador es > 0, mensaje de error
							System.err.println("Los códigos deben ser únicos y ser > 0");
						}
						System.out.println("Introduzca el código del medicamento: ");
						codigo = sc.nextInt(); // Pedimos el código del medicamento
						
						contador++; //Aumentamos el contador

						sc.nextLine();
					} while (listaMedicamentos.containsKey(codigo) && codigo > 0); // Mientras sea positivo y no se
																					// repita

					System.out.println("Introduzca el nombre del medicamento: ");
					nombre = sc.nextLine(); // Pedimos y guardamos el nombre del medicamento

					System.out.println("Introduzca la descripción del medicamento: ");
					descripcion = sc.nextLine(); // Pedimos y guardamos la descripción del medicamento

					System.out.println("Introduzca el precio del medicamento: ");
					precio = sc.nextDouble(); // Pedimos y guardamos el precio del medicamento

					sc.nextLine();

					System.out.println("Introduzca la posología del medicamento: ");
					posologia = sc.nextLine(); // Pedimos y guardamows la posología del medicamento

					// Guardamos los datos en la colección, creando un medicamento con los datos
					// recogidos
					listaMedicamentos.put(codigo, new Medicamento(codigo, nombre, descripcion, precio, posologia));
					break;
				case 2:
					if (listaMedicamentos.size() != 0) { // Si la lista no está vacía
						for (Integer cod : listaMedicamentos.keySet()) { // La recorremos tomando las claves

							// Creamos un objeto Medicamento para coger los valores de las llaves
							Medicamento med = listaMedicamentos.get(cod);

							// Mostramos los datos de los medicamentos
							System.out.println(med.toString());
						}
					} else {
						// Error, la lista está vacía
						System.err.println("La lista de medicamentos está vacía, añada alguno primero.");
					}
					break;
				case 3:
					System.out.println("Introduzca el código del medicamento que desea eliminar: ");
					codigo = sc.nextInt(); // Pedimos el código del medicamento a eliminar y lo guardamos

					sc.nextLine();

					if (buscaMedicamento(codigo)) { // Si existe, lo eliminamos
						listaMedicamentos.remove(codigo);
					} else { // Si no existe, mensaje de error
						System.err.println("El medicamento introducido no existe.");
					}

					break;
				case 4:
					bw = new BufferedWriter(new FileWriter(ruta)); // Inicializamos el escritor
					escribe(bw); // Escribimos los datos que tenemos hasta ahora
					break;
				case 0:
					System.out.println("Saliendo del sistema..."); // Nos despedimos
					break;
				default:
					System.err.println("Esa opción no está contemplada"); // Mensaje de error si la opción no existe
				}
			} while (opcion != 0); // El bucle se repetirá mientras la opción no sea 0

			sc.close(); // Cerramos el escáner
		} catch (IOException e) { // Cazamos la excepción de entrada/salida
			System.err.println("Error de Entrada/Salida"); // Mensaje de error
		} finally { // Bloque que se ejecuta sí o sí
			if (bw != null) { // Si se ha usado el BW
				bw.close(); // Cerramos el BW
			}
		}
	}

	/**
	 * Función que imprime el menú por pantalla
	 */
	public static void menu() {
		System.out.println("Introduzca una opción: " + "\n1. Añadir medicamento." + "\n2. Listar medicamentos."
				+ "\n3. Eliminar medicamento." + "\n4. Guardar medicamento(s)." + "\n0. Salir.");
	}

	/**
	 * Función que determina si un medicamento existe o no
	 * 
	 * @param codigo Código del medicamento a buscar
	 * @return Devuelve un booleano en función de si el medicamento existe o no
	 */
	public static boolean buscaMedicamento(int codigo) {
		boolean existe = false;

		if (listaMedicamentos.containsKey(codigo)) {
			existe = true;
		}

		return existe;
	}

	/**
	 * Función que escribe los datos de la colección en el fichero
	 * 
	 * @param bw Escritor del fichero
	 * @throws IOException Lanza una excepción de entrada/salida
	 */
	public static void escribe(BufferedWriter bw) throws IOException {
		String cadena; // Guarda la cadena que se va a escribir
		int codigo; // Guarda el código del medicamento
		String nombre; // Guarda el nombre del medicamento
		String descripcion; // Guarda la descripción del medicamento
		double precio; // Guarda el precio del medicamento
		String posologia; // Guarda la posología del medicamento

		for (Integer cod : listaMedicamentos.keySet()) { // Recorremos la lista tomando las claves

			// Guardamos todos los datos de cada medicamento
			codigo = listaMedicamentos.get(cod).getCodigo();
			nombre = listaMedicamentos.get(cod).getNombre();
			descripcion = listaMedicamentos.get(cod).getDescripcion();
			precio = listaMedicamentos.get(cod).getPrecio();
			posologia = listaMedicamentos.get(cod).getPosologia();

			// Encadenamos la cadena y la guardamos en 'cadena'
			cadena = String.valueOf(codigo) + ";";
			cadena += String.valueOf(nombre) + ";";
			cadena += String.valueOf(descripcion) + ";";
			cadena += String.valueOf(precio) + ";";
			cadena += String.valueOf(posologia);

			bw.write(cadena); // Escribimos la cadena en el fichero
			bw.newLine(); // Pasamos a la siguiente línea
		}

		bw.flush(); // Hacemos el flush
	}

	/**
	 * Función que lee los elementos existentes en el fichero y los copia en la
	 * colección
	 * 
	 * @param br Lector del fichero
	 * @throws IOException Lanza una excepción de Entrada/Salida
	 */
	public static void lee(BufferedReader br) throws IOException {
		String cadena; // Guarda la cadena que leamos
		String[] separado; // Guardará los elementos por separado de la cadena

		cadena = br.readLine(); // Leemos una línea y la guardamos en la cadena

		while (cadena != null) { // Mientras ésta no sea 'null'

			separado = cadena.split(";"); // Guardamos en 'separado' la cadena dividida por ';'

			// Creamos e introducimos los datos en un objeto Medicamento
			Medicamento med = new Medicamento(Integer.parseInt(separado[0]), separado[1], separado[2],
					Double.parseDouble(separado[3]), separado[4]);

			listaMedicamentos.put(Integer.parseInt(separado[0]), med); // Guardamos en la lista los valores obtenidos

			cadena = br.readLine(); // Leemos la siguiente línea
		}
		br.close(); // Cerramos el lector de fichero
	}
}
