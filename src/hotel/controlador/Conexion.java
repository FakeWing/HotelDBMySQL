package hotel.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public Connection connect() {
		Connection conn=null;
		
		String url="jdbc:mysql://localhost/hoteldb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user="root";
		String pass="admin";
		System.out.println("Conectando...");
		
		try {
			//conn = DriverManager.getConnection(url+"?verifyServerCertificate=true"+"&userSSL=true"+"&requireSSL=true",user,pass);
			conn = DriverManager.getConnection(url,user,pass);
			
			
			System.out.println("Conexion exitosa...");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}

}

