package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import exception.isbnException;
import modelo.Libro;

public class bibliotecaController {

	private List<Libro> biblioteca;
	
	public bibliotecaController() throws IOException, NumberFormatException, DateTimeParseException, isbnException {
		biblioteca = new ArrayList<Libro>();
		FileReader fr = new FileReader("biblioteca.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		while ((linea = br.readLine()) != null) {
			String datos[] = linea.split(",");
			Libro libro = new Libro(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
			biblioteca.add(libro);
		}
		fr.close();
		br.close();
		fr = null;
		br = null;
	}
	
	public boolean agregarLibro(String isbn, String titulo, String autor, String editorial, String precio) throws NumberFormatException, isbnException {
		//Libro libro = new Libro(isbn, titulo, autor, editorial, precio);
		boolean repe = false;
		for (Libro libro2 : biblioteca) {
			if (libro2.equals(libro)) {
				repe = true;
			}
		}
		if (repe) {
			return false;
		} else {
			biblioteca.add(libro);
			return true;
		}
	}
	
	public Libro prestarLibro(String isbn, String fecha) {
		Libro libro2 = null;
		for (Libro libro : biblioteca) {
			if (libro.getIsbn().equals(isbn)) {
				if (libro.getPrestado() == false) {
					libro.setFechaDevolucion(fecha);
					libro.setPrestado("true");
					libro2 = libro;
				}
			}
		}
		return libro2;
	}
	
	public boolean devolverLibro(String isbn) {
		boolean repe = false;
		for (Libro libro : biblioteca) {
			if (libro.getIsbn().equals(isbn)) {
				if (libro.getPrestado() == true) {
					libro.setFechaDevolucion("null");
					libro.setPrestado("false");
					repe = true;
				}
			}
		}
		return repe;
	}
	
	public boolean eliminarLibro(String isbn) {
		boolean eliminado = false;
		Libro libro2 = null;
		for (Libro libro : biblioteca) {
			if (libro.getIsbn().equals(isbn)) {
				libro2 = libro;
				eliminado = true;
			}
		}
		if (eliminado) {
			biblioteca.remove(libro2);
		}
		return eliminado;
	}
	
	public boolean salvarDatos() throws IOException {
		FileWriter fw = new FileWriter("biblioteca.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (Libro libro : biblioteca) {
			bw.write(libro.toString());
			bw.newLine();
		}
		fw.flush();
		bw.close();
		fw.close();
		bw = null;
		fw = null;
		return true;
	}
	
	public List<Libro> getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(List<Libro> biblioteca) {
		this.biblioteca = biblioteca;
	}
	
}
