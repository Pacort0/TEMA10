package ejercicio03;

import java.util.Scanner;

/**
 * Clase main desde la que vamos a probar los métodos de 'Fecha'
 * @author frodriguez
 *
 */
public class Main03 {

	public static void main(String[] args) {
		Fecha fecha = new Fecha(); //Objeto de tipo Fecha
		
		Scanner sc = new Scanner(System.in); //Escáner del programa
		
		System.out.println("Introduzca el día: ");
		try {
			fecha.setDia(sc.nextInt());
		} catch (NegativeDayException nD) { //Cazamos el error en caso de que el día sea incorrecto y mostramos un mensaje de error
			System.err.println(nD.toString());
		}
		
		System.out.println("Introduzca el mes: ");
		try {
			fecha.setMes(sc.nextInt());
		} catch (NegativeMonthException nM) { //Lanzamos el error en caso de que el mes sea incorrecto y mostramos un mensaje de error
			System.err.println(nM.toString());
		}
		
		System.out.println("Introduzca el año: ");
		try {
			fecha.setAnio(sc.nextInt());
		} catch (NegativeYearException nY) { //Lanzamos el error en caso de que el año sea incorrecto y mostramos un mensaje de error
			System.err.println(nY.toString());
		}
		
		if(fecha.esBisiesto()) {
			System.out.println("La fecha introducida corresponde a un año bisiesto.");
		} else {
			System.out.println("La fecha introducida no corresponde a un año bisiesto.");
		}
		
		//Aumentamos la fecha en un día
		fecha.toString();
		fecha.diaSiguiente();
		System.out.println("El día siguiente será el " + fecha.toString());
		
		sc.close();
	}

}
