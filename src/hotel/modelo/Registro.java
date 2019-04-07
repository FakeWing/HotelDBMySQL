package hotel.modelo;

import java.sql.Timestamp;

public class Registro {

	private int codigoReserva, idHabitacion, cliente_rut;
	private Timestamp horaIngreso;
	//private Cliente cliente;
	
	public Registro () {
		
	}
	
	public Registro (int codigoReserva, Timestamp horaIngreso, int idHabitacion) {
		
		this.codigoReserva = codigoReserva;
		this.horaIngreso = horaIngreso;
		this.idHabitacion = idHabitacion;
	}

	public int getcodigoReserva() {
		return codigoReserva;
	}

	public void setcodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public int getCliente_rut() {
		return cliente_rut;
	}

	public void setCliente_rut(int cliente_rut) {
		this.cliente_rut = cliente_rut;
	}

	public String getHoraIngreso() {
		return "'"+horaIngreso+"'";
	}
	
	public Timestamp getHoraIngresoTimestamp() {
		return horaIngreso;
	}

	public void setHoraIngreso(Timestamp horaIngreso) {
		this.horaIngreso = horaIngreso;
	}


	
}
