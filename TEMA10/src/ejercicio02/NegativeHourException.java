package ejercicio02;

@SuppressWarnings("serial")
public class NegativeHourException extends Exception {
	public String toString() {
		return "La hora no existe";
	}
}

@SuppressWarnings("serial")
class NegativeMinuteException extends Exception {
	public String toString() {
		return "Los minutos no existen";
	}
}

@SuppressWarnings("serial")
class NegativeSecondException extends Exception {
	public String toString() {
		return "Los segundos no e";
	}
}
