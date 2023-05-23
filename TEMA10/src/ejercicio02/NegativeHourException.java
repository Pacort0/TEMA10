package ejercicio02;

/**
 * Excepción que salta cuando se introduce una hora fuera de rango
 * @author Admin
 *
 */
@SuppressWarnings("serial")
 class NegativeHourException extends Exception {
	public String toString() {
		return "La hora no existe"; //Si la hora no es correcta, se imprime este texto
	}
}

/**
 * Excepción que salta cuando se introduce un minuto fuera de rango
 * @author Admin
 *
 */
@SuppressWarnings("serial")
class NegativeMinuteException extends Exception {
	public String toString() {
		return "Los minutos no existen"; //Si los minutos no son correctos, se imprime este mensaje de error
	}
}

/**
 * Excepción que salta cuando se introduce un segundo fuera de rango
 * @author Admin
 *
 */
@SuppressWarnings("serial")
class NegativeSecondException extends Exception {
	public String toString() {
		return "Los segundos no existen"; //Si los segundos no son correctos, se imprime este mensaje de error
	}
}
