package hotel.vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import hotel.controlador.CRUD;
import hotel.modelo.Cliente;
import hotel.modelo.Habitacion;

public class RegistroCliente extends JFrame {
	public static JTextField txtRut;
	public static JTextField txtNombre;
	public static JTextField txtApellidoP;
	public static JTextField txtApellidoM;
	public static JTextField txtSexo;
	public static JTextField txtNacionalidad;
	public static JTextField txtFecha;
	public static JDateChooser dateChooser;
	public static int idhabitacion;

	private JPanel contentPane;

	public static JTable table;
	public static DefaultTableModel tableModel;
	int cont = 1;
	public static JTextField txtReserva;
	public static JTextField txtHabitacion;

	// static Cliente cliente=Cliente.getInstance();

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

	public static int getIdhabitacion() {
		return idhabitacion;
	}

	public static void setIdhabitacion(int idhabitacion) {
		RegistroCliente.idhabitacion = idhabitacion;
	}

	/**
	 * Create the frame.
	 */
	public RegistroCliente() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 611, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistrar.setBounds(43, 587, 121, 44);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnRegistrarActionPerformed(evt);
					dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane, "Llene el registro.");
				}
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

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(392, 322, 22, 20);
		contentPane.add(dateChooser);

		JButton btnConfirmarFecha = new JButton("Confirmar Fecha");
		btnConfirmarFecha.setBounds(434, 318, 125, 23);
		contentPane.add(btnConfirmarFecha);
		btnConfirmarFecha.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnConfirmarFechaActionPerformed(evt);
			}
		});

		JButton btnVerificarRut = new JButton("Verificar Rut");
		btnVerificarRut.setBounds(434, 135, 121, 23);
		contentPane.add(btnVerificarRut);

		txtFecha = new JTextField();
		txtFecha.setBounds(247, 319, 135, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		btnVerificarRut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnVerificarRutActionPerformed(evt);
			}
		});
		JScrollPane pane = new JScrollPane();
		pane.setBounds(5, 404, 580, 165);
		table = new JTable();
		pane.setViewportView(table);
		getContentPane().add(pane);
		tableModel = new DefaultTableModel(new Object[] { "Rut", "Nombre", "A.Pat", "A.Mat" }, 0);

		table.setModel(tableModel);

		JButton btnAgregar = new JButton("Agregar al Registro");

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// int count = tableModel.getRowCount() + 1;
				// tableModel.setRowCount(4);

				tableModel.addRow(new Object[] { txtRut.getText(), txtNombre.getText(), txtApellidoP.getText(),
						txtApellidoM.getText() });
				if (cont > Habitacion.getOcupantes() - 1) {
					btnAgregar.setEnabled(false);

				} else {
					cont++;
				}

			}
		});

		btnAgregar.setBounds(434, 356, 125, 21);
		contentPane.add(btnAgregar);

		JButton btnAgregaradb = new JButton("Agregar a DB");
		btnAgregaradb.setBounds(434, 282, 125, 21);
		contentPane.add(btnAgregaradb);
		btnAgregaradb.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAgregaradbActionPerformed(evt);
			}
		});

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLimpiarActionPerformed(evt);
			}
		});
		btnLimpiar.setBounds(434, 244, 125, 21);
		contentPane.add(btnLimpiar);

		txtReserva = new JTextField();
		txtReserva.setEditable(false);
		txtReserva.setColumns(10);
		txtReserva.setBounds(100, 52, 130, 26);
		contentPane.add(txtReserva);
		txtReserva.setText(ReservaHabitacion.txtCodigoReserva.getText());

		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setBounds(136, 24, 65, 14);
		contentPane.add(lblReserva);

		txtHabitacion = new JTextField();
		txtHabitacion.setEditable(false);
		txtHabitacion.setColumns(10);
		txtHabitacion.setBounds(327, 52, 130, 26);
		contentPane.add(txtHabitacion);
		txtHabitacion.setText(String.valueOf(ReservaHabitacion.CBoxHab.getSelectedItem()));

		JLabel lblHabitacion = new JLabel("Habitacion");
		lblHabitacion.setBounds(363, 24, 70, 14);
		contentPane.add(lblHabitacion);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ReservaHabitacion.registrar = false;
				ReservaHabitacion.btnNewButton.setEnabled(true);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(464, 587, 121, 44);
		contentPane.add(btnVolver);

		JButton btnClienteDelAmor = new JButton("Cliente del amor");
		btnClienteDelAmor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClienteDelAmor.setBounds(213, 587, 183, 44);
		contentPane.add(btnClienteDelAmor);
		btnClienteDelAmor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CRUD.ClienteAmorCheck();
				btnClienteDelAmor.setEnabled(false);
			}
		});
	}

	protected void btnLimpiarActionPerformed(ActionEvent evt) {
		txtRut.setText("");
		txtNombre.setText("");
		txtApellidoP.setText("");
		txtApellidoM.setText("");
		txtSexo.setText("");
		txtNacionalidad.setText("");
		txtFecha.setText("");

	}

	protected void btnAgregaradbActionPerformed(ActionEvent evt) {
		try {
			CRUD.crearCliente();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(rootPane, "Llene los datos primero.");
		}
	}

	protected void btnConfirmarFechaActionPerformed(ActionEvent evt) {
		try {
			CRUD.ConfirmarFecha();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(rootPane, "Seleccione una fecha primero.");
		}

	}

	protected void btnVerificarRutActionPerformed(ActionEvent evt) {

		if (RegistroCliente.txtRut.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Ingrese un rut.");

		} else {
			CRUD.VerificarRut();
			CRUD.LlenarDatos(Cliente.getInstance());

		}
	}

	protected void btnRegistrarActionPerformed(ActionEvent evt) throws SQLException {
		CRUD.valoresTabla();

	}
}
