package ejercicio03;

/**
 * Clase que controla las veracidad de las fechas y sus cambios. Todas las
 * fechas tienen los atributos 'dia', 'mes' y 'anio'
 * 
 * @author Admin
 *
 */
public class Fecha {
	private int dia = 1;
	private int mes = 1;
	private int anio = 1970;

	/**
	 * Constructor por defecto
	 */
	public Fecha() {

	}

	/**
	 * Constructor de Fecha
	 * 
	 * @param dia  Día de la fecha
	 * @param mes  Mes de la fecha
	 * @param anio Año de la fecha
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	/**
	 * Método que recoge el valor de 'dia'
	 * 
	 * @return El valor de 'dia'
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * Método que asigna un valor a 'dia', comprobando antes que la fecha
	 * introducida es correcta
	 * 
	 * @param dia Valor que le vamos a asignar a 'dia'
	 */
	public void setDia(int dia) throws NegativeDayException{
		if (dia > 0 && dia <=31 && fechaCorrecta()) {
			this.dia = dia;
		} else {
			throw new NegativeDayException();
		}
	}

	/**
	 * Método que recoge el valor de 'mes'
	 * 
	 * @return El valor de 'mes'
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * Método que asigna un valor a 'mes', comprobando antes que la fecha sea
	 * correcta
	 * 
	 * @param mes El valor que le queremos asignar a 'mes'
	 */
	public void setMes(int mes) throws NegativeMonthException{
		if (fechaCorrecta() && mes > 0 && mes <=12) {
			this.mes = mes;
		} else {
			throw new NegativeMonthException();
		}
	}

	/**
	 * Método que recoge el valor de 'anio'
	 * 
	 * @return El valor de 'anio'
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Método que asigna un valor a 'anio', comprobando antes que la fecha sea
	 * correcta
	 * 
	 * @param anio Valor que le queremos asignar a 'anio'
	 */
	public void setAnio(int anio) throws NegativeYearException{
		if (fechaCorrecta()) {
			this.anio = anio;
		} else {
			throw new NegativeYearException();
		}
	}

	/**
	 * Método que comprueba si el año introducido es bisiesto o no
	 * 
	 * @return Devuelve un booleano en función de su bisiestedad
	 */
	public boolean esBisiesto() {
		boolean bisiesto = false;
		if (getAnio() % 4 == 0 || (getAnio() % 100 == 0 && getAnio() % 400 == 0)) { // Si además es divisible entre 100
			bisiesto = true; // Si es divisible entre 100 y 400 es bisiesto
		}

		return bisiesto;
	}

	/**
	 * Método que comprueba que la fecha introducida sea correcta
	 * 
	 * @return Devuelve un booleano en función de si la fecha es correcta o no
	 */
	public boolean fechaCorrecta() {
		boolean correcta = false;

		if (getDia() > 0 && getDia() <= 31) { // Primero comprobamos si el día introducido es potencialmente correcto
			if (getMes() == 2 && getDia() <= 28 && !esBisiesto()) { // Luego comprobamos que, en caso de ser febrero, el
																	// rango no supera 28
				correcta = true;
			} else if (getMes() == 2 && getDia() <= 29 && esBisiesto()) { // Si el día es mayor que 28, comprobamos si
																			// el año es bisiesto (en caso de que sea 29
																			// de febrero)
				correcta = true;
			} else if ((mesDe31()) && getDia() <= 31) { // Si no es febrero, comprobamos si es un mes de 31 días y el
														// rango es correcto
				correcta = true;
			} else if (getMes() != 2 && getDia() <= 30) { // Si no es un mes de 31 días, comprobamos que el rango sea
															// correcto para el resto de meses
				correcta = true;
			}
		}

		// Comprobamos que el mes sea correcto
		if (getMes() <= 0 || getMes() > 12) {
			correcta = false;
		}

		// Comprobamos que el año sea positivo
		if (getAnio() < 0) {
			correcta = false;
		}

		return correcta;
	}

	/**
	 * Método que calcula el día siguiente a la fecha introducida
	 */
	public void diaSiguiente() {
		if (this.dia == 31 && mesDe31()) { // Si es 31 de un mes de 31 días

			if (this.mes == 12) { // Y además es diciembre, debemos cambiar el año y hacer que sea 1 de enero
				this.dia = 1;
				this.mes = 1;
				this.anio++;

			} else { // Si no es 31 de diciembre, simplemente cambiamos de mes
				this.dia = 1;
				this.mes++;
			}
		}

		// Pero si no es 31 de un mes de 31 días, y en cambio es 29 de febrero de un
		// bisiesto, 28 de febrero de un año normal o día 30 de un mes de 30 días,
		// cambiamos la fecha
		else if ((this.dia == 29 && this.mes == 2 && esBisiesto()) || this.dia == 28 && this.mes == 2 && !esBisiesto()
				|| this.dia == 30 && this.mes != 2) {
			this.dia = 1;
			this.mes++;
		}
		// Si no se da ninguno de estos casos, es un día normal
		else {
			this.dia++;
		}
	}

	/**
	 * Método que comprueba si el mes introducido es o no un mes de 31 días
	 * 
	 * @return Devuelve un booleano en función de su mes-31-dad
	 */
	public boolean mesDe31() {
		boolean mesLargo = false;

		if (getMes() == 1 || getMes() == 3 || getMes() == 5 || getMes() == 7 || getMes() == 8 || getMes() == 10
				|| getMes() == 12) {
			mesLargo = true;
		}

		return mesLargo;
	}

	/**
	 * Método toString modificado para mostrar '0' delante de las fechas de un sólo
	 * dígito
	 */
	public String toString() {
		String formato = "";

		if (this.dia < 10) {
			formato = "0" + dia + "-" + mes + "-" + anio;
		} else if (this.mes < 10) {
			formato = dia + "-0" + mes + "-" + anio;
		}
		if (this.mes < 10 && this.dia < 10) {
			formato = "0" + dia + "-0" + mes + "-" + anio;
		}

		return formato;
	}

}
