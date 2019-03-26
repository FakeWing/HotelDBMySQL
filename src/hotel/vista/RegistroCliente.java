package hotel.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotel.vista.Menu;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdatepicker.JDatePicker;


public class RegistroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtRut;
	private JTextField txtNombre;
	private JTextField txtApellidoP;
	private JTextField txtApellidoM;
	private JTextField txtSexo;
	private JTextField txtFechaNacimiento;
	private JTextField txtNacionalidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCliente frame = new RegistroCliente();
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
	public RegistroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistrar.setBounds(80, 580, 121, 44);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(336, 580, 121, 44);
		contentPane.add(btnVolver);
		 btnVolver.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnVolverActionPerformed(evt);
	            }
	        });
		
		JLabel lblRut = new JLabel("Rut:");
		lblRut.setBounds(100, 139, 46, 14);
		contentPane.add(lblRut);
		
		txtRut = new JTextField();
		txtRut.setBounds(247, 139, 167, 20);
		contentPane.add(txtRut);
		txtRut.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(247, 178, 167, 20);
		contentPane.add(txtNombre);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(100, 178, 64, 14);
		contentPane.add(lblNombres);
		
		txtApellidoP = new JTextField();
		txtApellidoP.setColumns(10);
		txtApellidoP.setBounds(247, 213, 167, 20);
		contentPane.add(txtApellidoP);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(100, 213, 101, 14);
		contentPane.add(lblApellidoPaterno);
		
		txtApellidoM = new JTextField();
		txtApellidoM.setColumns(10);
		txtApellidoM.setBounds(247, 248, 167, 20);
		contentPane.add(txtApellidoM);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(98, 248, 103, 14);
		contentPane.add(lblApellidoMaterno);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(247, 283, 167, 20);
		contentPane.add(txtSexo);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(100, 286, 46, 14);
		contentPane.add(lblSexo);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(247, 322, 167, 20);
		contentPane.add(txtFechaNacimiento);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(98, 322, 121, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(247, 357, 167, 20);
		contentPane.add(txtNacionalidad);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(100, 357, 82, 14);
		contentPane.add(lblNacionalidad);
	}
	

	protected void btnRegistrarActionPerformed(ActionEvent evt) {
		
		hotel.controlador.CRUD c=new hotel.controlador.CRUD();
    	
		int rut= Integer.parseInt(txtRut.getText());
    	String nombre=txtNombre.getText();
    	String apellidoP=txtApellidoP.getText();
    	String apellidoM=txtApellidoM.getText();
    	String sexo= txtSexo.getText();
    	String fechanacimiento=txtFechaNacimiento.getText();
    	String nacionalidad=txtNacionalidad.getText();

    	try {
			c.insertar(rut, nombre, apellidoP,apellidoM, sexo, fechanacimiento, nacionalidad);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	

	protected void btnVolverActionPerformed(ActionEvent evt) {
		new Menu().setVisible(true);
        dispose();
		
	}
}
