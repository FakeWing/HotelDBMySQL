package hotel.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ComponentListener;
import java.io.BufferedInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ReservaHabitacion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaHabitacion frame = new ReservaHabitacion();
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
		setBounds(100, 100, 486, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(45, 100, 116, 24);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(199, 100, 193, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("New label");
		label.setBounds(45, 135, 116, 24);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(199, 135, 193, 26);
		contentPane.add(textField_1);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(45, 170, 116, 24);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(199, 170, 193, 26);
		contentPane.add(textField_2);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(45, 205, 116, 24);
		contentPane.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(199, 205, 193, 26);
		contentPane.add(textField_3);
		
		
	}
}
