package hotel.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import hotel.controlador.CRUD;
import hotel.controlador.ReporteCrud;
import hotel.modelo.Cliente;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.TextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Reportes extends JFrame {

	public static JPanel contentPane;
	public static JTextField txtRutBuscar;
	public static JTable table;
	public static JTable table_2;
	public static DefaultTableModel tableModel2 = new DefaultTableModel();
	String rut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes frame = new Reportes();
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
	public Reportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Buscar Rut");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rut = txtRutBuscar.getText();
				ReporteCrud.consultRut(rut);
			}
		});
		btnNewButton.setBounds(419, 82, 131, 25);
		contentPane.add(btnNewButton);

		txtRutBuscar = new JTextField();
		txtRutBuscar.setBounds(218, 82, 171, 25);
		contentPane.add(txtRutBuscar);
		txtRutBuscar.setColumns(10);

		JButton btnNewButton_1 = new JButton("Cliente del Amor <3");
		btnNewButton_1.setBounds(22, 121, 167, 25);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCrud.tablaClienteAmor();
				ReporteCrud.cliendeDelAmor();

			}
		});

		JButton btnNewButton_2 = new JButton("Habitaci\u00F3n Menos Top :(");
		btnNewButton_2.setBounds(218, 159, 173, 25);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCrud.lowHab();
				ReporteCrud.lowHab1();

			}
		});

		JButton btnNewButton_3 = new JButton("Habitaci\u00F3n mas Top!");
		btnNewButton_3.setBounds(218, 121, 173, 25);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCrud.topHab();
				ReporteCrud.topHab1();

			}
		});

		JButton btnNewButton_5 = new JButton("Producto mas Vendido");
		btnNewButton_5.setBounds(419, 121, 175, 25);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCrud.maxProducto();
				ReporteCrud.WhereProducto();

			}
		});
		

		JButton btnNewButton_6 = new JButton("Habitaci\u00F3n Entretenida");
		btnNewButton_6.setBounds(22, 159, 167, 25);
		contentPane.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCrud.maxAverage();

			}
		});

		JButton btnNewButton_7 = new JButton("Producto menos Vendido");
		btnNewButton_7.setBounds(419, 159, 175, 25);
		contentPane.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCrud.lessProducto();
				ReporteCrud.WhereProducto();

			}
		});

		JButton btnNewButton_8 = new JButton("Habitacion Aburrida");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteCrud.lessAverage();
			}
		});
		btnNewButton_8.setBounds(22, 82, 167, 25);
		contentPane.add(btnNewButton_8);

		JButton btnNewButton_11 = new JButton("Limpiar");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ReporteCrud.limpiar();

			}
		});
		btnNewButton_11.setBounds(164, 633, 97, 25);
		contentPane.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("Volver");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu().setVisible(true);
				dispose();
			}
		});
		btnNewButton_12.setBounds(328, 633, 97, 25);
		contentPane.add(btnNewButton_12);

		JLabel lblIngreseRutDe = new JLabel("Ingrese Rut de Cliente");
		lblIngreseRutDe.setBounds(235, 53, 162, 16);
		contentPane.add(lblIngreseRutDe);

		JLabel lblReportesDelSistema = new JLabel("Reportes del Sistema");
		lblReportesDelSistema.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReportesDelSistema.setBounds(218, -2, 190, 42);
		contentPane.add(lblReportesDelSistema);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 422, 565, 200);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(41, 212, 565, 111);
		contentPane.add(scrollPane_1);

		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
	}
}