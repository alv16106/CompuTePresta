
/**
 * @author toshibas
 *
 */
public class Errores {

	/**
	 * @param a
	 */
	
	public boolean Error1001(String a){
		boolean deci;
		
		try{
	
			int x = Integer.parseInt(a);
			deci = true;
			
		}
		catch(Exception e){
			
			deci = false; 
			
		}
		return deci;
	
	}
	
}
