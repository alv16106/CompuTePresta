import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author toshibas
 *
 */
public class Errores {

	/**
	 * @param a
	 */
	
	public boolean BlancoNumero(String a){
		
		try{
	
			int x = Integer.parseInt(a);
			return true;
			
		}
		catch(Exception e){
			
			return false;
			
		}
		
	
	}
	
	public boolean Existe(int a){
		try{
			String url="jdbc:mysql://localhost:3306/";
			String user="root";
			String password="";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            //BASE A UTILIZAR
            stt.execute("USE CompuTePresta");
            
            /**
             * Buscar usuario y contrasena
             */
            ResultSet res = stt.executeQuery("SELECT * FROM usuario WHERE carne="+a+"");
            
            int log=0;
            while (res.next())
            {
                log++;
                

            }
            if (log==1){
                res.close();
                stt.close();
                con.close();
            	return true;
            }else{
                res.close();
                stt.close();
                con.close();
            	return false;
            }

		}catch (Exception e){
			return false;
		}
	}
		
	public boolean Letra(String a){

			
			if (a.equals("")){
				return true;
			}
			else{
				return false;
			}
		
		}
		
	
}
