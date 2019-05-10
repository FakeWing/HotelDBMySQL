package hotel.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import hotel.controlador.Conexion;
import hotel.controlador.ProductoCrud;
import hotel.modelo.Producto;
import java.awt.event.ActionListener;

public class RegistroProductos extends JFrame {

	private JPanel contentPane;
	public static JTextField txtCodReserva;
	private JList ListaCompra;
	private JList ListaStock;
	private JList ListaCompraS;
	List lista = new List();
	DefaultListModel dlm = new DefaultListModel();
	int[] ids = new int[100];
	double[] tot = new double[100];
	JLabel lblTotal1;
	public static double total = 0.0;
	public static JLabel lblhabitacion;
	public static int pedido;
	JLabel lblTotal;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		lblhabitacion = new JLabel("");

		JLabel lblNewLabel = new JLabel("Habitacion: ");
		JButton btnOrden = new JButton("Calcular TOTAL");
		btnOrden.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnOrdenActionPerformed(evt);
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(61)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnQuitar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addComponent(btnAgregar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
				.addGap(133))
				.addGroup(gl_panel.createSequentialGroup().addGap(46)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOrden, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblhabitacion,
												GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(25)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblhabitacion, GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
								.addGap(70).addComponent(btnAgregar).addGap(18).addComponent(btnQuitar).addGap(57)
								.addComponent(btnOrden).addContainerGap(52, Short.MAX_VALUE)));
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
		btnBuscar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBuscarActionPerformed(evt);
			}
		});

		Panel panel_2 = new Panel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPagarActionPerformed(evt);
			}
		});

		lblTotal1 = new JLabel("TOTAL $:");

		lblTotal = new JLabel("");

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(132)
						.addComponent(lblTotal1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE).addGap(34)
						.addComponent(btnPagar).addGap(236)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel_2.createSequentialGroup().addGap(5).addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPagar).addComponent(lblTotal1).addComponent(lblTotal))));
		panel_2.setLayout(gl_panel_2);
	}

	protected void btnBuscarActionPerformed(ActionEvent evt) {
		ProductoCrud.buscarReg();

	}

	protected void btnPagarActionPerformed(ActionEvent evt) {

		ProductoCrud.obtenerPedido();

		modificarStock();
		// modificarMontoProducto();
		ProductoCrud.revisarProductosM();
		ProductoCrud.actualizarProductosM();
		ProductoCrud.revisarProductos();
		ProductoCrud.actualizarProductos();

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
		total = 0;

		ArrayList list = new ArrayList(ListaCompra.getModel().getSize());
		for (int i = 0; i < ListaCompra.getModel().getSize(); i++) {
			list.add(ListaCompra.getModel().getElementAt(i));
			System.out.println(ListaCompra.getModel().getElementAt(i));

		}
		tot = new double[list.size()];
		ids = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {

			list.get(i);

			String[] linea = list.get(i).toString().split(",");
			producto = new Producto(Integer.parseInt(linea[0]), linea[1], Double.parseDouble(linea[2]));
			producto.setCantidad(1);
			tot[i] = producto.getPrecio();
			ids[i] = producto.getIdproducto();

		}

		for (int i = 0; i < tot.length; i++) {
			System.out.println(ids[i]);
			System.out.println(tot[i]);
			total += tot[i];
		}

		System.out.println(total);
		lblTotal.setText(String.valueOf(total));

	}

	public void modificarStock() {
		Conexion con = new Conexion();

		try {

			for (int i = 0; i < ids.length; i++) {
				String stock = "UPDATE `hoteldb`.`producto` SET stock=stock-1  WHERE (`idproducto` = '" + ids[i]
						+ "');";
				PreparedStatement ps = con.connect().prepareStatement(stock);
				ps.executeUpdate();

			}

			for (int i = 0; i < ids.length; i++) {

				pedido += 1;
				System.out.println(pedido);
				String reg = "INSERT INTO `hoteldb`.`registro_has_producto` (`idpedido`, `registro_codigoReserva`, `producto_idproducto`) VALUES ('"
						+ pedido + "', '" + txtCodReserva.getText() + "', '" + ids[i] + "');";
				PreparedStatement ps = con.connect().prepareStatement(reg);
				ps.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void modificarMontoProducto() {
		Conexion con = new Conexion();

		try {
			String montoP = "UPDATE `hoteldb`.`registro` SET `montoProducto` = '" + total
					+ "' WHERE (`codigoReserva` = '" + txtCodReserva.getText() + "') and (`habitacion_idhabitacion` = '"
					+ lblhabitacion.getText() + "');";
			PreparedStatement ps = con.connect().prepareStatement(montoP);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
