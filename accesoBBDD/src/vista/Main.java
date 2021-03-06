package vista;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import controlador.libroController;
import dao.DbConnection;
import modelo.Libro;

public class Main {

	public static void main(String[] args) {
		DbConnection dbc = new DbConnection();
		Connection conn = dbc.getConn();
		libroController libroController = new libroController(conn);
		try {
			List<Libro> libros = libroController.getLibros();
			for (Libro libro : libros) {
				System.out.println(libro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbc.disconnect();
		
		System.out.println("==========================");
		dbc = new DbConnection();
		conn = dbc.getConn();
		String titulo = "Aquitania", autor = "illojuan", editorial = "planeta", isbn = "5421854";
		libroController.agregarLibro(titulo, autor, editorial, isbn);
	}

}
