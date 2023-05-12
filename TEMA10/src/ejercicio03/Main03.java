package ejercicio03;

/**
 * Clase main desde la que vamos a probar los métodos de 'Fecha'
 * @author frodriguez
 *
 */
public class Main03 {

	public static void main(String[] args) {
		//Creamos un objeto de tipo Fecha
		Fecha primera = new Fecha(10, 1, 1996);
		
		//Si la fecha no es correcta, imprimimos un mensaje de error
		if (!primera.fechaCorrecta()) {
			System.err.println("La fecha introducida es incorrecta.");
		} else { //Si la fecha es correcta, lo indicamos
			System.out.println("La fecha introducida es correcta.");
			
			//Si el año es bisiesto, lo indicamos
			if (primera.esBisiesto()) {
				System.out.println("El año introducido es bisiesto.");
			} else { //Si el año no es bisiesto, se le indica al usuario
				System.out.println("El año introducido no es bisiesto");
			}
			
			//Aumentamos la fecha en un día
			primera.diaSiguiente();
			System.out.println("El día siguiente será el " + primera.toString());
		}
	}

}
