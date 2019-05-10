package hotel.modelo;

import java.sql.Timestamp;

public class ReportesFull {
	// Reportes
	public static int txtRutBuscar;
	public static String table;
	// Cliente
	public static int rut;
	public static String nombre, apellidoP, apellidoM, sexo, nacionalidad, fechadenacimiento;
	// Habitacion
	public static int idhabitacion, valor, ocupantes;
	public static String nombrehabitacion;
	public static double descuento;
	// Producto
	public static int idproducto, cantproducto, valorproducto;
	public static String nombreproducto;
	// Registro
	public static int idregistro, registro_codigoReserva, idHabitacion, cliente_rut;
	public static Timestamp horaIngreso, horaSalida;
	public static int estadia;

	public ReportesFull() {

	}

	public int getTxtRutBuscar() {
		return txtRutBuscar;
	}

	public void setTxtRutBuscar(int txtRutBuscar) {
		ReportesFull.txtRutBuscar = txtRutBuscar;
	}

	public static String getTextArea() {
		return table;
	}

	public static void setTextArea(String textArea) {
		ReportesFull.table = textArea;
	}

	public static String getTable() {
		return table;
	}

	public static void setTable(String table) {
		ReportesFull.table = table;
	}

	public static int getRut() {
		return rut;
	}

	public static void setRut(int rut) {
		ReportesFull.rut = rut;
	}

	public static String getNombre() {
		return nombre;
	}

	public static void setNombre(String nombre) {
		ReportesFull.nombre = nombre;
	}

	public static String getApellidoP() {
		return apellidoP;
	}

	public static void setApellidoP(String apellidoP) {
		ReportesFull.apellidoP = apellidoP;
	}

	public static String getApellidoM() {
		return apellidoM;
	}

	public static void setApellidoM(String apellidoM) {
		ReportesFull.apellidoM = apellidoM;
	}

	public static String getSexo() {
		return sexo;
	}

	public static void setSexo(String sexo) {
		ReportesFull.sexo = sexo;
	}

	public static String getNacionalidad() {
		return nacionalidad;
	}

	public static void setNacionalidad(String nacionalidad) {
		ReportesFull.nacionalidad = nacionalidad;
	}

	public static String getFechadenacimiento() {
		return fechadenacimiento;
	}

	public static void setFechadenacimiento(String fechadenacimiento) {
		ReportesFull.fechadenacimiento = fechadenacimiento;
	}

	public static int getIdhabitacion() {
		return idhabitacion;
	}

	public static void setIdhabitacion(int idhabitacion) {
		ReportesFull.idhabitacion = idhabitacion;
	}

	public static int getValor() {
		return valor;
	}

	public static void setValor(int valor) {
		ReportesFull.valor = valor;
	}

	public static int getOcupantes() {
		return ocupantes;
	}

	public static void setOcupantes(int ocupantes) {
		ReportesFull.ocupantes = ocupantes;
	}

	public static String getNombrehabitacion() {
		return nombrehabitacion;
	}

	public static void setNombrehabitacion(String nombrehabitacion) {
		ReportesFull.nombrehabitacion = nombrehabitacion;
	}

	public static double getDescuento() {
		return descuento;
	}

	public static void setDescuento(double descuento) {
		ReportesFull.descuento = descuento;
	}

	public static int getIdproducto() {
		return idproducto;
	}

	public static void setIdproducto(int idproducto) {
		ReportesFull.idproducto = idproducto;
	}

	public static int getCantproducto() {
		return cantproducto;
	}

	public static void setCantproducto(int cantproducto) {
		ReportesFull.cantproducto = cantproducto;
	}

	public static int getValorproducto() {
		return valorproducto;
	}

	public static void setValorproducto(int valorproducto) {
		ReportesFull.valorproducto = valorproducto;
	}

	public static String getNombreproducto() {
		return nombreproducto;
	}

	public static void setNombreproducto(String nombreproducto) {
		ReportesFull.nombreproducto = nombreproducto;
	}

	public static int getIdregistro() {
		return idregistro;
	}

	public static void setIdregistro(int idregistro) {
		ReportesFull.idregistro = idregistro;
	}

	public static int getRegistro_codigoReserva() {
		return registro_codigoReserva;
	}

	public static void setRegistro_codigoReserva(int registro_codigoReserva) {
		ReportesFull.registro_codigoReserva = registro_codigoReserva;
	}

	public static int getIdHabitacion() {
		return idHabitacion;
	}

	public static void setIdHabitacion(int idHabitacion) {
		ReportesFull.idHabitacion = idHabitacion;
	}

	public static int getCliente_rut() {
		return cliente_rut;
	}

	public static void setCliente_rut(int cliente_rut) {
		ReportesFull.cliente_rut = cliente_rut;
	}

	public static Timestamp getHoraIngreso() {
		return horaIngreso;
	}

	public static void setHoraIngreso(Timestamp horaIngreso) {
		ReportesFull.horaIngreso = horaIngreso;
	}

	public static Timestamp getHoraSalida() {
		return horaSalida;
	}

	public static void setHoraSalida(Timestamp horaSalida) {
		ReportesFull.horaSalida = horaSalida;
	}

	public static int getEstadia() {
		return estadia;
	}

	public static void setEstadia(int estadia) {
		ReportesFull.estadia = estadia;
	}

}
