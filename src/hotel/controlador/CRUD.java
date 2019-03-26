package hotel.controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hotel.controlador.Conexion;
import hotel.modelo.Cliente;
import hotel.vista.RegistroCliente;

public class CRUD {

	public  void insertar(int rut,String nombre, String apellidoP, String apellidoM,String sexo,String nacionalidad,String fechadenacimiento) throws SQLException {
		

		String sql= "INSERT INTO hoteldb.cliente (rut,nombre,patApellido,matApellido,sexo,fechaNac,nacionalidad)VALUES (?,?,?,?,?,?,?)";
		
		
		try {
			Conexion con=new Conexion(); 
		
			PreparedStatement ps=con.connect().prepareStatement(sql);
			
				
			ps.setInt(1, rut);
			ps.setString(2, nombre);
			ps.setString(3, apellidoP);
			ps.setString(4, apellidoM);
			ps.setString(5, sexo);
			ps.setString(6, nacionalidad);
			ps.setString(7, fechadenacimiento);
			
			
			ps.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	}
	


