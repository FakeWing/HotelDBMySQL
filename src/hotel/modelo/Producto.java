package hotel.modelo;

import java.text.NumberFormat;

public class Producto {

	private final String mi_Producto_nombres;
	private final double mi_precio;
	private final int mi_masa;
	private final double mi_masa_cost;
	private final NumberFormat mi_formatted_numbers;

	public Producto(final String el_Producto_nombre, final double el_Producto_precio) {

		this(el_Producto_nombre, el_Producto_precio, 0, 0.0);

	}

	public Producto(final String el_Producto_nombre, final double el_Producto_precio, final int la_cantidad_in_bulk,
			final double the_precio_in_bulk) {
		mi_Producto_nombres = el_Producto_nombre;
		mi_precio = el_Producto_precio;
		mi_masa = la_cantidad_in_bulk;
		mi_masa_cost = the_precio_in_bulk;
		mi_formatted_numbers = NumberFormat.getCurrencyInstance();
	}

	public double precioPor(final int a_cantidad) {

		final int cantidad = a_cantidad;
		double bulk_num;

		if (cantidad >= mi_masa && mi_masa > 0) {
			final int bulk_cantidad = cantidad / mi_masa;
			final int reg_cantidad = cantidad % mi_masa;
			bulk_num = bulk_cantidad * mi_masa_cost + reg_cantidad * mi_precio;
		} else {
			bulk_num = cantidad * mi_precio;
		}
		return bulk_num;
	}

	public String toString() {
		StringBuilder stringbuilder;
		stringbuilder = new StringBuilder().append(mi_Producto_nombres);
		stringbuilder.append(", ");
		stringbuilder.append(mi_formatted_numbers.format(mi_precio));

		return stringbuilder.toString();
	}

	public boolean equals(final Object the_other) {
		final Producto check = (Producto) the_other;
		boolean temporary_checker;

		if (check.mi_Producto_nombres != null && check.mi_Producto_nombres.equals(mi_Producto_nombres)
				&& check.mi_precio == mi_precio && check.mi_masa == mi_masa && check.mi_masa_cost == mi_masa_cost) {
			temporary_checker = true;
		} else {
			temporary_checker = false;
		}

		return temporary_checker;

	}

	public int hashCode() {

		return mi_Producto_nombres.hashCode();
	}
}