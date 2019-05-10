package hotel.controlador;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hotel.modelo.Cliente;
import hotel.modelo.Habitacion;
import hotel.modelo.Registro;
import hotel.vista.RegistroCliente;
import hotel.vista.Reportes;
import net.proteanit.sql.DbUtils;

public class CRUD extends JFrame implements Dao {

	private static Component rootPane;
	private static int amorRut;

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
			JOptionPane.showMessageDialog(rootPane, "Cliente ya existe en la base de datos.");
		}
	}

	@SuppressWarnings("unchecked")
	public static void CBHabitacion(JComboBox cbox_habitacion) {

		Conexion con = new Conexion();
		PreparedStatement pst = null;
		ResultSet result = null;
		String SQL = "SELECT nombreHabitacion,idhabitacion FROM hoteldb.habitacion";

		try {

			pst = con.connect().prepareStatement(SQL);
			result = pst.executeQuery();
			cbox_habitacion.addItem("Seleccione una opcion");

			while (result.next()) {
				cbox_habitacion.addItem(result.getString("idhabitacion").toString() + "-"
						+ result.getString("nombreHabitacion").toString());
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public static void crearCliente() {

		CRUD C = new CRUD();
		Cliente cliente = new Cliente();
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
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(rootPane, "Cliente ya existe en la base de datos.");
		}
	}

	public static void ConfirmarFecha() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		RegistroCliente.txtFecha.setText(df.format(RegistroCliente.dateChooser.getDate()));
		JOptionPane.showMessageDialog(rootPane, "Fecha de nacimiento ingresada.");

	}

	public static void VerificarRut() {

		int rut = Integer.parseInt(RegistroCliente.txtRut.getText());
		if (RegistroCliente.txtRut.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Ingrese un rut.");

		} else {

			Cliente cliente = Cliente.getInstance();
			try {
				Conexion con = new Conexion();
				java.sql.PreparedStatement stmt = null;

				String query = "select * from cliente where `rut` = '" + rut + "'";

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
			} catch (SQLException | NumberFormatException e) {
				JOptionPane.showMessageDialog(rootPane, "Datos incorrectos o cliente no existe en la base de datos.");
				JOptionPane.showMessageDialog(rootPane, "Datos incorrectos o cliente no existe en la base de datos.");

			}
		}
	}

	public static void LlenarDatos(Cliente cliente) {

		RegistroCliente.txtRut.setText(String.valueOf(cliente.getRut()));
		RegistroCliente.txtNombre.setText(cliente.getNombre());
		RegistroCliente.txtApellidoP.setText(cliente.getApellidoP());
		RegistroCliente.txtApellidoM.setText(cliente.getApellidoM());
		RegistroCliente.txtSexo.setText(cliente.getSexo());
		RegistroCliente.txtFecha.setText(cliente.getFechadenacimiento());
		RegistroCliente.txtNacionalidad.setText(cliente.getNacionalidad());
	}

	public static List<Cliente> mostrar() throws Exception {
		ResultSet res;
		List listavalores = new ArrayList();
		try {

			String query1 = "SELECT * FROM hoteldb";

			PreparedStatement pre = null;
			res = pre.executeQuery();
			while (res.next()) {

				res.getInt("rut");
				res.getString("nombre");
				res.getString("patApellido");
				res.getString("matApellido");
				res.getString("sexo");
				res.getString("fechaNac");
				res.getString("nacionalidad");

				listavalores.add(res);
			}

		} catch (Exception e) {

		}
		System.out.print(listavalores);
		return listavalores;

	}

	public ArrayList<Cliente> clientlist() {
		ArrayList<Cliente> clientlist = new ArrayList<>();

		try {
			String query1 = "SELECT * FROM Cliente";
			ResultSet res;
			PreparedStatement pre = null;
			res = pre.executeQuery();
			Cliente cliente;
			while (res.next()) {

				cliente = new Cliente(res.getInt("rut"), res.getString("nombre"), res.getString("patApellido"),
						res.getString("matApellido"), res.getString("sexo"), res.getString("fechaNac"),
						res.getString("nacionalidad"));

				clientlist.add(cliente);
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e);
		}
		System.out.print(clientlist);
		return clientlist;

	}

	public static void reportear() {
		Connection conn = (Connection) new Conexion();
		try {
			PreparedStatement st = conn.prepareStatement("Select * from hoteldb;");
			ResultSet rs = st.executeQuery();
			Reportes.table.setModel(DbUtils.resultSetToTableModel(rs));
			conn.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}

	public static void valoresTabla() throws SQLException {
		Conexion con = new Conexion();
		int[] ruts = new int[Habitacion.getOcupantes()];
		for (int i = 0; i < Habitacion.getOcupantes(); i++) {
			ruts[i] = Integer.parseInt((String) RegistroCliente.table.getModel().getValueAt(i, 0));

		}
		try {
			System.out.println(RegistroCliente.table.getModel().getRowCount());
			for (int i = 0; i < ruts.length; i++) {
				System.out.print(ruts[i]);
				String reg = "INSERT INTO `hoteldb`.`registro_has_cliente` (`registro_codigoReserva`, `registro_habitacion_idhabitacion`, `cliente_rut`) VALUES ('"
						+ Integer.parseInt(RegistroCliente.txtReserva.getText()) + "', '" + Habitacion.getIdhabitacion()
						+ "', '" + ruts[i] + "');";

				PreparedStatement ps = con.connect().prepareStatement(reg);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(rootPane, "Ese registro ya existe.");
		}

	}

	@SuppressWarnings("unlikely-arg-type")
	public static void ClienteAmorCheck() {
		Conexion con = new Conexion();

		try {
			java.sql.PreparedStatement p1 = null;

			String q1 = "SELECT COUNT(*) AS Numero_de_Visitas, rut, nombre, patApellido, matApellido, sexo, fechaNac, nacionalidad FROM (((cliente INNER JOIN registro_has_cliente ON rut = cliente_rut) INNER JOIN registro ON codigoReserva = registro_codigoReserva) INNER JOIN habitacion ON idhabitacion = habitacion_idhabitacion) group by cliente_rut ORDER BY Numero_de_Visitas DESC LIMIT 1;";

			p1 = con.connect().prepareStatement(q1);

			ResultSet rs = p1.executeQuery(q1);

			while (rs.next()) {
				amorRut = Integer.parseInt(rs.getObject("rut").toString());

			}
			ClAmor();
			System.out.print(amorRut);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void ClAmor() {

		int[] ruts = new int[Habitacion.getOcupantes()];

		Random random = new Random();
		random.nextBoolean();
		System.out.println(random);
		for (int i = 0; i < Habitacion.getOcupantes(); i++) {
			ruts[i] = Integer.parseInt((String) RegistroCliente.table.getModel().getValueAt(i, 0));
			if (ruts[i] == (amorRut)) {

				if (random.nextBoolean()) {
					RegistroCrud.clienAmor = 1;
					System.out.println("CLIENTE DEL AMOR HA GANADO: " + amorRut);
					JOptionPane.showMessageDialog(rootPane, "CLIENTE DEL AMOR HA GANADO(RUT): " + amorRut);
				} else {
					System.out.print("cuek cuek cuek SIGA PARTICIPANDO");
					JOptionPane.showMessageDialog(rootPane, "MAS SUERTE PARA LA PROXIMA");
					RegistroCrud.clienAmor = 0;

				}
			}

		}

	}
}
