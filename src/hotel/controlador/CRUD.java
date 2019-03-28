package hotel.controlador;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import hotel.modelo.Cliente;
import hotel.vista.RegistroCliente;

public class CRUD {

	private static Component rootPane;

	public void insertar(Cliente cliente) throws SQLException {

		String sql = "INSERT INTO hoteldb.cliente (rut,nombre,patApellido,matApellido,sexo,fechaNac,nacionalidad)VALUES (?,?,?,?,?,?,?)";

		try {
			Conexion con = new Conexion();

			PreparedStatement ps = con.connect().prepareStatement(sql);

			ps.setInt(1, cliente.getRut());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidoP());
			ps.setString(4, cliente.getApellidoM());
			ps.setString(5, cliente.getSexo());
			ps.setString(6, cliente.getFechadenacimiento());
			ps.setString(7, cliente.getNacionalidad());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void CBHabitacion(JComboBox cbox_habitacion) {

		Conexion con = new Conexion();
		PreparedStatement pst = null;
		ResultSet result = null;
		String SQL = "SELECT nombreHabitacion FROM hoteldb.habitacion";

		try {

			pst = con.connect().prepareStatement(SQL);
			result = pst.executeQuery();
			cbox_habitacion.addItem("Seleccione una opción");

			while (result.next()) {
				cbox_habitacion.addItem(result.getString("nombreHabitacion"));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}


	
	public static void crearCliente() {
		
		CRUD C=new CRUD();
		Cliente cliente= new Cliente();
		cliente.setRut(Integer.parseInt(RegistroCliente.txtRut.getText()));
		cliente.setNombre(RegistroCliente.txtNombre.getText());
		cliente.setApellidoP(RegistroCliente.txtApellidoP.getText());
		cliente.setApellidoM(RegistroCliente.txtApellidoM.getText());
		cliente.setSexo(RegistroCliente.txtSexo.getText());
		cliente.setFechadenacimiento(RegistroCliente.txtFecha.getText());
		cliente.setNacionalidad(RegistroCliente.txtNacionalidad.getText());
		
		try {
			System.out.print(cliente);
			
			C.insertar(cliente);
		}catch(SQLException e) {
			
		}
	}

	public static void ConfirmarFecha() {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		RegistroCliente.txtFecha.setText(df.format(RegistroCliente.dateChooser.getDate()));
		JOptionPane.showMessageDialog(rootPane, "Fecha de nacimiento ingresada.");
		
	}
	
	@SuppressWarnings("null")
	public static void VerificarRut() {
		int rut=Integer.parseInt(RegistroCliente.txtRut.getText());
	   
	        Cliente cliente=Cliente.getInstance();
	        try {
	        	Conexion con = new Conexion();
	            java.sql.PreparedStatement stmt=null;
	            //String query = "select * from cliente where rut=?";
	            String query = "select * from cliente where `rut` = '" +rut+ "'";
	            //stmt.setInt(1,rut);
	            
	            stmt = con.connect().prepareStatement(query);
	            ResultSet rs = stmt.executeQuery(query);

	            while (rs.next()) {
	                cliente.setRut(Integer.parseInt(rs.getObject("rut").toString()));
	                cliente.setNombre(rs.getObject("nombre").toString());
	                cliente.setApellidoP(rs.getObject("patApellido").toString());
	                cliente.setApellidoM(rs.getObject("matApellido").toString());
	                cliente.setSexo(rs.getObject("sexo").toString());
	                cliente.setFechadenacimiento((rs.getObject("fechaNac").toString()));
	                cliente.setNacionalidad(rs.getObject("nacionalidad").toString());
	              
	            }
	        } catch (SQLException e) {

	            System.out.println(e.getMessage());
	        }
	    }
		
	public static void LlenarDatos(Cliente cliente) {
	   /* public static void setDatosPasajero(JTextField txtRut, JTextField txtNombre,
	            JTextField txtApellido, JTextField txtDireccion, JTextField txtTelefono, JTextField txtSexo) {
*/
	       
	        RegistroCliente.txtRut.setText(String.valueOf(cliente.getRut()));
	        RegistroCliente.txtNombre.setText(cliente.getNombre());
	        RegistroCliente.txtApellidoP.setText(cliente.getApellidoP());
	        RegistroCliente.txtApellidoM.setText(cliente.getApellidoM());
	        RegistroCliente.txtSexo.setText(cliente.getSexo());
	        RegistroCliente.txtFecha.setText(cliente.getFechadenacimiento());
	        RegistroCliente.txtNacionalidad.setText(cliente.getNacionalidad());
	    }
		
	
		
	
	

}
