package hotel.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;

import hotel.modelo.Producto;

public class ProductoCrud {

	@SuppressWarnings({ "unchecked" })
	public static ArrayList<Producto> mostrar() {
		Conexion con = new Conexion();

		ArrayList<Producto> productos = null;
		
		try {
			
			PreparedStatement stmt = null;
			String query1 = "SELECT * FROM producto";
			stmt = con.connect().prepareStatement(query1);
			ResultSet r = stmt.executeQuery(query1);
			productos = new ArrayList<Producto>();

			Producto pr = new Producto();
		
			while (r.next()) {
				pr = new Producto(Integer.parseInt(r.getObject("idproducto").toString()),
						r.getObject("nombreProducto").toString(),
						Integer.valueOf(r.getObject("valorProducto").toString()),
						Integer.valueOf(r.getObject("stock").toString()));
				

				productos.add(pr);
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		/*
		 * for (int i=0;i<productos.size();i++) { 
		 * System.out.println(productos.get(i));
		 * }
		 */
		
		return productos;
	}

	

/*


@SuppressWarnings("unlikely-arg-type")
public static JList<Producto> llenar(){
	Conexion con = new Conexion();
	JList<Producto>jproductos=null;
	try {
		
		PreparedStatement stmt = null;
		String query1 = "SELECT * FROM producto";
		stmt = con.connect().prepareStatement(query1);
		ResultSet r = stmt.executeQuery(query1);
		jproductos = new JList<Producto>();

		
		Producto jpr = new Producto();

		while (r.next()) {
			jpr = new Producto(Integer.parseInt(r.getObject("idproducto").toString()),
					r.getObject("nombreProducto").toString(),
					Integer.valueOf(r.getObject("valorProducto").toString()),
					Integer.valueOf(r.getObject("stock").toString()));
			

			
			jproductos(jpr);
		}

	} catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	
	return jproductos;
}    */
}