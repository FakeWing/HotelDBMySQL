package hotel.modelo;

public class Cliente {

	private int rut;
	private String nombre, apellidoP, apellidoM, sexo, nacionalidad, fechadenacimiento;
	
	public Cliente(int rut, String nombre, String apellidoP, String apellidoM, String sexo, String nacionalidad,
			String fechadenacimiento) {
		
		this.rut = rut;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.fechadenacimiento = fechadenacimiento;
	}

	private static Cliente cliente;
	
	public static Cliente getInstance() {
		if (cliente ==null) {
			cliente = new Cliente();
		}
		return cliente;
	}

	public Cliente() {
		
	}
	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getFechadenacimiento() {
		return fechadenacimiento;
	}

	public void setFechadenacimiento(String fechadenacimiento) {
		this.fechadenacimiento = fechadenacimiento;
	}
	
	
	
	 
}
