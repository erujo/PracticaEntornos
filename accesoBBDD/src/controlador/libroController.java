package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.LibroDao;
import modelo.Libro;

public class libroController {
	
	private List<Libro> libros;
	private Connection cn;
	
	public libroController(Connection cn) {
		super();
		this.cn = cn;
	}

	public List<Libro> getLibros() throws SQLException {
		LibroDao biblioteca = new LibroDao(cn);
		return biblioteca.getConsulta("select * from libros");
	}
	
	public boolean agregarLibro(String titulo, String autor, String editorial, String isbn) {
		boolean agregado = false;
		Libro libro = new Libro(0, isbn, titulo, autor, editorial, agregado, null, null, null);
	}
	
}
