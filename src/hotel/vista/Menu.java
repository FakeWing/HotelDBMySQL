package hotel.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

	private static JPanel contentPane;
	private static Menu frame;
	private static JToggleButton button;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Menu();
					ButtonM();
					frame.setState(JFrame.NORMAL);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ButtonM() throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		button = new JToggleButton("M");
		button.setBounds(645, 401, 55, 23);
		frame.getContentPane().add(button);
		BufferedInputStream myStream = new BufferedInputStream(
				Thread.currentThread().getContextClassLoader().getResourceAsStream("SaxLoop.wav"));
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(myStream);
		Clip clip = AudioSystem.getClip();
		button.setForeground(Color.RED);
		clip.open(audioInputStream);

		clip.start();

		ItemListener itemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();

				if (state == ItemEvent.SELECTED) {

					button.setForeground(Color.BLUE);

					clip.close();
					clip.stop();
					System.out.println("MUSIC OFF");

				} else {

					BufferedInputStream myStream = new BufferedInputStream(
							Thread.currentThread().getContextClassLoader().getResourceAsStream("SaxLoop.wav"));
					AudioInputStream audioInputStream = null;
					try {
						audioInputStream = AudioSystem.getAudioInputStream(myStream);
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {

						clip.open(audioInputStream);
					} catch (LineUnavailableException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					state = ItemEvent.DESELECTED;
					button.setForeground(Color.RED);

					clip.start();
					System.out.println("MUSIC ON");
				}
			}
		};
		button.addItemListener(itemListener);
		button.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public Menu() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnReservar = new JButton("Reservar Habitacion");
		btnReservar.setBackground(Color.WHITE);
		btnReservar.setBounds(81, 116, 184, 63);
		contentPane.add(btnReservar);
		btnReservar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnReservarActionPerformed(evt);
			}
		});

		JLabel lblMenu = new JLabel("MENU PRINCIPAL");
		lblMenu.setBackground(Color.WHITE);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenu.setBounds(263, 11, 170, 63);
		contentPane.add(lblMenu);

		JButton btnReportes = new JButton("Reportes");
		btnReportes.setBackground(Color.WHITE);
		btnReportes.setBounds(374, 257, 184, 63);
		contentPane.add(btnReportes);

		JButton btnRegistroDeProductos = new JButton("Registro de Productos");
		btnRegistroDeProductos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRegistroDeProductosActionPerformed(evt);
			}
		});
		btnRegistroDeProductos.setBackground(Color.WHITE);
		btnRegistroDeProductos.setBounds(81, 257, 184, 63);
		contentPane.add(btnRegistroDeProductos);
		
		JButton btnLiberarHabitacin = new JButton("Liberar Habitacion");
		btnLiberarHabitacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FreeRoom().setVisible(true);
			}
		});
		btnLiberarHabitacin.setBackground(Color.WHITE);
		btnLiberarHabitacin.setBounds(374, 116, 184, 63);
		contentPane.add(btnLiberarHabitacin);

		btnReportes.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnReportesActionPerformed(evt);
			}
		});

	}

	protected void btnReservarActionPerformed(ActionEvent evt) {
		dispose();
		new ReservaHabitacion().setVisible(true);

	}

	protected void btnRegistroDeProductosActionPerformed(ActionEvent evt) {
		new RegistroProductos().setVisible(true);

	}

	protected void btnReportesActionPerformed(ActionEvent evt) {
		dispose();

		new Reportes().setVisible(true);

	}

}