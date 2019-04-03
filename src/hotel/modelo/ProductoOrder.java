package hotel.modelo;

public class ProductoOrder {

	private final Producto mi_Producto;

	private final int mi_cantidad;

	public ProductoOrder(final Producto el_Producto_nombre, final int la_cantidad_of_Productos) {
		mi_Producto = el_Producto_nombre;
		mi_cantidad = la_cantidad_of_Productos;
	}

	public double getprecio() {

		return mi_Producto.precioPor(mi_cantidad);
	}

	public Producto getProducto() {
		return mi_Producto;
	}

	@Override
	public String toString() {
		return "ProductoOrder [mi_Producto=" + mi_Producto + ", mi_cantidad=" + mi_cantidad + "]";
	}

}