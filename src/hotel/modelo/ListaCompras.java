package hotel.modelo;

public class ListaCompras {
	private int idproducto;
	private double precio;
	
	
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public ListaCompras(Producto producto) {
		
		this.idproducto = producto.getIdproducto();
		this.precio = producto.getPrecio();
	}
	
	public ListaCompras() {
		
		
	}
	
	

}
