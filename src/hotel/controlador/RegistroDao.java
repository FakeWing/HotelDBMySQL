package hotel.controlador;
import java.sql.SQLException;

import javax.swing.JComboBox;

import hotel.modelo.Registro;

public interface RegistroDao {

	public void insertar (Registro registro) throws SQLException, InterruptedException;
	
	public void insertarRegistroHabitacion() throws SQLException, InterruptedException;
	
	public static void crearRegistro() throws InterruptedException {}
	
	public static void CBHabitacion(JComboBox<?> cbox_habitacion) {}
	
	public static void obtenerReserva () {};
	
}
