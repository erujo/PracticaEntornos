package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.LibroDao;
import modelo.Libro;

public class LibroController {

	private Connection conn;
	private List<Libro> libros;
	private int c = 0;

	public LibroController(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public List<Libro> getConsulta() throws SQLException {
		LibroDao biblioteca = new LibroDao(conn);
		c = biblioteca.getC();
		return biblioteca.getConsulta("select * from libros");
	}

	public int getC() {
		return c;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public void setC(int c) {
		this.c = c;
	}
	
}
