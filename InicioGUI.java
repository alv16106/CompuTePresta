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
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class InicioGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioGUI frame = new InicioGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioGUI() {
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
		
		txtPassword = new JTextField();
		txtPassword.setBounds(200, 135, 176, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(74, 138, 100, 20);
		contentPane.add(lblPassword);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnIngresar.setBounds(74, 257, 127, 60);
		contentPane.add(btnIngresar);
		
		JButton btnRegistro = new JButton("Registrate");
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnRegistro.setBounds(255, 257, 152, 60);
		contentPane.add(btnRegistro);
		JOptionPane.showMessageDialog(frame,"Eggs are not supposed to be green.","Inane error",JOptionPane.ERROR_MESSAGE);
		
		JButton btnOlvidar = new JButton("Olvide mi contrase\u00F1a ");
		btnOlvidar.setForeground(Color.BLUE);
		btnOlvidar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOlvidar.setBounds(94, 187, 223, 29);
		contentPane.add(btnOlvidar);
	}
}
