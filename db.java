
import java.sql.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * @author 
 *
 */
public class db {
	String url;
	String user;
	String password;
	String prestamista;
	
	public db(){
		url="jdbc:mysql://localhost:3306/";
		user="root";
		password="";
		prestamista = "";
	}
	
	
	/**
	 * @param carne
	 * @param pass
	 * @return
	 */
	public boolean log(int carne, String pass){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            //BASE A UTILIZAR
            stt.execute("USE CompuTePresta");
            
            /**
             * Buscar usuario y contrasena
             */
            ResultSet res = stt.executeQuery("SELECT * FROM usuario WHERE carne="+carne+" AND password='"+pass+"'");
            
            int log=0;
            while (res.next())
            {
                log++;
                System.out.println(res.getString("nombre"));
                this.prestamista=res.getString("carne");
                System.out.println(prestamista);
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

	/**
	 * @param carne
	 * @param pass
	 * @param nombre
	 * @param correo
	 * @param carrera
	 */
	public void agregarUsuario(int carne, String pass, String nombre,String correo, String carrera) {
		        try
		        {
		        	Class.forName("com.mysql.jdbc.Driver").newInstance();
		            Connection con = DriverManager.getConnection(url, user, password);
		            Statement stt = con.createStatement();
		            
		            //BASE A UTILIZAR
		            stt.execute("USE CompuTePresta");
		            stt.execute("INSERT INTO usuario (id, carne, password, nombre, correo, carrera) VALUES" + 
		             "('0', '"+carne+"','"+pass+"','"+nombre+"','"+correo+"','"+carrera+"')");
	                stt.close();
	                con.close();
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
		    }
	
	public void agregarElemento(String descripcion, String tiempoPrestamo, String categoria,String prestamista){
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            //BASE A UTILIZAR
            stt.execute("USE CompuTePresta");
            stt.execute("INSERT INTO articulo (idarticulo, descripcion, tiempoDePrestamo, categoria, idprestamista) VALUES" + 
             "('0', '"+descripcion+"','"+tiempoPrestamo+"','"+categoria+"','"+Integer.parseInt(prestamista)+"')");
            //Integer.parseInt(this.prestamista)
            stt.close();
            con.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @param carnet
	 */
	public void enviarCorreo(int carnet){
		try
        {
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            //BASE A UTILIZAR
            stt.execute("USE CompuTePresta");
            ResultSet res = stt.executeQuery("SELECT password, correo FROM usuario WHERE carne='"+carnet+"'");
            String destino="computepresta@gmail.com", vc="";
            while (res.next()){
                destino=res.getString("correo");
                vc=res.getString("password");
            }
            
            //Se ingresa al correo de la aplicacion
            final String username = "computepresta@gmail.com";
    		final String password = "computepresta2017";

    		Properties props = new Properties();
    		props.put("mail.smtp.auth", "true");
    		props.put("mail.smtp.starttls.enable", "true");
    		props.put("mail.smtp.host", "smtp.gmail.com");
    		props.put("mail.smtp.port", "587");

    		Session session = Session.getInstance(props,
    		  new javax.mail.Authenticator() {
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication(username, password);
    			}
    		  });

    		try {

    			Message message = new MimeMessage(session);
    			message.setFrom(new InternetAddress("computepresta@gmail.com"));
    			message.setRecipients(Message.RecipientType.TO,
    				InternetAddress.parse(destino));
    			message.setSubject("Al parecer has olvidado tu contrasena!");
    			message.setText("Tu contrasena actual es,\n "+vc+"\n no la olvides la proxima vez!");

    			Transport.send(message);

    			System.out.println("Done");
                res.close();
                stt.close();
                con.close();

    		} catch (MessagingException e) {
    			throw new RuntimeException(e);
    		}
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
	/**
	 * @param carnet
	 * @param password
	 * @param nombre
	 * @param correo
	 * @param carrera
	 */
	public void editarPerfil(int carnet, String password, String nombre,String correo, String carrera){
		try
        {
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            //BASE A UTILIZAR
            stt.execute("USE CompuTePresta");
            stt.executeUpdate("UPDATE usuario SET password='"+password+"', nombre='"+nombre+"', correo='"+correo+"', carrera'"+carrera+"'"
            		+ "WHERE carne='"+carnet+"'");
            stt.close();
            con.close();
            
        }catch (Exception e){
        	
        }
	}
		
	}


