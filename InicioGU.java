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

/**
 * @author rodri_000
 *
 */
/**
 * @author rodri_000
 *
 */
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
		db base = new db();
		RegistroGUI reg = new RegistroGUI();
		principalGUI principal=new principalGUI();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(200, 93, 176, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(74, 96, 69, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(74, 138, 100, 20);
		contentPane.add(lblPassword);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(/**
		 * @author rodri_000
		 *
		 */
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int user = Integer.parseInt(txtUsuario.getText());
				String pass = txtPassword.getText();
				if(base.log(user, pass)){
					JOptionPane.showMessageDialog(login,"Gracias por visitarnos de nuevo!","Ingreso exitoso",JOptionPane.INFORMATION_MESSAGE);
					principal.setVisible(true);
					setVisible(false);
					
				}else{
					JOptionPane.showMessageDialog(login,"Error: No se ha podido iniciar sesion","Error de inicio",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnIngresar.setBounds(74, 257, 127, 60);
		contentPane.add(btnIngresar);
		
		JButton btnRegistro = new JButton("Registrate");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg.setVisible(true);
				
			}
		});
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnRegistro.setBounds(255, 257, 152, 60);
		contentPane.add(btnRegistro);
		
		JButton btnOlvidar = new JButton("Olvide mi contrase\u00F1a ");
		btnOlvidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String whatTheUserEntered = JOptionPane.showInputDialog("Ingrese su carne:");
				if (whatTheUserEntered == null) {
				    System.out.println("The user canceled");
				}
				base.enviarCorreo(Integer.parseInt(whatTheUserEntered));
				
			}
		});
		btnOlvidar.setForeground(Color.BLUE);
		btnOlvidar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOlvidar.setBounds(94, 187, 223, 29);
		contentPane.add(btnOlvidar);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(200, 135, 176, 26);
		contentPane.add(txtPassword);
	}
}
