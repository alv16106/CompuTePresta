/**
 * @author Rodrigo Alvarado, Sergio Marchena, Carlos Arroyave, Pablo Viana y Michelle Bloomfield 
 *
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private db base;
	//private RegistroGUI reg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroGUI reg = new RegistroGUI();
					reg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroGUI() {
		db base = new db();
		//RegistroGUI reg = new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearCuenta = new JLabel("Crear cuenta");
		lblCrearCuenta.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCrearCuenta.setBounds(174, 41, 174, 20);
		contentPane.add(lblCrearCuenta);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(48, 106, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setBounds(48, 155, 85, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblL = new JLabel("Carn\u00E9:");
		lblL.setBounds(48, 204, 69, 20);
		contentPane.add(lblL);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(48, 247, 69, 20);
		contentPane.add(lblCorreo);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setBounds(48, 296, 69, 20);
		contentPane.add(lblCarrera);
		
		textField = new JTextField();
		textField.setBounds(184, 103, 222, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 152, 222, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 201, 222, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(184, 244, 222, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(184, 293, 222, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnRegistrate = new JButton("Registrate");
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int carne=Integer.parseInt(textField_2.getText());
				String password=textField_1.getText();
				String nombre=textField.getText();
				String correo=textField_3.getText();
				String carrera=textField_4.getText();
				
				base.agregarUsuario(carne, password, nombre, correo, carrera);
				//JOptionPane.showMessageDialog(this,"Gracias por registrarse "+nombre+"","",JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
				//reg.setState(reg.ICONIFIED);
			}
		});
		btnRegistrate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistrate.setBounds(452, 184, 146, 59);
		contentPane.add(btnRegistrate);
	}

}
