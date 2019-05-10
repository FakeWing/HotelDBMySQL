package hotel.modelo;

public class Habitacion {

	private static int idhabitacion;
	private int valor;
	private static int ocupantes;
	private String nombrehabitacion;
	private double descuento;
	private static int totalproducto;
	private static int totalregistro;
	private static int totalclientes;
	
	public Habitacion(int idhabitacion, int valor, int ocupantes, String nombrehabitacion, double descuento) {
	
		this.idhabitacion = idhabitacion;
		this.valor = valor;
		this.ocupantes = ocupantes;
		this.nombrehabitacion = nombrehabitacion;
		this.descuento = descuento;
	}
	
	public Habitacion() {
		
	}
	
	
	
	public Habitacion (int idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	
	public int getTotalproducto() {
		return totalproducto;
	}

	public void setTotalproducto(int totalproducto) {
		this.totalproducto = totalproducto;
	}

	public int getTotalregistro() {
		return totalregistro;
	}

	public void setTotalregistro(int totalregistro) {
		this.totalregistro = totalregistro;
	}

	public int getTotalclientes() {
		return totalclientes;
	}

	public void setTotalclientes(int totalclientes) {
		this.totalclientes = totalclientes;
	}

	public static int getIdhabitacion() {
		return idhabitacion;
	}

	public void setIdhabitacion(int idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public static int getOcupantes() {
		return ocupantes;
	}

	public void setOcupantes(int ocupantes) {
		this.ocupantes = ocupantes;
	}

	public String getNombrehabitacion() {
		return nombrehabitacion;
	}

	public void setNombrehabitacion(String nombrehabitacion) {
		this.nombrehabitacion = nombrehabitacion;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	
}
