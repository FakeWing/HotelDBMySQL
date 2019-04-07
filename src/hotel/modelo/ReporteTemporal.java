package hotel.modelo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class ReporteTemporal {
	
	public void reporte() throws SQLException {
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb5", "root", "password");
	
	Statement s = (Statement) conexion.createStatement();
	ResultSet rs = s.executeQuery("select registro.montoHabitacion, habitacion.nombreHabitacion\r\n" + 
			"from habitacion \r\n" + 
			"join registro_has_habitacion \r\n" + 
			"ON registro_has_habitacion.habiacion_idhabitacion=habitacion.idhabitacion\r\n" + 
			"join registro\r\n" + 
			"ON registro.codigoReserva=registro_has_habitacion.registro_codigoReserva\r\n" + 
			"where registro.codigoReserva =101;");
	
	
	
	DefaultTableModel modelo = new DefaultTableModel();
	JTable tabla = new JTable(modelo);
	
	ResultSetMetaData metaDatos = rs.getMetaData();
		
	int numeroColumnas = metaDatos.getColumnCount();
	
	Object[] etiquetas = new Object[numeroColumnas];
	
	for (int i = 0; i < numeroColumnas; i++)
	{ 
	   etiquetas[i] = metaDatos.getColumnLabel(i + 1); 
	}
	
	modelo.setColumnIdentifiers(etiquetas);
	
	while (rs.next())
	{   
	   Object [] fila = new Object[numeroColumnas]; 
 
	   for (int i=0;i<numeroColumnas;i++)
	      fila[i] = rs.getObject(i+1); 

	   modelo.addRow(fila); 
	}
	
	
	 
	
	}
}
