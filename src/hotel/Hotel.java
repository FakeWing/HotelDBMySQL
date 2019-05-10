package hotel;

import hotel.controlador.Conexion;
import hotel.vista.Menu;

public class Hotel {

	public static void main(String[]args) {
	      Conexion conn = new Conexion();
	       conn.connect();
	       Menu.main(args);
	    
		
	}
}
