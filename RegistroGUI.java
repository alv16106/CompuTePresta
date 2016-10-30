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
import java.awt.Color;
import java.awt.SystemColor;

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
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearCuenta = new JLabel("\u00A1Bienvenido a");
		lblCrearCuenta.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		lblCrearCuenta.setBounds(161, 41, 139, 20);
		contentPane.add(lblCrearCuenta);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNombre.setBounds(148, 130, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(125, 181, 85, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblL = new JLabel("Carn\u00E9:");
		lblL.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblL.setBounds(159, 227, 51, 20);
		contentPane.add(lblL);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblCorreo.setBounds(159, 274, 51, 20);
		contentPane.add(lblCorreo);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblCarrera.setBounds(148, 331, 59, 20);
		contentPane.add(lblCarrera);
		
		textField = new JTextField();
		textField.setBounds(243, 129, 222, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(243, 178, 222, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(243, 226, 222, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(243, 273, 222, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(243, 330, 222, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnRegistrate = new JButton("Registrate");
		btnRegistrate.setBackground(new Color(0, 153, 255));
		btnRegistrate.setForeground(new Color(0, 0, 0));
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
		btnRegistrate.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnRegistrate.setBounds(465, 408, 146, 31);
		contentPane.add(btnRegistrate);
		
		JLabel lblComputepresta = new JLabel(" CompuTePresta!");
		lblComputepresta.setForeground(new Color(0, 0, 255));
		lblComputepresta.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		lblComputepresta.setBounds(298, 38, 167, 26);
		contentPane.add(lblComputepresta);
		
		JLabel lblLoPrimeroSer = new JLabel("\u00BFtodav\u00EDa sin cuenta? ...");
		lblLoPrimeroSer.setForeground(new Color(0, 153, 102));
		lblLoPrimeroSer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblLoPrimeroSer.setBounds(242, 72, 153, 14);
		contentPane.add(lblLoPrimeroSer);
	}

}
