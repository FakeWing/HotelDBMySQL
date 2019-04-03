package hotel.modelo;

public class Habitacion {

	private int idhabitacion, valor, ocupantes;
	private String nombrehabitacion;
	private double descuento;
	
	public Habitacion(int idhabitacion, int valor, int ocupantes, String nombrehabitacion, double descuento) {
	
		this.idhabitacion = idhabitacion;
		this.valor = valor;
		this.ocupantes = ocupantes;
		this.nombrehabitacion = nombrehabitacion;
		this.descuento = descuento;
	}
	
	public Habitacion (int idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	public int getIdhabitacion() {
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

	public int getOcupantes() {
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
