package hotel.vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import hotel.controlador.CRUD;

public class ReservaHabitacion extends JFrame {

	private JPanel contentPane;
	public static JTextField txtCodigoReserva;
	public static JTextField txtHoraIngreso;
	public static JTextField txtCantidadOcupantes;
	public static JComboBox CBoxHab;
	public static char id;

	/**
	 * Launch the application.
	 */
	// public static CRUD cbox = new CRUD();
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		setBounds(100, 100, 455, 394);
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
		lblHoraDeSalida.setBounds(39, 132, 116, 24);
		contentPane.add(lblHoraDeSalida);

		JLabel lblCantidadDeClientes = new JLabel("Cantidad de Clientes");
		lblCantidadDeClientes.setBounds(39, 167, 116, 24);
		contentPane.add(lblCantidadDeClientes);

		txtCantidadOcupantes = new JTextField();
		txtCantidadOcupantes.setColumns(10);
		txtCantidadOcupantes.setBounds(185, 167, 99, 26);
		contentPane.add(txtCantidadOcupantes);

		CBoxHab = new JComboBox();
		CBoxHab.setBounds(186, 215, 183, 20);
		contentPane.add(CBoxHab);
		CRUD.CBHabitacion(CBoxHab);
		CBoxHab.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CBHabitacionActionPerformed(evt);
			}
		});

		JButton btnNewButton = new JButton("Reservar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CRUD.crearRegistro();

			}
		});

		btnNewButton.setBounds(77, 284, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu().setVisible(true);
				dispose();
				id = CBoxHab.getItemAt(CBoxHab.getSelectedIndex()).toString().charAt(0);
				System.out.print(id);
			}
		});
		btnNewButton_1.setBounds(272, 284, 89, 23);
		contentPane.add(btnNewButton_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Momento");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(175, 133, 89, 23);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Jornada");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(280, 133, 89, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		JButton btnNewButton_2 = new JButton("Obtener Codigo");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUD.obtenerReserva();
			}
		});
		btnNewButton_2.setBounds(305, 46, 107, 23);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("Seleccionar Habitacion");
		lblNewLabel_1.setBounds(39, 218, 107, 14);
		contentPane.add(lblNewLabel_1);

	}

	protected void CBHabitacionActionPerformed(ActionEvent evt) {
		CBoxHab.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				id = CBoxHab.getItemAt(CBoxHab.getSelectedIndex()).toString().charAt(0);

			}
		});
	}

}
