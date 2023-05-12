package ejercicio02;

/**
 * Clase que controla el cambio de la hora cada segundo.
 * Todas las horas disponen de los atributos 'hora', 'minuto' y 'segundos'
 * @author frodriguez
 *
 */
public class Hora {
	int hora;
	int minuto;
	int segundos;
	
	/**
	 * Constructor por defecto
	 */
	public Hora() {

	}
	
	/**
	 * Constructor de Hora
	 * @param hora Asigna la hora
	 * @param minuto Asigna los minutos
	 * @param segundos Asigna los segundos
	 */
	public Hora(int hora, int minuto, int segundos) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundos = segundos;
	}
	
	/**
	 * Método get que recoge la hora actual
	 * @return Devuelve la hora
	 */
	public int getHora() {
		return hora;
	}
	
	/**
	 * Método set que cambia la hora después de comprobar que ésta es correcta
	 * @param hora Recibe la nueva hora
	 */
	public void setHora (int hora) throws NegativeHourException{
		if(hora < 0 || hora > 23) {
			throw new NegativeHourException();
		} else {
			this.hora = hora;
		}
	}
	
	/**
	 * Método get que recoge los minutos actuales
	 * @return Devuelve los minutos
	 */
	public int getMinuto() {
		return minuto;
	}
	
	/**
	 * Método set que cambia los minutos después de comprobar que éstos son correctos
	 * @param minuto Recibe los minutos a asignar
	 */
	public void setMinuto(int minuto) throws NegativeMinuteException{
		if (minuto >= 0 && minuto <= 59) {
			this.minuto = minuto;
		} else {
			throw new NegativeMinuteException();
		}
	}
	
	/**
	 * Método get que recoge los segundos actuales
	 * @return Devuelve los segundos 
	 */
	public int getSegundos() {
		return segundos;
	}
	
	/**
	 * Método set que cambia los segundos
	 * @param segundos Recibe la nueva cantidad de segundos
	 */
	public void setSegundos(int segundos) throws NegativeSecondException{
		if (segundos >= 0 && segundos <= 59) {
			this.segundos = segundos;
		} else {
			throw new NegativeSecondException();
		}
	}
	
	/**
	 * Método que incrementa la hora en los segundos que se le pasen por parámetro
	 * @param incremento Cantidad de segundos a incrementar
	 */
	public void incrementaSegundos(int incremento) {

		for (int i = 1; i <= incremento; i++) {

			segundos++;
			if (getSegundos() > 59) {
				minuto++;
				try {
					setSegundos(0);
				} catch (NegativeSecondException e) {
					System.err.println(e.toString());	
				}
			}
			if (getMinuto()> 59) {
				hora++;
				try {
					setMinuto(0);
				} catch (NegativeMinuteException e) {
					System.err.println(e.toString());	
				}
			}
			if (getHora() > 23) {
				try {
					setMinuto(0);
				} catch (NegativeMinuteException e) {
					System.err.println(e.toString());	
				}
			}
		}
	}

}
