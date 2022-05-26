package vista;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		try {
			Formulario formulario = new Formulario();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
