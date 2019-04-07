package hotel.controlador;
import java.sql.SQLException;

import hotel.modelo.Cliente;

public interface Dao {
	//public void insertar (int ru, String no, String ap, String am, String se, String na, String fe) throws SQLException;
	//public void insertar (int cod, Date ini, int can) throws SQLException;
	public void insertar (Cliente c) throws SQLException;
	
	public static void crearCliente() {}

	public static void ConfirmarFecha() {}
	
	public static void VerificarRut() {}
	
	public static void LlenarDatos(Cliente cliente) {}
	
	//public List<?> mostrar (Registro r) throws SQLException;
	//public List<?> mostrar (Cliente c) throws SQLException;
	//public void insertar (Producto p) throws SQLException;
	//public void actualizar (Producto p) throws SQLException;
	
}
