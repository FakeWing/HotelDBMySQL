package hotel.modelo;

public class Producto {

	private int idproducto, cantproducto, valorproducto;
	private String nombreproducto;
	
	public Producto(int idproducto, int cantproducto, int valorproducto, String nombreproducto) {
		
		this.idproducto = idproducto;
		this.cantproducto = cantproducto;
		this.valorproducto = valorproducto;
		this.nombreproducto = nombreproducto;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public int getCantproducto() {
		return cantproducto;
	}

	public void setCantproducto(int cantproducto) {
		this.cantproducto = cantproducto;
	}

	public int getValorproducto() {
		return valorproducto;
	}

	public void setValorproducto(int valorproducto) {
		this.valorproducto = valorproducto;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}
	
	
	
}
