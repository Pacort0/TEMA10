package ejercicio03;

@SuppressWarnings("serial")
public class NegativeDayException extends Exception{
	public String toString() {
		return "El día no existe";
	}
}

@SuppressWarnings("serial")
class NegativeMonthException extends Exception{
	public String toString() {
		return "El mes no existe";
	}
}

@SuppressWarnings("serial")
class NegativeYearException extends Exception{
	public String toString() {
		return "El año no existe";
	}
}
