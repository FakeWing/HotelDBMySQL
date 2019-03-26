package hotel.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;



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

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					Menu.Button();
					frame.setState(JFrame.NORMAL);
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void Button() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		JFrame frame1 = new JFrame();
		frame1.setSize(300, 300);
		BufferedInputStream myStream = new BufferedInputStream(Thread.currentThread().getContextClassLoader().getResourceAsStream("SaxLoop.wav"));
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(myStream);
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame1.setVisible(false);
		
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

		btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });
	}
	
	protected void btnRegistrarClienteActionPerformed(ActionEvent evt) {
		dispose();

		
		new RegistroCliente().setVisible(true);
	}
}
