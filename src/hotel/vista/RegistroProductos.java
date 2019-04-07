package hotel.vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.sql.Array;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import hotel.controlador.ProductoCrud;
import hotel.modelo.ListaCompras;
import hotel.modelo.Producto;

public class RegistroProductos extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodReserva;
	private JList ListaCompra;
	private JList ListaStock;
	List lista = new List();
	DefaultListModel dlm = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroProductos frame = new RegistroProductos();
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
	@SuppressWarnings("unchecked")
	public RegistroProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.WEST);

		ListaStock = new JList(ProductoCrud.mostrar().toArray());

		scrollPane.setViewportView(ListaStock);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 100));
		panel.setMinimumSize(new Dimension(100, 100));
		contentPane.add(panel, BorderLayout.CENTER);

		JButton btnQuitar = new JButton("< Quitar");
		btnQuitar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQuitarActionPerformed(evt);
			}
		});

		JButton btnAgregar = new JButton("Agregar >");
		btnAgregar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAgregarActionPerformed(evt);
			}
		});

		JLabel lblNewLabel = new JLabel("New label");

		JButton btnNewButton = new JButton("New button");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(68)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnQuitar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnAgregar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnNewButton, Alignment.TRAILING)))
								.addGroup(gl_panel.createSequentialGroup().addGap(77).addComponent(lblNewLabel)))
						.addContainerGap(178, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(77).addComponent(btnNewButton).addGap(46)
						.addComponent(btnAgregar).addGap(18).addComponent(btnQuitar)
						.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE).addComponent(lblNewLabel)
						.addGap(32)));
		panel.setLayout(gl_panel);

		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, BorderLayout.EAST);

		ListaCompra = new JList();
		scrollPane_1.setViewportView(ListaCompra);

		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		txtCodReserva = new JTextField();
		panel_1.add(txtCodReserva);
		txtCodReserva.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		panel_1.add(btnBuscar);

		Panel panel_2 = new Panel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JButton btnNewButton_3 = new JButton("New button");

		JButton btnOrden = new JButton("Orden");
		btnOrden.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnOrdenActionPerformed(evt);
			}
		});

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2.createSequentialGroup()
						.addGap(214).addComponent(btnNewButton_3).addGap(154).addComponent(btnOrden).addGap(111)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(5).addGroup(gl_panel_2
						.createParallelGroup(Alignment.BASELINE).addComponent(btnOrden).addComponent(btnNewButton_3))));
		panel_2.setLayout(gl_panel_2);
	}

	protected void btnOrdenActionPerformed(ActionEvent evt) {
		enlistar();

	

	}

	protected void btnQuitarActionPerformed(ActionEvent evt) {
		dlm2.removeElement(ListaCompra.getSelectedValue());
		ListaCompra.setModel(dlm2);
	}

	DefaultListModel dlm2 = new DefaultListModel();

	@SuppressWarnings("unchecked")
	protected void btnAgregarActionPerformed(ActionEvent evt) {
		dlm2.addElement(ListaStock.getSelectedValue());
		ListaCompra.setModel(dlm2);

	}

	@SuppressWarnings("null")
	public void enlistar() {
		Producto producto = null;
		
		double total=0.0;
		
		
		
		ArrayList list = new ArrayList(ListaCompra.getModel().getSize());
		for (int i = 0; i < ListaCompra.getModel().getSize(); i++) {
			list.add(ListaCompra.getModel().getElementAt(i));

		}

		for (int i = 0; i < list.size(); i++) {

			list.get(i);

			String[] linea = list.get(i).toString().split(",");
			producto = new Producto(Integer.parseInt(linea[0]), linea[1], Double.parseDouble(linea[2]));
			total+=producto.getPrecio();
			producto.getNombreproducto();
			//Producto.getId(linea[1]);
			System.out.println(linea[1]);
			System.out.println(producto.getIdproducto());
			System.out.println(producto);
			

		}
		System.out.println(total);
		
		
		
	
		System.out.println(producto);
		System.out.println(producto.getPrecio());
	}
}
