import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPasswordField;

public class principalGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTable table;
	private JTextField txtNombrePerfil;
	private JTextField txtCorreoPerfil;
	private JTextField txtCarreraPerfil;
	private principalGUI principal;
	private JTextField txtCarnetPerfil;
	private JPasswordField txtContraPerfil;
	private db base;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principalGUI frame = new principalGUI();
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
	@SuppressWarnings("unchecked")
	public principalGUI() {
		db base = new db();
		//principalGUI principal=new principalGUI();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelPedir = new JPanel();
		tabbedPane.addTab("Pedir", null, panelPedir, null);
		panelPedir.setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoria.setBounds(127, 40, 68, 14);
		panelPedir.add(lblCategoria);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescripcion.setBounds(114, 77, 81, 20);
		panelPedir.add(lblDescripcion);
		
		JLabel lblTiempoP = new JLabel("Tiempo de Prestamo:");
		lblTiempoP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTiempoP.setBounds(45, 210, 150, 14);
		panelPedir.add(lblTiempoP);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[]{"Libros","Tutoria","Electronicos","Utiles"}));
		comboBoxCategoria.setBounds(230, 38, 96, 20);
		panelPedir.add(comboBoxCategoria);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(230, 75, 261, 107);
		panelPedir.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JSpinner spinnerDias = new JSpinner();
		spinnerDias.setBounds(230, 208, 61, 20);
		panelPedir.add(spinnerDias);
		
		JButton btnPedir = new JButton("Pedir");
		btnPedir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPedir.setBounds(230, 256, 228, 50);
		panelPedir.add(btnPedir);
		
		JPanel panelDar = new JPanel();
		tabbedPane.addTab("Dar", null, panelDar, null);
		panelDar.setLayout(null);
		
		JLabel lblCategoriaDar = new JLabel("Categor\u00EDa:");
		lblCategoriaDar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCategoriaDar.setBounds(151, 240, 64, 26);
		panelDar.add(lblCategoriaDar);
		
		JComboBox comboBoxCategoriaDar = new JComboBox();
		comboBoxCategoriaDar.setModel(new DefaultComboBoxModel(new String[]{"Libros","Tutoria","Electronicos","Utiles"}));
		comboBoxCategoriaDar.setBounds(240, 244, 114, 20);
		panelDar.add(comboBoxCategoriaDar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(362, 11, -312, 121);
		panelDar.add(scrollPane);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setBounds(390, 221, 133, 63);
		panelDar.add(btnBuscar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 11, 572, 199);
		panelDar.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JPanel panelPerfil = new JPanel();
		tabbedPane.addTab("Perfil", null, panelPerfil, null);
		panelPerfil.setLayout(null);
		
		JLabel lblNombrePerfil = new JLabel("Nombre:");
		lblNombrePerfil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombrePerfil.setBounds(58, 106, 68, 42);
		panelPerfil.add(lblNombrePerfil);
		
		JLabel lblContraPerfil = new JLabel("Contrase\u00F1a:");
		lblContraPerfil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContraPerfil.setBounds(58, 167, 95, 14);
		panelPerfil.add(lblContraPerfil);
		
		JLabel lblCorreoPerfil = new JLabel("Correo:");
		lblCorreoPerfil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCorreoPerfil.setBounds(58, 198, 68, 34);
		panelPerfil.add(lblCorreoPerfil);
		
		JLabel lblCarreraPerfil = new JLabel("Carrera:");
		lblCarreraPerfil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCarreraPerfil.setBounds(58, 243, 68, 34);
		panelPerfil.add(lblCarreraPerfil);
		
		txtNombrePerfil = new JTextField();
		txtNombrePerfil.setBounds(192, 120, 150, 20);
		panelPerfil.add(txtNombrePerfil);
		txtNombrePerfil.setColumns(10);
		
		txtCorreoPerfil = new JTextField();
		txtCorreoPerfil.setBounds(193, 208, 150, 20);
		panelPerfil.add(txtCorreoPerfil);
		txtCorreoPerfil.setColumns(10);
		
		txtCarreraPerfil = new JTextField();
		txtCarreraPerfil.setBounds(193, 253, 150, 20);
		panelPerfil.add(txtCarreraPerfil);
		txtCarreraPerfil.setColumns(10);
		
		JButton btnEditarPerfil = new JButton("Editar Perfil");
		btnEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				//
				int carne=Integer.parseInt(txtCarnetPerfil.getText());
				String password=txtContraPerfil.getText();
				String nombre=txtNombrePerfil.getText();
				String correo=txtCorreoPerfil.getText();
				String carrera=txtCarreraPerfil.getText();
				
				base.editarPerfil(carne, password, nombre, correo, carrera);
			}
		});
		btnEditarPerfil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEditarPerfil.setBounds(433, 125, 149, 64);
		panelPerfil.add(btnEditarPerfil);
		
		txtCarnetPerfil = new JTextField();
		txtCarnetPerfil.setColumns(10);
		txtCarnetPerfil.setBounds(192, 21, 150, 20);
		panelPerfil.add(txtCarnetPerfil);
		
		JLabel label = new JLabel("Carn\u00E9:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(58, 11, 59, 34);
		panelPerfil.add(label);
		
		txtContraPerfil = new JPasswordField();
		txtContraPerfil.setBounds(192, 167, 150, 20);
		panelPerfil.add(txtContraPerfil);
	}
}
