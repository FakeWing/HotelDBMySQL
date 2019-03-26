package hotel.modelo;

public class Registro {

	private int idregistro,idhabitacion;
	private Cliente cliente;
	
	public Registro(int idregistro, int idhabitacion, Cliente cliente) {
		
		this.idregistro = idregistro;
		this.idhabitacion = idhabitacion;
		this.cliente = cliente;
	}

	public int getIdregistro() {
		return idregistro;
	}

	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}

	public int getIdhabitacion() {
		return idhabitacion;
	}

	public void setIdhabitacion(int idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
