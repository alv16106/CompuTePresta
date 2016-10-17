/**
 * @author Rodrigo Alvarado, Sergio Marchena, Carlos Arroyave, Pablo Viana y Michelle Bloomfield 
 *
 */

public class Prestamo {
	private Persona persona;
	private Elemento elemento;
	private int fecha;
	private String peticiones;
	
	@SuppressWarnings("unused")
	public Prestamo() {
		// TODO Auto-generated constructor stub
		Persona persona = new Persona(); 
		Elemento elemento = new Elemento();
		fecha = 0;
		peticiones = "";
	}
	
	/**
	 * @param persona
	 * @param elemento
	 * @param fecha
	 * @param peticiones
	 */
	public void setPrestamo(Persona persona, Elemento elemento, int fecha, String peticiones){
		this.persona = persona; 
		this.elemento = elemento;
		this.fecha = fecha; 
		this.peticiones = peticiones;
	}

	/**
	 * @return regresa la persona que presta 
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return regresa el elemento que va a presar 
	 */
	public Elemento getElemento() {
		return elemento;
	}

	/**
	 * @param elemento
	 */
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	/**
	 * @return retorna la fecha que desaea recuperar el elemento 
	 */
	public int getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 */
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return regresa las peticiones 
	 */
	public String getPeticiones() {
		return peticiones;
	}

	/**
	 * @param peticiones
	 */
	public void setPeticiones(String peticiones) {
		this.peticiones = peticiones;
	}

}
