package ejercicio03;

@SuppressWarnings("serial")
/**
 * Excepción que salta cuando se introduce un día que no pertenece a un rango definido
 * @author Admin
 *
 */
public class NegativeDayException extends Exception{
	public String toString() { 
		return "El día no existe"; //Si el día introducido es erróneo, mostramos este mensaje de error
	}
}

/**
 * Excepción que salta cuando se introduce un mes que no pertenece a un rango definido
 * @author Admin
 *
 */
@SuppressWarnings("serial")
class NegativeMonthException extends Exception{
	public String toString() {
		return "El mes no existe"; //Si el mes introducido es erróneo, mostramos este mensaje de error
	}
}

/**
 * Excepción que salta cuand se introduce un año que no pertenece a un rango definido
 * @author Admin
 *
 */
@SuppressWarnings("serial")
class NegativeYearException extends Exception{
	public String toString() {
		return "El año no existe"; //Si el año introducido es erróneo, se muestra este mensaje de error
	}
}
