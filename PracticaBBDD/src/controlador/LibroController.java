package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.LibroDao;
import exception.isbnException;
import modelo.Libro;

public class LibroController {

	private Connection conn;

	public LibroController(Connection conn) {
		this.conn = conn;
	};
	
	public List<Libro> leerDatos() throws SQLException, isbnException {
		List<Libro> libros = new ArrayList<Libro>();
		LibroDao libroDao = new LibroDao(conn);
		libros = libroDao.leer("select * from libros");
		return libros;
	}
	
	public boolean agregarLibro(Libro libro) throws SQLException {
		LibroDao libroDao = new LibroDao(conn);
		libroDao.agregar(libro, "insert into libros values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
		return true;
	}
	
	public boolean editarLibro(Libro libro) throws SQLException {
		LibroDao libroDao = new LibroDao(conn);
		libroDao.editar(libro, "update libros set titulo=?, autor=?, editorial=?, prestado=? where isbn=?");
		return true;
	}
	
	public boolean borrarLibro(String isbn) throws SQLException {
		LibroDao libroDao = new LibroDao(conn);
		libroDao.borrar(isbn, "delete from libros where isbn=?");
		return true;
	}
		
}
