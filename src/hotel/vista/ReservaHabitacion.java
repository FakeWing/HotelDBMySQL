package hotel.vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import hotel.controlador.RegistroCrud;
import hotel.modelo.ReportesFull;

public class ReservaHabitacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5039458047900825437L;
	private JPanel contentPane;
	public static JTextField txtCodigoReserva;
	public static JTextField txtHoraIngreso;
	public static JTextField txtCantidadOcupantes;
	public static JComboBox<String> CBoxHab;
	public static int estadia;
	public static JLabel lblPrecio;
	public static JLabel lblStatus;
	public static JButton btnNewButton;
	public static boolean registrar = false;
	/**
	 * Launch the application.
	 */

	private final ButtonGroup buttonGroup = new ButtonGroup();
	public static JTextField txtHoraSalida;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaHabitacion frame = new ReservaHabitacion();
					// CRUD.CBHabitacion(combo);
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

	public ReservaHabitacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Codigo de Reserva");
		lblNewLabel.setBounds(39, 45, 116, 24);
		contentPane.add(lblNewLabel);

		txtCodigoReserva = new JTextField();
		txtCodigoReserva.setEditable(false);
		txtCodigoReserva.setBounds(165, 45, 130, 26);
		contentPane.add(txtCodigoReserva);
		txtCodigoReserva.setColumns(10);

		JLabel lblHoraDeIngreso = new JLabel("Hora de Ingreso");
		lblHoraDeIngreso.setBounds(38, 87, 116, 24);
		contentPane.add(lblHoraDeIngreso);

		txtHoraIngreso = new JTextField();
		txtHoraIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoraIngreso.setEditable(false);
		txtHoraIngreso.setColumns(10);
		txtHoraIngreso.setBounds(164, 87, 131, 26);
		contentPane.add(txtHoraIngreso);

		JLabel lblHoraDeSalida = new JLabel("Tipo de Estadia");
		lblHoraDeSalida.setBounds(39, 11, 116, 24);
		contentPane.add(lblHoraDeSalida);

		JLabel lblCantidadDeClientes = new JLabel("Cantidad de Clientes");
		lblCantidadDeClientes.setBounds(39, 167, 116, 24);
		contentPane.add(lblCantidadDeClientes);

		txtCantidadOcupantes = new JTextField();
		txtCantidadOcupantes.setColumns(10);
		txtCantidadOcupantes.setBounds(185, 167, 99, 26);
		contentPane.add(txtCantidadOcupantes);

		CBoxHab = new JComboBox<String>();
		CBoxHab.setBounds(165, 215, 161, 20);
		contentPane.add(CBoxHab);
		try {
			RegistroCrud.CBHabitacion(CBoxHab);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CBoxHab.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CBHabitacionActionPerformed(evt);
				RegistroCrud.revisarEstadoHabitacion();

			}
		});

		btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (lblStatus.getText().equals("NO DISPONIBLE.")) {
						JOptionPane.showMessageDialog(rootPane, "Habitacion no disponible.");
					} else {

						RegistroCrud.crearRegistro();

						btnNewButton.setEnabled(false);
						registrar = true;
					}
				} catch (InterruptedException | SQLException | NumberFormatException e1) {
					JOptionPane.showMessageDialog(rootPane, "Alguno de los campos esta vacio.");

				}

			}
		});

		btnNewButton.setBounds(206, 321, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu().setVisible(true);
				dispose();

			}
		});
		btnNewButton_1.setBounds(323, 321, 89, 23);
		contentPane.add(btnNewButton_1);

		JRadioButton rdbtnMomento = new JRadioButton("Momento");
		rdbtnMomento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMomento.isSelected()) {
					ReportesFull.setEstadia(3);
				}
			}
		});
		buttonGroup.add(rdbtnMomento);
		rdbtnMomento.setBounds(175, 12, 89, 23);
		contentPane.add(rdbtnMomento);

		JRadioButton rdbtnJornada = new JRadioButton("Jornada");
		rdbtnJornada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnJornada.isSelected()) {
					ReportesFull.setEstadia(12);
				}
			}
		});
		buttonGroup.add(rdbtnJornada);
		rdbtnJornada.setBounds(280, 12, 89, 23);
		contentPane.add(rdbtnJornada);

		JButton btnNewButton_2 = new JButton("Obtener Codigo");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					RegistroCrud.obtenerReserva();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(305, 46, 107, 23);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("Seleccionar Habitacion");
		lblNewLabel_1.setBounds(39, 218, 107, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblHoraDeSalida_1 = new JLabel("Hora de Salida");
		lblHoraDeSalida_1.setBounds(38, 130, 116, 24);
		contentPane.add(lblHoraDeSalida_1);

		txtHoraSalida = new JTextField();
		txtHoraSalida.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoraSalida.setEditable(false);
		txtHoraSalida.setColumns(10);
		txtHoraSalida.setBounds(164, 130, 131, 26);
		contentPane.add(txtHoraSalida);

		JButton btnPrecio = new JButton("Calcular Precio");
		btnPrecio.setBounds(75, 270, 130, 23);
		contentPane.add(btnPrecio);
		btnPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroCrud.Descuento();
				RegistroCrud.montoH();

			}
		});

		JLabel lblTotal = new JLabel("TOTAL $:");
		lblTotal.setBounds(238, 274, 45, 14);
		contentPane.add(lblTotal);

		lblPrecio = new JLabel("");
		lblPrecio.setBounds(293, 274, 76, 14);
		contentPane.add(lblPrecio);

		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(85, 321, 89, 23);
		contentPane.add(btnPagar);

		lblStatus = new JLabel("");
		lblStatus.setBounds(336, 218, 116, 14);
		contentPane.add(lblStatus);
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (registrar == false) {
					JOptionPane.showMessageDialog(rootPane, "Llene el registro primero.");

				} else {

					RegistroCrud.Pagar();
					try {
						RegistroCrud.insertarRegistroHabitacion();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					RegistroCrud.revisarReservas();
					RegistroCrud.actualizarReservas();
					RegistroCrud.revisarClientes();
					RegistroCrud.actualizarClientes();
					RegistroCrud.actualizarEstadoHabitacion();
					dispose();
					new Menu().setVisible(true);

				}
			}
		});

	}

	protected void CBHabitacionActionPerformed(ActionEvent evt) {
		CBoxHab.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}

		});
	}
}
