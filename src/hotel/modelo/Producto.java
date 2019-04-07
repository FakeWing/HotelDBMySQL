package hotel.modelo;

import java.text.NumberFormat;

public class Producto {
	private static int idproducto;
	private  String nombreproducto;
	private  double precio;
	private  int stock;

	public Producto(int idproducto,String nombreproducto, double precio, int stock) {
		
		this.idproducto=idproducto;
		this.nombreproducto= nombreproducto;
		this.precio=precio;
		this.stock=stock;
	}

	

	public Producto(int idproducto, String nombreproducto, double price) {
		this.idproducto=idproducto;
		this.nombreproducto=nombreproducto;
		this.precio=price;
		// TODO Auto-generated constructor stub
	}
	
	


	public Producto() {
		// TODO Auto-generated constructor stub
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



	public String toString() {
		StringBuilder stringbuilder;
		stringbuilder = new StringBuilder().append(idproducto);
		stringbuilder.append(",");
		stringbuilder.append(nombreproducto);
		stringbuilder.append(",");
		stringbuilder.append(precio);
		return stringbuilder.toString();
	}
	
	/*
	public static void getId(String nombreproducto) {
		if(nombreproducto.equals("Pepsi")) {
			idproducto=1;
		}
		if(nombreproducto.equals("Fanta")) {
			idproducto=2;
		}
		if(nombreproducto.equals("Corona")) {
			idproducto=3;
		}
		if(nombreproducto.equals("Durex")) {
			idproducto=4;
		}
		if(nombreproducto.equals("Yes")) {
			idproducto=5;
		}
		if(nombreproducto.equals("Cuerda")) {
			idproducto=6;
		}
		if(nombreproducto.equals("Mascara de Latex")) {
			idproducto=7;
		}
		if(nombreproducto.equals("Barros Luco")) {
			idproducto=8;
		}
		if(nombreproducto.equals("Italiano")) {
			idproducto=9;
		}
		
	}

	*/
}