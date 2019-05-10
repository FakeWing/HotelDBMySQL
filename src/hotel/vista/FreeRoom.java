package hotel.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotel.controlador.RegistroCrud;
import hotel.modelo.ReportesFull;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FreeRoom extends JFrame {

	private JPanel contentPane;
	public static JComboBox comboBox;
	public static JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FreeRoom frame = new FreeRoom();
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
	public FreeRoom() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 387, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(112, 50, 144, 20);
		contentPane.add(comboBox);
		try {
			RegistroCrud.CBHabitacion(comboBox);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		comboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CBHabitacionActionPerformed(evt);
				RegistroCrud.revisarEstadoHabitacion2();

			}
		});
		
		JButton btnDesocupar = new JButton("DESOCUPAR");
		btnDesocupar.setBounds(100, 119, 162, 41);
		contentPane.add(btnDesocupar);
		btnDesocupar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					RegistroCrud.desocuparHabitacion();
					RegistroCrud.EstadoLibre();
				}
		});
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(290, 50, 98, 20);
		contentPane.add(lblStatus);
		
		JLabel lblhabitacion = new JLabel("");
		lblhabitacion.setBounds(300, 15, 98, 20);
		contentPane.add(lblhabitacion);
	}

	protected void CBHabitacionActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}


}
