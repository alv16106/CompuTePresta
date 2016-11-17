import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

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
	private JTextField txtCarnePedir;
	private JComboBox comboBoxCategoriaDar;

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
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public principalGUI() {
		base = new db();
		//principalGUI principal=new principalGUI();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(173, 255, 47));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelDar = new JPanel();
		panelDar.setBackground(new Color(240, 230, 140));
		tabbedPane.addTab("Dar", null, panelDar, null);
		panelDar.setLayout(null);
		
		JLabel lblCategoriaDar = new JLabel("Categor\u00EDa:");
		lblCategoriaDar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblCategoriaDar.setBounds(244, 270, 64, 26);
		panelDar.add(lblCategoriaDar);
		
		comboBoxCategoriaDar = new JComboBox();
		comboBoxCategoriaDar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		comboBoxCategoriaDar.setModel(new DefaultComboBoxModel(new String[]{"Libros","Tutoria","Electronicos","Utiles"}));
		comboBoxCategoriaDar.setBounds(336, 273, 114, 20);
		panelDar.add(comboBoxCategoriaDar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(362, 11, -312, 121);
		panelDar.add(scrollPane);
		
		JButton btnBuscar = new JButton("Dar!");
		btnBuscar.addActionListener(new botonlist());
		btnBuscar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnBuscar.setBounds(236, 309, 214, 26);
		panelDar.add(btnBuscar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(41, 66, 572, 199);
		panelDar.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(base.crearmodelo());
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setModel(base.crearmodelo());
			}
		});
		btnActualizar.setBounds(51, 281, 148, 54);
		panelDar.add(btnActualizar);
		
		JLabel lblDeseeasAportarA = new JLabel("DESEEAS AYUDAR A UN COMPA\u00D1ERO?");
		lblDeseeasAportarA.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDeseeasAportarA.setBounds(143, 11, 450, 20);
		panelDar.add(lblDeseeasAportarA);
		
		JLabel lblEligue = new JLabel("Elige una de las opciones si deseas aportar");
		lblEligue.setBounds(180, 30, 433, 20);
		panelDar.add(lblEligue);
		
		JPanel panelPedir = new JPanel();
		panelPedir.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		panelPedir.setBackground(new Color(255, 127, 80));
		tabbedPane.addTab("Pedir", null, panelPedir, null);
		panelPedir.setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa:");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setForeground(new Color(0, 0, 0));
		lblCategoria.setBackground(new Color(0, 0, 0));
		lblCategoria.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		lblCategoria.setBounds(136, 99, 67, 20);
		panelPedir.add(lblCategoria);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		lblDescripcion.setBounds(136, 135, 81, 20);
		panelPedir.add(lblDescripcion);
		
		JLabel lblTiempoP = new JLabel("Tiempo de Prestamo:");
		lblTiempoP.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		lblTiempoP.setBounds(85, 259, 175, 14);
		panelPedir.add(lblTiempoP);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBackground(Color.WHITE);
		comboBoxCategoria.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[]{"Libros","Tutoria","Electronicos","Utiles"}));
		comboBoxCategoria.setBounds(230, 100, 175, 20);
		panelPedir.add(comboBoxCategoria);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescripcion.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 11));
		txtDescripcion.setBounds(230, 136, 261, 107);
		panelPedir.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JSpinner spinnerDias = new JSpinner();
		spinnerDias.setBounds(227, 256, 61, 20);
		panelPedir.add(spinnerDias);
		
		JButton btnPedir = new JButton("\u00A1Pedir a la comunidad!");
		btnPedir.setForeground(new Color(0, 0, 255));
		btnPedir.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				
				
				String categoria=comboBoxCategoria.getSelectedItem().toString();
				String descripcion= txtDescripcion.getText();
				String tiempoPrestamo = spinnerDias.getValue().toString();
				String carne1=txtCarnePedir.getText();
				
				base.agregarElemento(descripcion, tiempoPrestamo, categoria,carne1);
				
				
				
			}
		});
		btnPedir.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnPedir.setBounds(230, 306, 218, 29);
		panelPedir.add(btnPedir);
		
		txtCarnePedir = new JTextField();
		txtCarnePedir.setBounds(405, 256, 86, 20);
		panelPedir.add(txtCarnePedir);
		txtCarnePedir.setColumns(10);
		
		JLabel lblCarnePedir = new JLabel("Carn\u00E9:");
		lblCarnePedir.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		lblCarnePedir.setBounds(358, 259, 46, 14);
		panelPedir.add(lblCarnePedir);
		
		JLabel lblDias = new JLabel("dias");
		lblDias.setBounds(293, 256, 69, 20);
		panelPedir.add(lblDias);
		
		JLabel lblIngresaLoQue = new JLabel("INGRESA LO QUE DESEES PEDIR");
		lblIngresaLoQue.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblIngresaLoQue.setBounds(136, 39, 371, 20);
		panelPedir.add(lblIngresaLoQue);
		
		JPanel panelPerfil = new JPanel();
		panelPerfil.setBackground(new Color(222, 184, 135));
		tabbedPane.addTab("Perfil", null, panelPerfil, null);
		panelPerfil.setLayout(null);
		
		JLabel lblNombrePerfil = new JLabel("Nombre:");
		lblNombrePerfil.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNombrePerfil.setBounds(58, 99, 68, 42);
		panelPerfil.add(lblNombrePerfil);
		
		JLabel lblContraPerfil = new JLabel("Contrase\u00F1a:");
		lblContraPerfil.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblContraPerfil.setBounds(31, 157, 95, 14);
		panelPerfil.add(lblContraPerfil);
		
		JLabel lblCorreoPerfil = new JLabel("Correo:");
		lblCorreoPerfil.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblCorreoPerfil.setBounds(321, 147, 68, 34);
		panelPerfil.add(lblCorreoPerfil);
		
		JLabel lblCarreraPerfil = new JLabel("Carrera:");
		lblCarreraPerfil.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblCarreraPerfil.setBounds(58, 187, 68, 34);
		panelPerfil.add(lblCarreraPerfil);
		
		txtNombrePerfil = new JTextField();
		txtNombrePerfil.setBounds(149, 110, 150, 20);
		panelPerfil.add(txtNombrePerfil);
		txtNombrePerfil.setColumns(10);
		
		txtCorreoPerfil = new JTextField();
		txtCorreoPerfil.setBounds(399, 154, 150, 20);
		panelPerfil.add(txtCorreoPerfil);
		txtCorreoPerfil.setColumns(10);
		
		txtCarreraPerfil = new JTextField();
		txtCarreraPerfil.setBounds(149, 194, 150, 20);
		panelPerfil.add(txtCarreraPerfil);
		txtCarreraPerfil.setColumns(10);
		
		JButton btnEditarPerfil = new JButton("Editar Perfil");
		btnEditarPerfil.setForeground(new Color(0, 0, 128));
		btnEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				//
				
		Errores errores = new Errores();
				
				boolean f,g,h,i;	
				f = errores.Letra(txtNombrePerfil.getText());
				g = errores.Letra(txtContraPerfil.getText());
				h = errores.Letra(txtCorreoPerfil.getText());
				i = errores.Letra(txtCarreraPerfil.getText());
				if(  f || g || h || i){
					JOptionPane.showMessageDialog(null, "ERROR 1005: INGRESE TODOS LOS CAMPOS");
				}
				
					else{
					int carne=Integer.parseInt(txtCarnetPerfil.getText());
				String password=txtContraPerfil.getText();
				String nombre=txtNombrePerfil.getText();
				String correo=txtCorreoPerfil.getText();
				String carrera=txtCarreraPerfil.getText();
				
				base.editarPerfil(carne, password, nombre, correo, carrera);
					
					}
				}
				
				
				
				
				
				
				
				
				
				
				
			
		});
		btnEditarPerfil.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		btnEditarPerfil.setBounds(451, 261, 149, 26);
		panelPerfil.add(btnEditarPerfil);
		
		txtCarnetPerfil = new JTextField();
		txtCarnetPerfil.setColumns(10);
		txtCarnetPerfil.setBounds(399, 110, 150, 20);
		panelPerfil.add(txtCarnetPerfil);
		
		JLabel label = new JLabel("Carn\u00E9:");
		label.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		label.setBounds(321, 103, 59, 34);
		panelPerfil.add(label);
		
		txtContraPerfil = new JPasswordField();
		txtContraPerfil.setBounds(149, 154, 150, 20);
		panelPerfil.add(txtContraPerfil);
		
		JLabel lblalgoNoEsta = new JLabel("\u00BFAlgo no esta bien? \u00A1se puede editar tu perfil aqu\u00ED! -->");
		lblalgoNoEsta.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblalgoNoEsta.setForeground(new Color(0, 0, 139));
		lblalgoNoEsta.setBounds(131, 268, 315, 14);
		panelPerfil.add(lblalgoNoEsta);
		
		JLabel lblCambiaTuPerfil = new JLabel("CAMBIA TU PERFIL ");
		lblCambiaTuPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambiaTuPerfil.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCambiaTuPerfil.setBounds(0, 39, 655, 20);
		panelPerfil.add(lblCambiaTuPerfil);
	}
	
	 private class botonlist implements ActionListener{
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	            int x=table.getSelectedRow();
	            System.out.println(x);
	            int carne = Integer.parseInt(table.getValueAt(x, 3).toString());
	            System.out.println(carne);
	            String d=table.getValueAt(x, 0).toString();
	            System.out.println(d);
	            String peticion = "El usuario xxx ha respondido a tu peticion de " + d;
	            base.enviarCorreo(carne,"Alguien respondio a tu pedido!", peticion, 2);
	        }
	        
	    }
}
