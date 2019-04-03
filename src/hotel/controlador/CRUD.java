package hotel.controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hotel.modelo.Cliente;
import hotel.modelo.Producto;
import hotel.modelo.Registro;
import hotel.vista.RegistroCliente;
import hotel.vista.ReservaHabitacion;

public class CRUD extends JFrame {

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

	public static void CBHabitacion(JComboBox cbox_habitacion) {

		Conexion con = new Conexion();
		PreparedStatement pst = null;
		ResultSet result = null;
		String SQL = "SELECT nombreHabitacion,idhabitacion FROM hoteldb.habitacion";

		try {

			pst = con.connect().prepareStatement(SQL);
			result = pst.executeQuery();
			cbox_habitacion.addItem("Seleccione una opción");

			while (result.next()) {
				cbox_habitacion.addItem(result.getString("idhabitacion").toString()+"-"+result.getString("nombreHabitacion").toString());
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
		
	
		
	public static ArrayList<Producto> mostrar() {
        Conexion con = new Conexion();
        
        ArrayList<Producto> productos = null;
        
        try 
        {
            PreparedStatement stmt = null;
            String query1 = "SELECT * FROM producto";
            stmt = con.connect().prepareStatement(query1);
            ResultSet r = stmt.executeQuery(query1);
            productos = new ArrayList<Producto>();
            
            Producto pr;
            
            while(r.next()) {
                pr = new Producto(r.getObject("nombreProducto").toString(),Integer.valueOf(r.getObject("valorProducto").toString()),Integer.valueOf(r.getObject("cantidadProducto").toString()), 0);
                productos.add(pr);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return productos;
    }
	
	public void insertar(Registro registro) throws SQLException {

		String sql1 = "INSERT INTO hoteldb.registro (codReserva,horaIngreso,idHabitacion) VALUES (?,?,?)";
		String sql2 = "INSERT INTO hoteldb.registro_has_cliente (registro_codigoReserva,cliente_rut) VALUES (?,?)";

		try {
			Conexion con = new Conexion();

			PreparedStatement ps1 = con.connect().prepareStatement(sql1);
			PreparedStatement ps2 = con.connect().prepareStatement(sql2);

			ps1.setInt(1, registro.getRegistro_codigoReserva());
			ps1.setTimestamp(2,registro.getHoraIngreso());
			ps1.setInt(3, registro.getIdHabitacion());

			ps2.setInt(1, registro.getIdregistro());
			ps2.setInt(2, registro.getCliente_rut());
			
			ps1.executeUpdate();
			ps2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void crearRegistro() {
		CRUD C=new CRUD();
		Registro registro = new Registro();
		registro.setRegistro_codigoReserva(Integer.parseInt(ReservaHabitacion.txtCodigoReserva.getText()));
		
		registro.setHoraIngreso(Timestamp.valueOf(ReservaHabitacion.txtHoraIngreso.getText()));
		//registro.setHoraIngreso(Timestamp.valueOf(LocalDateTime.now()));
		//registro.setIdHabitacion(int)(String.valueOf(hab));
		
		registro.setIdHabitacion(ReservaHabitacion.id);
		/*
		cliente.setNombre(RegistroCliente.txtNombre.getText());
		*/
		try {
			System.out.print(registro);
			
			C.insertar(registro);
		}catch(SQLException e) {
			
		}
	}
	

	
	

	public static void obtenerReserva () {
		Registro registro = new Registro();
		//int rut=Integer.parseInt(RegistroCliente.txtRut.getText());
		  //int cod; 
        //Cliente cliente=Cliente.getInstance();
        try {
        	Conexion con = new Conexion();
            java.sql.PreparedStatement stmt=null;
            //String query = "select * from cliente where rut=?";
            String query = "SELECT MAX(codigoReserva) FROM registro";
            //stmt.setInt(1,rut);
            
            stmt = con.connect().prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
            	//registro.getIdregistro();
                registro.setIdregistro((Integer.parseInt(rs.getObject("MAX(codigoReserva)").toString()))+1);
              
            }
            ReservaHabitacion.txtCodigoReserva.setText(String.valueOf(registro.getIdregistro()));
    		DateFormat tf = new SimpleDateFormat("yyyy-MM-dd h:mm a");
    		Calendar calendar = Calendar.getInstance();
    		Date Timestamp = new Timestamp(calendar.getTime().getTime());
    		ReservaHabitacion.txtHoraIngreso.setText(tf.format(Timestamp));
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
	}

}
