package examen;

/**
 * Clase que determina los atributos y métodos de los objetos Medicamento.
 * Implementa la interfaz 'Comparable'
 * 
 * @author frodriguez
 *
 */
public class Medicamento implements Comparable<Object> {

	private int codigo = 0; // Atributo privado 'código', no puede repetirse
	private String nombre = "medicamento"; // Atributo privado 'nombre'
	private String descripcion = "Medicina que te cura"; // Atributo privado 'descripcion'
	private double precio = 15; // Atributo privado 'precio'
	private String posologia = "Niño no te quejes y tomate la jeringuilla"; // Atributo privado 'posologia'

	/**
	 * Constructor por defecto
	 */
	public Medicamento() {
	}

	/**
	 * Constructor de objetos 'Medicamento' con sólo el código
	 * 
	 * @param codigo Recibe el código del objeto a crear
	 */
	public Medicamento(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Constructor completo de objetosn 'Medicamento'
	 * 
	 * @param codigo      Código del medicamento
	 * @param nombre      Nombre del medicamento
	 * @param descripcion Descripción del medicamento
	 * @param precio      Precio del medicamento
	 * @param posologia   Posología del medicamento
	 */
	public Medicamento(int codigo, String nombre, String descripcion, double precio, String posologia) {
		this.codigo = codigo;
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setPosologia(posologia);
	}

	/**
	 * Método getter para obtener el código del medicamento
	 * 
	 * @return Devuelve el código del medicamento introducido
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Método setter del código del medicamento, no comprueba nada porque ya se
	 * comprueba en el main
	 * 
	 * @param codigo Recibe el código a introducir del medicamento
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Método getter para obtener el nombre del medicamento
	 * 
	 * @return Devuelve el nombre del medicamento introducido
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter del nombre del medicamento, comprueba que el valor a introducir
	 * sea correcto
	 * 
	 * @param nombre Recibe el nombre a introducir del medicamento
	 */
	public void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre;
		}
	}

	/**
	 * Método getter para obtener la descripción del medicamento
	 * 
	 * @return Devuelve la descripción del medicamento introducido
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Método setter de la descripción del medicamento, comprueba que el valor a
	 * introducir no sea null
	 * 
	 * @param descripcion Recibe la descripción a introducir del medicamento
	 */
	public void setDescripcion(String descripcion) {
		if (nombre != null) {
			this.descripcion = descripcion;
		}
	}

	/**
	 * Método getter para obtener el precio del medicamento
	 * 
	 * @return Devuelve el precio del medicamento introducido
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Método setter del precio del medicamento, comprueba que el valor a introducir
	 * sea correcto
	 * 
	 * @param precio Recibe el precio a introducir del medicamento
	 */
	public void setPrecio(double precio) {
		if (precio > 0) {
			this.precio = precio;
		}
	}

	/**
	 * Método getter para obtener la posología del medicamento
	 * 
	 * @return Devuelve la posología del medicamento introducido
	 */
	public String getPosologia() {
		return posologia;
	}

	/**
	 * Método setter de la posología del medicamento, comprueba que el valor
	 * introducido no sea null
	 * 
	 * @param posologia Recibe la posología a introducir del medicamento
	 */
	public void setPosologia(String posologia) {
		if (posologia != null) {
			this.posologia = posologia;
		}
	}

	/**
	 * Método toString del objeto medicamento
	 * 
	 * @return Devuelve una cadena con todos los datos del medicamento
	 */
	@Override
	public String toString() {
		String cadena = "";

		cadena += "Código: " + codigo + "\nNombre: " + nombre + "\nDescripción: " + descripcion + "\nPrecio: " + precio
				+ "\nPosología: " + posologia + "\n==========================";

		return cadena;
	}

	/**
	 * Método equals del objeto medicamento
	 * 
	 * @param Recibe un objetod de tipo Object
	 * @return Devuelve un booleano en función de si los objetos comparados son
	 *         iguales o no
	 */
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;

		Medicamento med = (Medicamento) obj;
		if (this.codigo == med.codigo) {
			iguales = true;
		}

		return iguales;
	}

	/**
	 * Método compareTo del objeto medicamento
	 * 
	 * @param Recibe un objeto de tipo Object
	 * @return Devuelve un entero en función del resultado de la comparación
	 */
	@Override
	public int compareTo(Object o) {
		int res = 0;

		Medicamento med = (Medicamento) o;

		if (this.codigo > med.codigo) {
			res = 1;
		} else {
			res = -1;
		}

		return res;
	}

}
