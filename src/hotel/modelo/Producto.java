package hotel.modelo;

import java.text.NumberFormat;

public class Producto {
	private int idproducto;
	private String nombreproducto;
	private double precio;
	private int stock;
	private int cantidad;
	private int idpedido;

	public Producto(int idproducto, String nombreproducto, double precio, int stock) {

		this.idproducto = idproducto;
		this.nombreproducto = nombreproducto;
		this.precio = precio;
		this.stock = stock;
	}

	public Producto(int idproducto, String nombreproducto, double price) {
		this.idproducto = idproducto;
		this.nombreproducto = nombreproducto;
		this.precio = price;
		// TODO Auto-generated constructor stub
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String toString() {
		StringBuilder stringbuilder;
		stringbuilder = new StringBuilder().append(idproducto);
		stringbuilder.append(",");
		stringbuilder.append(nombreproducto);
		stringbuilder.append(",");
		stringbuilder.append(precio);
		stringbuilder.append(",");
		stringbuilder.append(stock);
		return stringbuilder.toString();
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;

	}

}