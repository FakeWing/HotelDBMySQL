package hotel.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

	private final List<ProductoOrder> mi_Producto_list = new ArrayList<ProductoOrder>();

	public ShoppingCart() {

	}

	public final void add(final ProductoOrder el_Producto_order) {
		for (int i = 0; i < mi_Producto_list.size(); i++) {
			if (((ProductoOrder) mi_Producto_list.get(i)).getProducto().equals(el_Producto_order.getProducto())) {
				mi_Producto_list.set(i, el_Producto_order);
				return;
			}
		}
		mi_Producto_list.add(el_Producto_order);

	}

	public double getTotal() {

		double total = 0.0;

		for (final Iterator<ProductoOrder> iterator = mi_Producto_list.iterator(); iterator.hasNext();) {
			final ProductoOrder next_Producto = (ProductoOrder) iterator.next();
			total = total + next_Producto.getprecio();
		}

		return total;
	}

	@Override
	public String toString() {

		return "ShoppingCart [mi_Producto_list=" + mi_Producto_list + "]";
	}

}