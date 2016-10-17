
/**
 * @author Rodrigo Alvarado, Sergio Marchena, Carlos Arroyave, Pablo Viana y Michelle Bloomfield 
 *
 */

public class Persona {
	private String nombre;
	private String correo;
	private String carrera;
	private int carne;
	private Elemento elemento;
	private String password;
	
	@SuppressWarnings("unused")
	public Persona() {
		// TODO Auto-generated constructor stub
		nombre = "";
		correo = "";
		carrera = "";
		carne = 0;
		Elemento elemento = new Elemento();
		password = "";
	}
//Setters y getters de los atributos anterior
	
/**
 * @param nombre
 * @param correo
 * @param carrera
 * @param Elemento
 * @param password
 * @param carne
 * @param elemento
 */
public void setPersona(String nombre, String correo, String carrera, int Elemento, String password, int carne, Elemento elemento){
	this.nombre = nombre;
	this.correo = correo;
	this.carrera = carrera;
	this.carne = carne;
	this.elemento = elemento;
	this.password = password;
}
	
	/**
	 * @return regresa el nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return regresa el correo de la persona
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return regresa la carrerra de la persona 
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	/**
	 * @return regresa el carne de la persona 
	 */
	public int getCarne() {
		return carne;
	}

	/**
	 * @param carne
	 */
	public void setCarne(int carne) {
		this.carne = carne;
	}

	/**
	 * @return regresa el elemento que desea prestar 
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
	 * @return regresa la contraseña de persona 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
