package hotel.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import hotel.modelo.Habitacion;
import hotel.modelo.Registro;
import hotel.vista.RegistroCliente;
import hotel.vista.ReservaHabitacion;

public class RegistroCrud {

	
	public void insertar(Registro registro) throws SQLException, InterruptedException {

		String sql1 = "INSERT INTO hoteldb.registro (codigoReserva,horaIngreso,habitacion_idhabitacion) VALUES (?,?,?)";

		try {
			Conexion con = new Conexion();

			PreparedStatement ps1 = con.connect().prepareStatement(sql1);

			ps1.setInt(1, registro.getcodigoReserva());
			ps1.setTimestamp(2,registro.getHoraIngresoTimestamp());
			ps1.setInt(3, registro.getIdHabitacion());
			ps1.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertarRegistroHabitacion() throws SQLException, InterruptedException {

		//RegistroCrud C=new RegistroCrud();
		Registro registro = new Registro();

		String sql2 = "INSERT INTO hoteldb.registro_has_cliente (registro_codigoReserva,habitacion_idhabitacion) VALUES (?,?)";

		try {
			Conexion con = new Conexion();

			
			PreparedStatement ps2 = con.connect().prepareStatement(sql2);

			
			ps2.setInt(1, registro.getcodigoReserva());
			ps2.setInt(2, registro.getIdHabitacion());
			ps2.setInt(3, registro.getCliente_rut());
			ps2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void crearRegistro() throws SQLException, InterruptedException {
		
		RegistroCrud C=new RegistroCrud();
		Registro registro = new Registro();
		Habitacion habitacion =new Habitacion();

		registro.setcodigoReserva(Integer.parseInt(ReservaHabitacion.txtCodigoReserva.getText()));
		
		registro.setHoraIngreso(Timestamp.valueOf(ReservaHabitacion.txtHoraIngreso.getText()));
		//registro.setHoraIngreso(Timestamp.valueOf(LocalDateTime.now()));
		//registro.setIdHabitacion(int)(String.valueOf(hab));
		registro.setIdHabitacion(ReservaHabitacion.CBoxHab.getSelectedIndex());
		habitacion.setOcupantes(Integer.parseInt(ReservaHabitacion.txtCantidadOcupantes.getText()));
		/*
		cliente.setNombre(RegistroCliente.txtNombre.getText());
		*/
		try {
			System.out.print(registro);
			
			C.insertar(registro);
		 new RegistroCliente().setVisible(true);
			
		}catch(SQLException e) {
			
		}
	}
	
	public static void CBHabitacion(JComboBox<String> cbox_habitacion) throws SQLException {
		//ArrayList<Habitacion> hab = new ArrayList<Habitacion>();
		Conexion con = new Conexion();
		PreparedStatement pst = null;
		ResultSet result = null;
		String SQL = "SELECT nombreHabitacion,idhabitacion FROM hoteldb.habitacion";

		try {

			pst = con.connect().prepareStatement(SQL);
			result = pst.executeQuery();
			cbox_habitacion.addItem("Seleccione una opcion");

			while (result.next()) {
				cbox_habitacion.addItem(result.getString("idhabitacion").toString()+" - "+result.getString("nombreHabitacion").toString());
				//int id =(int)result.getObject("idhabitacion");
				//hab.add(new Habitacion(id));
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		//return hab;
	}
		
	public static void obtenerReserva () throws SQLException {
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
                registro.setcodigoReserva((Integer.parseInt(rs.getObject("MAX(codigoReserva)").toString()))+1);
              
            }
            ReservaHabitacion.txtCodigoReserva.setText(String.valueOf(registro.getcodigoReserva()));
    		DateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		Calendar calendar = Calendar.getInstance();
    		Date Timestamp = new Timestamp(calendar.getTime().getTime());
    		ReservaHabitacion.txtHoraIngreso.setText(tf.format(Timestamp));
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
	}
}
	


