/**
 * @author Rodrigo Alvarado, Sergio Marchena, Carlos Arroyave, Pablo Viana y Michelle Bloomfield 
 *
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class InicioGU extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private InicioGU login;
	private db base;
	private JPasswordField txtPassword;
	private RegistroGUI reg;
	private principalGUI principal;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioGU login = new InicioGU();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioGU() {
		setBackground(Color.WHITE);
		setForeground(Color.RED);
		db base = new db();
		RegistroGUI reg = new RegistroGUI();
		principalGUI principal=new principalGUI();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setBounds(270, 96, 176, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Carn\u00E9");
		lblUsuario.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblUsuario.setBounds(161, 99, 69, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblPassword.setBounds(161, 133, 100, 20);
		contentPane.add(lblPassword);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBackground(Color.ORANGE);
		btnIngresar.addActionListener(/**
		 * @author rodri_000
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Errores errores = new Errores();

				boolean a,b;
				a = errores.Letra(txtUsuario.getText());
				b = errores.Letra(txtPassword.getText());
				
				
				if (a || b){
					JOptionPane.showMessageDialog(null, "ERROR 1005: INGRESE TODOS LOS CAMPOS");
				} 
				else {
				
				int user = Integer.parseInt(txtUsuario.getText());
				String pass = txtPassword.getText();
				
				if(base.log(user, pass)){
					JOptionPane.showMessageDialog(login,"Gracias por visitarnos de nuevo!","Ingreso exitoso",JOptionPane.INFORMATION_MESSAGE);
					principal.setVisible(true);
					setVisible(false);
					
				}else{
					JOptionPane.showMessageDialog(login,"Error 1007: SU CONTRASEÑA ES INCORRECTA O USARIO","Error de inicio",JOptionPane.ERROR_MESSAGE);
				}
				
				}
				
				
			}
		});
		btnIngresar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 23));
		btnIngresar.setBounds(361, 241, 152, 69);
		contentPane.add(btnIngresar);
		
		JButton btnRegistro = new JButton("<html>\r\n<p align = center>Registrate <br> <p align = center>con nosotros\r\n</html>\r\n");
		btnRegistro.setBackground(Color.ORANGE);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg.setVisible(true);
				
			}
		});
		btnRegistro.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		btnRegistro.setBounds(109, 241, 152, 69);
		contentPane.add(btnRegistro);
		
		JButton btnOlvidar = new JButton("Olvide mi contrase\u00F1a ");
		btnOlvidar.setBackground(Color.ORANGE);
		btnOlvidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String whatTheUserEntered = JOptionPane.showInputDialog("Ingrese su carne:");
				if (whatTheUserEntered == null) {
				    System.out.println("The user canceled");
				}else{
					base.enviarCorreo(Integer.parseInt(whatTheUserEntered), "Al parecer has olvidado tu contrasena","El usuario xxx ha respondido a tu peticion de ",1);
				}
				
				
			}
		});
		btnOlvidar.setForeground(Color.BLUE);
		btnOlvidar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnOlvidar.setBounds(184, 186, 223, 29);
		contentPane.add(btnOlvidar);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(270, 133, 176, 26);
		contentPane.add(txtPassword);
		
		JLabel lblBienvenidoACompu = new JLabel("Bienvenido a Compu Te Presta ");
		lblBienvenidoACompu.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		lblBienvenidoACompu.setBounds(126, 33, 387, 20);
		contentPane.add(lblBienvenidoACompu);
	}
}
