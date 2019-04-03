package hotel.vista;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotel.controlador.CRUD;

public final class ShoppingMain {

	private ShoppingMain() {
	}

	public static void main(final String... the_args) {

		new RegistroProductos(CRUD.mostrar());
	}
}