package hotel.controlador;

import java.awt.Color;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import hotel.modelo.Habitacion;
import hotel.modelo.Registro;
import hotel.modelo.ReportesFull;
import hotel.vista.FreeRoom;
import hotel.vista.RegistroCliente;
import hotel.vista.ReservaHabitacion;

public class RegistroCrud {

	private static Component rootPane;
	public static double discount;
	public static int tres;
	public static int clients;
	public static int clienAmor = 0;

	public void insertar(Registro registro) throws SQLException, InterruptedException {

		String sql1 = "INSERT INTO hoteldb.registro (codigoReserva,horaIngreso,habitacion_idhabitacion,horaSalida,montoProducto) VALUES (?,?,?,?,?)";

		try {
			Conexion con = new Conexion();

			PreparedStatement ps1 = con.connect().prepareStatement(sql1);

			ps1.setInt(1, registro.getcodigoReserva());
			ps1.setTimestamp(2, registro.getHoraIngresoTimestamp());
			ps1.setInt(3, registro.getIdHabitacion());
			ps1.setTimestamp(4, registro.getHoraSalida());
			ps1.setInt(5, 0);
			ps1.executeUpdate();

		} catch (SQLException e) {

		}
	}

	public static void insertarRegistroHabitacion() throws SQLException {

		String sql2 = "INSERT INTO hoteldb.registro_has_habitacion (registro_codigoReserva, habitacion_idhabitacion) VALUES (?,?)";

		try {
			Conexion con = new Conexion();

			PreparedStatement ps2 = con.connect().prepareStatement(sql2);

			ps2.setInt(1, Integer.parseInt(ReservaHabitacion.txtCodigoReserva.getText()));
			ps2.setInt(2, ReservaHabitacion.CBoxHab.getSelectedIndex());

			ps2.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void crearRegistro() throws SQLException, InterruptedException {

		RegistroCrud C = new RegistroCrud();
		Registro registro = new Registro();
		Habitacion habitacion = new Habitacion();
		try {
			registro.setcodigoReserva(Integer.parseInt(ReservaHabitacion.txtCodigoReserva.getText()));

			registro.setHoraIngreso(Timestamp.valueOf(ReservaHabitacion.txtHoraIngreso.getText()));

			registro.setIdHabitacion(ReservaHabitacion.CBoxHab.getSelectedIndex());

			habitacion.setOcupantes(Integer.parseInt(ReservaHabitacion.txtCantidadOcupantes.getText()));
			registro.setHoraSalida(Timestamp.valueOf(ReservaHabitacion.txtHoraSalida.getText()));
			habitacion.setIdhabitacion(ReservaHabitacion.CBoxHab.getSelectedIndex());

			C.insertar(registro);
			new RegistroCliente().setVisible(true);

		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(rootPane, "El registro ya Existe.");

		}
	}

	public static void CBHabitacion(JComboBox<String> cbox_habitacion) throws SQLException {
		// ArrayList<Habitacion> hab = new ArrayList<Habitacion>();
		Conexion con = new Conexion();
		PreparedStatement pst = null;
		ResultSet result = null;
		String SQL = "SELECT nombreHabitacion,idhabitacion FROM hoteldb.habitacion";

		try {

			pst = con.connect().prepareStatement(SQL);
			result = pst.executeQuery();
			cbox_habitacion.addItem("Seleccione una opcion");

			while (result.next()) {
				cbox_habitacion.addItem(result.getString("idhabitacion").toString() + " - "
						+ result.getString("nombreHabitacion").toString());

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public static void obtenerReserva() throws SQLException {

		Registro registro = new Registro();
		ReportesFull reporte = new ReportesFull();

		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			// String query = "select * from cliente where rut=?";
			String query = "SELECT MAX(codigoReserva) FROM registro";
			// stmt.setInt(1,rut);

			stmt = con.connect().prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				// registro.getIdregistro();
				registro.setcodigoReserva((Integer.parseInt(rs.getObject("MAX(codigoReserva)").toString())) + 1);

			}
			ReservaHabitacion.txtCodigoReserva.setText(String.valueOf(registro.getcodigoReserva()));
			DateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			Date Timestamp = new Timestamp(calendar.getTime().getTime());
			ReservaHabitacion.txtHoraIngreso.setText(tf.format(Timestamp));

			calendar.setTime(new Date());
			calendar.add(Calendar.HOUR, 3);
			Timestamp tmsp = new Timestamp(calendar.getTimeInMillis());

			tmsp.setTime(Timestamp.getTime() + (1000 * 60 * 60 * ReportesFull.getEstadia()));
			ReservaHabitacion.txtHoraSalida.setText(tf.format(tmsp));

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
	}

	public static void montoH() {

		try {
			Conexion con = new Conexion();

			java.sql.PreparedStatement stmt = null;
			String montoH = "SELECT valorHora FROM habitacion WHERE idhabitacion= '"
					+ ReservaHabitacion.CBoxHab.getSelectedIndex() + "';";
			stmt = con.connect().prepareStatement(montoH);
			ResultSet rs = stmt.executeQuery();
			int vh;

			while (rs.next()) {

				vh = (rs.getInt("valorHora"));
				int ocu = Integer.parseInt(ReservaHabitacion.txtCantidadOcupantes.getText()) - clienAmor;

				ReservaHabitacion.lblPrecio.setText(String.valueOf(discount * vh * ReportesFull.getEstadia() * ocu));
				System.out.print(ocu);
			}

		} catch (Exception e) {

		}

	}

	public static void Pagar() {
		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String pagarH = "UPDATE `hoteldb`.`registro` SET `montoHabitacion` = '"
					+ ReservaHabitacion.lblPrecio.getText() + "' WHERE (`codigoReserva` = '"
					+ ReservaHabitacion.txtCodigoReserva.getText() + "') and (`habitacion_idhabitacion` = '"
					+ ReservaHabitacion.CBoxHab.getSelectedIndex() + "');";
			stmt = con.connect().prepareStatement(pagarH);
			stmt.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, "Calcule el monto a pagar.");
		}

	}

	public static void Descuento() {
		double ds = 1.0;
		double j = 0.1;
		try {
			int max = Integer.parseInt(ReservaHabitacion.txtCantidadOcupantes.getText());
			if (max > 7) {
				max = 7;
			} else {
				for (int i = 2; i < max; i++) {
					ds = 1.0 - j;
					j += 0.1;

				}
			}
			discount = ds;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, "La cantidad de Ocupantes esta vacia.");
		}
	}

	public static void revisarEstadoHabitacion() {
		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String status = "SELECT estado from habitacion where idhabitacion ="
					+ ReservaHabitacion.CBoxHab.getSelectedIndex() + ";";
			stmt = con.connect().prepareStatement(status);
			ResultSet rs = stmt.executeQuery();
			int estado = 0;
			while (rs.next()) {
				estado = rs.getInt("estado");

			}
			if (estado == 1) {

				ReservaHabitacion.lblStatus.setText("NO DISPONIBLE.");
				ReservaHabitacion.lblStatus.setForeground(Color.red);

			} else {
				ReservaHabitacion.lblStatus.setText("DISPONIBLE.");
				ReservaHabitacion.lblStatus.setForeground(Color.green);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void actualizarEstadoHabitacion() {
		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String sts = "UPDATE `hoteldb`.`habitacion` SET `estado` = '1' WHERE (`idhabitacion` = '"
					+ ReservaHabitacion.CBoxHab.getSelectedIndex() + "');";
			stmt = con.connect().prepareStatement(sts);
			stmt.executeUpdate();
		} catch (SQLException e) {

		}

	}

	public static void revisarReservas() {
		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String treserva = "SELECT totalReservas from habitacion where idhabitacion ="
					+ ReservaHabitacion.CBoxHab.getSelectedIndex() + ";";
			stmt = con.connect().prepareStatement(treserva);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				tres = rs.getInt("totalReservas");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void actualizarReservas() {
		try {
			int upRes = tres + 1;
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String sts = "UPDATE `hoteldb`.`habitacion` SET `totalReservas` = '" + upRes + "' WHERE (`idhabitacion` = '"
					+ ReservaHabitacion.CBoxHab.getSelectedIndex() + "');";
			stmt = con.connect().prepareStatement(sts);
			stmt.executeUpdate();
			System.out.println(upRes);
		} catch (SQLException e) {

		}
	}

	public static void revisarClientes() {
		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String treserva = "SELECT totalClientes from habitacion where idhabitacion ="
					+ ReservaHabitacion.CBoxHab.getSelectedIndex() + ";";
			stmt = con.connect().prepareStatement(treserva);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				clients = rs.getInt("totalClientes");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void actualizarClientes() {
		try {
			int upCli = clients + Integer.parseInt(ReservaHabitacion.txtCantidadOcupantes.getText());

			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String sts = "UPDATE `hoteldb`.`habitacion` SET `totalClientes` = '" + upCli + "' WHERE (`idhabitacion` = '"
					+ ReservaHabitacion.CBoxHab.getSelectedIndex() + "');";
			stmt = con.connect().prepareStatement(sts);
			stmt.executeUpdate();
			System.out.println(upCli);
		} catch (SQLException e) {

		}
	}

	public static void revisarEstadoHabitacion2() {
		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String status = "SELECT estado from habitacion where idhabitacion =" + FreeRoom.comboBox.getSelectedIndex()
					+ ";";
			stmt = con.connect().prepareStatement(status);
			ResultSet rs = stmt.executeQuery();
			int estado = 0;
			while (rs.next()) {
				estado = rs.getInt("estado");

			}
			if (estado == 1) {

				FreeRoom.lblStatus.setText("NO DISPONIBLE.");
				FreeRoom.lblStatus.setForeground(Color.red);
			} else {

				FreeRoom.lblStatus.setText("DISPONIBLE.");
				FreeRoom.lblStatus.setForeground(Color.green);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void desocuparHabitacion() {
		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String sts = "UPDATE `hoteldb`.`habitacion` SET `estado` = '0' WHERE (`idhabitacion` = '"
					+ FreeRoom.comboBox.getSelectedIndex() + "');";
			stmt = con.connect().prepareStatement(sts);
			stmt.executeUpdate();
		} catch (SQLException e) {

		}

	}

	public static void EstadoLibre() {
		FreeRoom.lblStatus.setText("DISPONIBLE.");
		FreeRoom.lblStatus.setForeground(Color.green);
	}

}
