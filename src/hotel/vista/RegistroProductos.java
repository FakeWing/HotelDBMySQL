package hotel.vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hotel.modelo.Producto;
import hotel.modelo.ProductoOrder;
import hotel.modelo.ShoppingCart;

public final class RegistroProductos extends JFrame {

	private static final long serialVersionUID = 0;
	private static final int TEXT_FIELD_WIDTH = 12;
	private static final Color BG_COLOR = new Color(0, 0, 0);
	private final ShoppingCart mis_Productos;
	private final JTextField mi_total;

	public RegistroProductos(final List<Producto> el_Producto) {

		super("Registro de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mis_Productos = new ShoppingCart();

		mi_total = new JTextField("$0.0", TEXT_FIELD_WIDTH);
		add(makeTotalPanel(), "Center");
		add(makeProductosPanel(el_Producto), "North");
		add(makeButtonIngresar(), "South");

		pack();
		setVisible(true);
	}

	private JPanel makeTotalPanel() {

		mi_total.setEditable(false);
		mi_total.setEnabled(false);
		mi_total.setDisabledTextColor(Color.black);

		// create the panel, and its label

		final JPanel p = new JPanel();
		p.setBackground(Color.blue);
		final JLabel l = new JLabel("Total");
		l.setForeground(Color.yellow);
		p.add(l);
		p.add(mi_total);
		return p;
	}

	private JPanel makeProductosPanel(final List<Producto> el_Producto) {
		final JPanel p = new JPanel(new GridLayout(el_Producto.size(), 1));

		for (Producto Producto : el_Producto) {
			addProducto(Producto, p);
		}

		return p;
	}

	private JPanel makeButtonIngresar() {
		final JPanel p = new JPanel();
		p.setBackground(Color.blue);
		final JButton cb = new JButton("Ingresar");
		p.add(cb);
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent the_event) {

				updateTotal();

				System.out.print(mis_Productos);

			}
		});
		return p;
	}

	private void addProducto(final Producto el_Producto, final JPanel el_panel) {
		final JPanel sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
		sub.setBackground(BG_COLOR);
		final JTextField cantidad = new JTextField(3);
		cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		cantidad.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent the_event) {
				updateProducto(el_Producto, cantidad);
				cantidad.transferFocus();

			}
		});
		cantidad.addFocusListener(new FocusAdapter() {
			public void focusLost(final FocusEvent the_event) {
				updateProducto(el_Producto, cantidad);
			}
		});
		sub.add(cantidad);
		final JLabel l = new JLabel(el_Producto.toString());
		l.setForeground(Color.WHITE);
		sub.add(l);
		el_panel.add(sub);
	}

	private void updateProducto(final Producto el_Producto, final JTextField la_cantidad) {
		final String text = la_cantidad.getText().trim();
		int number;
		try {
			number = Integer.parseInt(text);
			if (number < 0) {

				throw new NumberFormatException();
			}
		} catch (final NumberFormatException e) {
			number = 0;
			la_cantidad.setText("");
		}
		mis_Productos.add(new ProductoOrder(el_Producto, number));
		updateTotal();
	}

	private void updateTotal() {
		final double total = mis_Productos.getTotal();
		mi_total.setText(NumberFormat.getCurrencyInstance().format(total));
	}
}