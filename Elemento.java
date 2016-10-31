/**
 * @author Rodrigo Alvarado, Sergio Marchena, Carlos Arroyave, Pablo Viana y Michelle Bloomfield 
 *
 */
public class Elemento {
	private String descripcion;
	private String tiempoPrestamo;
	private String categoria;
	private int prestamista;
	
	public Elemento() {
	descripcion = "";
	tiempoPrestamo = "";
	categoria = "";
	prestamista = 0;
	}
//Setters y Getters de los atributos anteriores 
	
	/**
	 * @param descripcion
	 * @param tiempoPrestamo
	 * @param categoria
	 */
	public void setElemento(String descripcion, String tiempoPrestamo, String categoria, int prestamista){
		this.descripcion = descripcion;
		this.tiempoPrestamo = tiempoPrestamo; 
		this.categoria = categoria;
		this.prestamista=prestamista;
	}
	/**
	 * @return regresa la descripcion del elemento
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return regresa el tiempo que se prestara el elemento
	 */
	public String getTiempoPrestamo() {
		return tiempoPrestamo;
	}

	/**
	 * @param tiempoPrestamo
	 */
	public void setTiempoPrestamo(String tiempoPrestamo) {
		this.tiempoPrestamo = tiempoPrestamo;
	}

	/**
	 * @return regresa la categoria en la que esta el objeto 
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getPrestamista(){
		return prestamista;
	}
}
