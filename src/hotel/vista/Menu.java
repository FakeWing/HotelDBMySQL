package hotel.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import hotel.controlador.CRUD;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.awt.Color;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

	private static JPanel contentPane;
	private static JPanel contentPane1;
	private static Menu frame;

	/**
	 * Launch the application.
	 */
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

		JToggleButton button = new JToggleButton("BACKGROUND MUSIC OFF/ON");
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

					// button.setIcon(null);
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

					clip.loop(Clip.LOOP_CONTINUOUSLY);
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
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnReservar = new JButton("Reservar Habitaci\u00F3n");
		btnReservar.setBackground(Color.MAGENTA);
		btnReservar.setBounds(81, 116, 184, 63);
		contentPane.add(btnReservar);

		JLabel lblMenu = new JLabel("MENU PRINCIPAL");
		lblMenu.setBackground(Color.WHITE);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMenu.setBounds(263, 11, 170, 63);
		contentPane.add(lblMenu);

		JButton btnRegistrarCliente = new JButton("Registrar Cliente");
		btnRegistrarCliente.setBackground(Color.MAGENTA);
		btnRegistrarCliente.setBounds(375, 116, 184, 63);
		contentPane.add(btnRegistrarCliente);

		JButton btnRegistroDeProductos = new JButton("Registro de Productos");
		btnRegistroDeProductos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRegistroDeProductosActionPerformed(evt);
			}
		});
		btnRegistroDeProductos.setBackground(Color.MAGENTA);
		btnRegistroDeProductos.setBounds(81, 257, 184, 63);
		contentPane.add(btnRegistroDeProductos);

		btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRegistrarClienteActionPerformed(evt);
			}
		});
	}

	protected void btnRegistroDeProductosActionPerformed(ActionEvent evt) {
		ShoppingMain.main();

	}

	protected void btnRegistrarClienteActionPerformed(ActionEvent evt) {
		dispose();

		new RegistroCliente().setVisible(true);

	}

}