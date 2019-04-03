package hotel.modelo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Registro {

	private int idregistro, registro_codigoReserva, idHabitacion, cliente_rut;
	private Timestamp horaIngreso;
	//private Cliente cliente;
	
	public Registro () {
		
	}
	
	public Registro (int idregistro, int cliente_rut) {
		
		this.idregistro = idregistro;
		this.cliente_rut = cliente_rut;
	}
	
	public Registro (int registro_codigoReserva, Timestamp horaIngreso, int idHabitacion) {
		
		this.registro_codigoReserva = registro_codigoReserva;
		this.horaIngreso = horaIngreso;
		this.idHabitacion = idHabitacion;
	}

	public int getIdregistro() {
		return idregistro;
	}

	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}

	public int getRegistro_codigoReserva() {
		return registro_codigoReserva;
	}

	public void setRegistro_codigoReserva(int registro_codigoReserva) {
		this.registro_codigoReserva = registro_codigoReserva;
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

	public Timestamp getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(Timestamp horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

}
