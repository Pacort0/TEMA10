package ejercicios;

import java.io.*;
import java.util.*;

public class Ejercicio06 {

	public static void main(String[] args) {
		TreeSet<Integer> listaNums = new TreeSet<>();
		BufferedWriter bw = null;

		try {
			Scanner sc = new Scanner(new FileReader("numsNoOrden"));

			while (sc.hasNextInt()) {
				listaNums.add(sc.nextInt());
			}

			bw = new BufferedWriter(new FileWriter("numsEnOrden"));

			for (Integer ts : listaNums) {
				bw.write(Integer.toString(ts));
				bw.write(" ");
			}

			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("El fichero indicado no existe");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
		} finally {
			try {
				bw.flush();
				bw.close();
				
			} catch (IOException e) {
				System.err.println("Error de entrada/salida");
			}
		}
	}

}
