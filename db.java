
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.table.DefaultTableModel;
/**
 * @author 
 *
 */
public class db {
	static String url;
	static String user;
	static String password;
	static String prestamista;
	
	public db(){
		url="jdbc:mysql://localhost:3306/";
		user="root";
		password="";
		prestamista = "";
	}
	
	
	/**
	 * @param carne
	 * @param pass
	 * @return nos dice si entra o no a su usuario.
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
	
	static ArrayList<Elemento> ListaElementos(){
		ArrayList<Elemento> elementos = new ArrayList<Elemento>();
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            //BASE A UTILIZAR
            stt.execute("USE CompuTePresta");
            ResultSet res = stt.executeQuery("SELECT * FROM articulo");
            
            while (res.next()){
            	Elemento reusable = new Elemento();
            	reusable.setElemento(res.getString("descripcion"), String.valueOf(res.getInt("tiempoDePrestamo")), res.getString("categoria"), res.getInt("idprestamista"));
            	elementos.add(reusable);
            }
            
            return elementos;
		}catch (Exception e){
			return elementos;
		}
        
	}
	public void Filtro(String filtro){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url,user,password);
			Statement stt = con.createStatement();
			
			stt.execute("USE CompuTePresta");
			stt.executeQuery("SELECT * FROM articulo WHERE categoria = "+filtro+" ");
			stt.close();
			con.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public DefaultTableModel crearmodelo(){
		DefaultTableModel model = new DefaultTableModel();
		Object[] titulos = new Object[4];
        
        titulos[0] = "DESCRIPCION";
        titulos[1] = "Tiempo de prestamo";
        titulos[2] = "Categoria";
        titulos[3] = "Carnet del prestamista";
        model.setColumnIdentifiers(titulos);
        
        Object[] rowData = new Object[4];
        
        for(int i = 0; i < ListaElementos().size(); i++){
            
            rowData[0] = ListaElementos().get(i).getDescripcion();
             rowData[1] = ListaElementos().get(i).getTiempoPrestamo() + "dias";
              rowData[2] = ListaElementos().get(i).getCategoria();
               rowData[3] = ListaElementos().get(i).getPrestamista();
               
               model.addRow(rowData);
        }
		return model;
	}

	/**
	 * @param carne
	 * @param pass
	 * @param nombre
	 * @param correo
	 * @param carrera
	 * Agrega un usuario nuevo a la base de datos
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
	
	/**
	 * @param descripcion
	 * @param tiempoPrestamo
	 * @param categoria
	 * @param prestamista
	 * Ingreso de elementos  a la base de datos
	 */
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
	 * Envia correo a el usuario al momento de olvidar la contraseña 
	 */
	public void enviarCorreo(int carnet, String sujeto, String mensaje, int x){
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
  //Envio de mensaje al olvidar el usuario
    			Message message = new MimeMessage(session);
    			message.setFrom(new InternetAddress("computepresta@gmail.com"));
    			message.setRecipients(Message.RecipientType.TO,
    				InternetAddress.parse(destino));
    			if (x==0){
    				message.setSubject(sujeto);
        			message.setText("Tu contrasena actual es,\n "+vc+"\n no la olvides la proxima vez!");
    			}else{
    				message.setSubject(sujeto);
        			message.setText(mensaje);
    			}
    			

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


