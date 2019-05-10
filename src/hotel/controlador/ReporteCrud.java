package hotel.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import hotel.vista.Reportes;
import net.proteanit.sql.DbUtils;

public class ReporteCrud {
	static int rut = 0;
	static String nombre=null;
	static String nombreP=null;

	public static void tablaClienteAmor() {
		Conexion con = new Conexion();

		try {
			java.sql.PreparedStatement p1 = null;

			String q1 = "SELECT COUNT(*) AS Numero_de_Visitas, rut, nombre, patApellido, matApellido, sexo, fechaNac, nacionalidad FROM (((cliente INNER JOIN registro_has_cliente ON rut = cliente_rut) INNER JOIN registro ON codigoReserva = registro_codigoReserva) INNER JOIN habitacion ON idhabitacion = habitacion_idhabitacion) group by cliente_rut ORDER BY Numero_de_Visitas DESC LIMIT 1;";

			p1 = con.connect().prepareStatement(q1);

			ResultSet rs = p1.executeQuery(q1);
			Reportes.table_2.setModel(DbUtils.resultSetToTableModel(rs));
			ResultSet rs1 = p1.executeQuery(q1);
			while (rs1.next()) {
				rut = Integer.parseInt(rs1.getObject("rut").toString());

			}
			System.out.print(rut);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void cliendeDelAmor() {
		Conexion con = new Conexion();
		try {
			java.sql.PreparedStatement p2 = null;
			System.out.println(rut);
			String q2 = "SELECT rut, codigoReserva, nombreHabitacion FROM (((cliente INNER JOIN registro_has_cliente ON rut = cliente_rut) INNER JOIN registro ON codigoReserva = registro_codigoReserva) INNER JOIN habitacion ON idhabitacion = habitacion_idhabitacion) WHERE rut ="
					+ rut + ";";
			p2 = con.connect().prepareStatement(q2);
			ResultSet rs2 = p2.executeQuery(q2);

			Reportes.table.setModel(DbUtils.resultSetToTableModel(rs2));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void limpiar() {

		Reportes.table.setModel(Reportes.tableModel2);
		Reportes.table_2.setModel(Reportes.tableModel2);
		Reportes.tableModel2.setRowCount(0);
	}

	public static void consultRut(String rut) {
		Conexion con = new Conexion();

		try {
			java.sql.PreparedStatement p3 = null;
			String q2 = "SELECT rut, nombre, patApellido, matApellido, sexo, fechaNac, nacionalidad, codigoReserva, nombreHabitacion, montoProducto FROM (((cliente INNER JOIN registro_has_cliente ON rut = cliente_rut) INNER JOIN registro ON codigoReserva = registro_codigoReserva) INNER JOIN habitacion ON idhabitacion = habitacion_idhabitacion) WHERE rut = "
					+ rut + ";";
			p3 = con.connect().prepareStatement(q2);
			ResultSet rs = p3.executeQuery(q2);
			Reportes.table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void topHab() {
		Conexion con = new Conexion();
		try {
			java.sql.PreparedStatement p1 = null;

			String q1 = "SELECT COUNT(DISTINCTROW registro_codigoReserva) AS Max_Cantidad_Visitas, nombreHabitacion, totalProductos as Gasto_Total FROM (((cliente INNER JOIN registro_has_cliente ON rut = cliente_rut) INNER JOIN registro ON codigoReserva = registro_codigoReserva) INNER JOIN habitacion ON idhabitacion = habitacion_idhabitacion) GROUP BY nombreHabitacion ORDER BY Max_Cantidad_Visitas DESC LIMIT 1;";

			p1 = con.connect().prepareStatement(q1);

			ResultSet rs = p1.executeQuery(q1);
			Reportes.table_2.setModel(DbUtils.resultSetToTableModel(rs));
			ResultSet rs1 = p1.executeQuery(q1);
			while (rs1.next()) {
				nombre = (rs1.getObject("nombreHabitacion").toString());

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void topHab1() {
		Conexion con = new Conexion();
		try {
			java.sql.PreparedStatement p2 = null;
			
			String q2 = "SELECT nombreHabitacion, rut, codigoReserva, montoProducto FROM (((cliente INNER JOIN registro_has_cliente ON rut = cliente_rut) INNER JOIN registro ON codigoReserva = registro_codigoReserva) INNER JOIN habitacion ON idhabitacion = habitacion_idhabitacion) WHERE nombreHabitacion = '"+nombre+"';";
					
			p2 = con.connect().prepareStatement(q2);
			ResultSet rs2 = p2.executeQuery(q2);

			Reportes.table.setModel(DbUtils.resultSetToTableModel(rs2));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void lowHab() {
		Conexion con = new Conexion();
		try {
			java.sql.PreparedStatement p1 = null;

			String q1 = "SELECT COUNT(DISTINCTROW registro_codigoReserva) AS Max_Cantidad_Reservas, nombreHabitacion, totalProductos as Gasto_Total FROM (((cliente INNER JOIN registro_has_cliente ON rut = cliente_rut) INNER JOIN registro ON codigoReserva = registro_codigoReserva) INNER JOIN habitacion ON idhabitacion = habitacion_idhabitacion) GROUP BY nombreHabitacion ORDER BY Max_Cantidad_Reservas ASC LIMIT 1;";

			p1 = con.connect().prepareStatement(q1);

			ResultSet rs = p1.executeQuery(q1);
			Reportes.table_2.setModel(DbUtils.resultSetToTableModel(rs));
			ResultSet rs1 = p1.executeQuery(q1);
			while (rs1.next()) {
				nombre = (rs1.getObject("nombreHabitacion").toString());

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void lowHab1() {
		Conexion con = new Conexion();
		try {
			java.sql.PreparedStatement p2 = null;
			
			String q2 = "SELECT nombreHabitacion, rut, codigoReserva, montoProducto FROM (((cliente INNER JOIN registro_has_cliente ON rut = cliente_rut) INNER JOIN registro ON codigoReserva = registro_codigoReserva) INNER JOIN habitacion ON idhabitacion = habitacion_idhabitacion) WHERE nombreHabitacion = '"+nombre+"';";
					
			p2 = con.connect().prepareStatement(q2);
			ResultSet rs2 = p2.executeQuery(q2);

			Reportes.table.setModel(DbUtils.resultSetToTableModel(rs2));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void maxProducto() {
		Conexion con = new Conexion();
		try {
			java.sql.PreparedStatement p1 = null;

			String q1 = "select producto_idproducto as idProducto ,count(producto_idproducto) as Vendidos from registro_has_producto group by producto_idproducto ORDER BY Vendidos DESC LIMIT 1; ";

			p1 = con.connect().prepareStatement(q1);

			ResultSet rs = p1.executeQuery(q1);
			Reportes.table_2.setModel(DbUtils.resultSetToTableModel(rs));
			ResultSet rs1 = p1.executeQuery(q1);
			while (rs1.next()) {
				nombreP = (rs1.getObject("idProducto").toString());

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void lessProducto() {
		Conexion con = new Conexion();
		try {
			java.sql.PreparedStatement p1 = null;

			String q1 = "select producto_idproducto as idProducto ,count(producto_idproducto) as Vendidos from registro_has_producto group by producto_idproducto ORDER BY Vendidos ASC LIMIT 1; ";
			p1 = con.connect().prepareStatement(q1);

			ResultSet rs = p1.executeQuery(q1);
			Reportes.table_2.setModel(DbUtils.resultSetToTableModel(rs));
			ResultSet rs1 = p1.executeQuery(q1);
			while (rs1.next()) {
				nombreP = (rs1.getObject("idProducto").toString());

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
	public static void WhereProducto() {
		Conexion con = new Conexion();
		try {
			java.sql.PreparedStatement p2 = null;
			
			String q2 = "select nombreHabitacion, count(producto_idproducto) from ((habitacion INNER JOIN registro on idhabitacion=habitacion_idhabitacion) INNER JOIN registro_has_producto ON registro_codigoReserva=codigoReserva) WHERE producto_idproducto="+nombreP+"  group by nombreHabitacion; ";
					
			p2 = con.connect().prepareStatement(q2);
			ResultSet rs2 = p2.executeQuery(q2);

			Reportes.table.setModel(DbUtils.resultSetToTableModel(rs2));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void maxAverage() {
	Conexion con = new Conexion();
	try {
		java.sql.PreparedStatement p2 = null;
		
		String q2 = "select nombreHabitacion, (totalClientes/totalReservas) as PromedioCliente from habitacion order by PromedioCliente DESC LIMIT 1";	
		p2 = con.connect().prepareStatement(q2);
		ResultSet rs2 = p2.executeQuery(q2);

		Reportes.table.setModel(DbUtils.resultSetToTableModel(rs2));

	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
	public static void lessAverage() {
		Conexion con = new Conexion();
		try {
			java.sql.PreparedStatement p2 = null;
			
			String q2 = "select nombreHabitacion, (totalClientes/totalReservas) as PromedioCliente from habitacion order by PromedioCliente ASC LIMIT 1";
					
			p2 = con.connect().prepareStatement(q2);
			ResultSet rs2 = p2.executeQuery(q2);

			Reportes.table.setModel(DbUtils.resultSetToTableModel(rs2));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
