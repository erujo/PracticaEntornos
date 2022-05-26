package vista;

import java.io.IOException;

import controlador.BibliotecaController;
import dao.DbConnection;
import exception.FechaException;
import exception.IsbnException;

public class Main {

	public static void main(String[] args) {
		/*try {
			Mantenimiento mantenimiento = new Mantenimiento();
		} catch (IOException | FechaException | IsbnException e) {
			System.out.println(e.getMessage());
		}*/
		//DbConnection dbc = new DbConnection();
		BibliotecaController bibliotecaController = new BibliotecaController(null);
		/*try {
			BibliotecaController bibliotecaController = new BibliotecaController();
		} catch (IOException | FechaException e) {
			System.out.println(e.getMessage());
		}*/
	}

}
