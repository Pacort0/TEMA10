package ejercicio02;

import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) throws NegativeHourException {
		int incremento = 0; // Variable para guardar los segundos a incrementar
		Hora primera = new Hora(0, 0, 0); // Creamos un objeto de tipo Hora

		Scanner sc = new Scanner(System.in); // Escáner del programa

		// Pedimos la hora
		System.out.println("Introduzca la hora que es: ");
		try {
			primera.setHora(sc.nextInt());
		} catch (NegativeHourException e) {
			System.err.println(e.toString());
		}
		System.out.println("Introduzca los minutos: ");
		try {
			primera.setMinuto(sc.nextInt());
		} catch (NegativeMinuteException e) {
			System.err.println(e.toString());
		}
		System.out.println("Introduzca los segundos: ");
		try {
			primera.setSegundos(sc.nextInt());
		} catch (NegativeSecondException e) {
			System.err.println(e.toString());
		}

		// Mostramos la hora actual
		System.out.println("La hora actual es: " + primera.getHora() + " : " + primera.getMinuto() + " : "
				+ primera.getSegundos());

		// Pedimos los segundos a incrementar
		System.out.println("Introduzca una cantidad de segundos a incrementar: ");
		incremento = sc.nextInt();

		// Incrementamos la hora
		primera.incrementaSegundos(incremento);

		// Mostramos la hora resultante
		System.out.println("La hora actual es: " + primera.getHora() + " : " + primera.getMinuto() + " : "
				+ primera.getSegundos());

		// Cerramos el escáner
		sc.close();
	}
}
