package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.LibroDao;
import exception.FechaException;
import exception.IsbnException;
import modelo.Libro;

public class BibliotecaController {

	private List<Libro> libros;
	private Connection cn;
	
	public BibliotecaController(Connection cn) {
		super();
		this.cn = cn;
	}

	public List<Libro> getLibros() {
		LibroDao libroDao = new LibroDao(cn);
		return libros;
	}

}
