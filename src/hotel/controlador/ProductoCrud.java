package hotel.controlador;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JList;
import javax.swing.JOptionPane;

import hotel.modelo.Cliente;
import hotel.modelo.Producto;
import hotel.modelo.Registro;
import hotel.modelo.ReportesFull;
import hotel.vista.RegistroCliente;
import hotel.vista.RegistroProductos;
import hotel.vista.ReservaHabitacion;

public class ProductoCrud {

	private static Component rootPane;
	public static int tprod;

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
						Integer.parseInt(r.getObject("stock").toString()));

				productos.add(pr);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return productos;
	}

	public static void buscarReg() {
		int codRes = Integer.parseInt(RegistroProductos.txtCodReserva.getText());
		if (RegistroProductos.txtCodReserva.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Ingrese un Codigo de Reserva.");

		} else {
			try {
				Conexion con = new Conexion();
				java.sql.PreparedStatement stmt = null;
				String rg = "SELECT `habitacion_idhabitacion` FROM registro WHERE `codigoReserva` = '" + codRes + "'";

				stmt = con.connect().prepareStatement(rg);
				ResultSet rs = stmt.executeQuery(rg);

				while (rs.next()) {
					RegistroProductos.lblhabitacion.setText((rs.getObject("habitacion_idhabitacion").toString()));

				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(rootPane, "Ingrese un Codigo de Reserva.");
			}
		}

	}

	public static void obtenerPedido() {

		Producto producto = new Producto();

		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;

			String query = "SELECT MAX(idpedido) FROM registro_has_producto";
			stmt = con.connect().prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				producto.setIdpedido((Integer.parseInt(rs.getObject("MAX(idpedido)").toString())) + 1);

			}
			RegistroProductos.pedido = (producto.getIdpedido());

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
	}

	public static void revisarProductos() {
		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String tproducto = "SELECT totalProductos from habitacion where idhabitacion ="
					+ RegistroProductos.lblhabitacion.getText() + ";";
			stmt = con.connect().prepareStatement(tproducto);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				tprod = rs.getInt("totalProductos");
			}
			System.out.println(tprod);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void actualizarProductos() {
		try {
			double upPro = tprod + (RegistroProductos.total);

			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String sts = "UPDATE `hoteldb`.`habitacion` SET `totalProductos` = '" + upPro
					+ "' WHERE (`idhabitacion` = '" + RegistroProductos.lblhabitacion.getText() + "');";
			stmt = con.connect().prepareStatement(sts);
			stmt.executeUpdate();
			System.out.println(upPro);
		} catch (SQLException e) {

		}
	}

	public static void revisarProductosM() {
		try {
			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String tproducto = "SELECT montoProducto from registro where codigoReserva ="
					+ RegistroProductos.txtCodReserva.getText() + ";";
			stmt = con.connect().prepareStatement(tproducto);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				tprod = rs.getInt("montoProducto");
			}
			System.out.println(tprod);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void actualizarProductosM() {
		try {
			double upPro = tprod + (RegistroProductos.total);

			Conexion con = new Conexion();
			java.sql.PreparedStatement stmt = null;
			String sts = "UPDATE `hoteldb`.`registro` SET `montoProducto` = '" + upPro + "' WHERE (`codigoReserva` = '"
					+ RegistroProductos.txtCodReserva.getText() + "');";
			stmt = con.connect().prepareStatement(sts);
			stmt.executeUpdate();
			System.out.println(upPro);
		} catch (SQLException e) {

		}
	}

}