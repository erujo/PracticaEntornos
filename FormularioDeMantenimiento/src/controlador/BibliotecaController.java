package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exception.FechaException;
import exception.IsbnException;
import modelo.Libro;

public class BibliotecaController {

	private List<Libro> biblioteca;
	private String dato[][];
	private int c;
	
	public BibliotecaController() throws IOException, FechaException, IsbnException {
		biblioteca = new ArrayList<Libro>();
		FileReader fr = new FileReader("libros.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		c = 0;
		while ((linea = br.readLine()) != null) {
			String datos[] = linea.split(",");
			Libro libro = new Libro(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
			biblioteca.add(libro);
			c++;
		}
		br.close();
		fr.close();
		br = null;
		fr = null;
		/*for (Libro libro : biblioteca) {
			System.out.println(libro);
		}*/
		
	}
	
	public void agregarLibro(String[] datos, String prestado) throws FechaException, IOException, IsbnException {
		Libro libro = new Libro(datos[0], datos[1], datos[2], datos[3], datos[4], prestado);
		boolean repe = false;
		for (Libro libro2 : biblioteca) {
			if (libro2.equals(libro)) {
				repe = true;
			}
		}
		if (!repe) {
			biblioteca.add(libro);
			c++;
			FileWriter fw = new FileWriter("libros.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Libro libro2 : biblioteca) {
				bw.write(libro2.toString());
				bw.newLine();
			}
			fw.flush();
			bw.close();
			fw.close();
			bw = null;
			fw = null;
		} else {
			throw new IsbnException();
		}
	}
	
	public void editarLibro(String[] datos, String prestado) throws FechaException, IsbnException, IOException {
		for (Libro libro : biblioteca) {
			if (libro.getIsbn().equals(datos[0])) {
				//libro = new Libro(datos[0], datos[1], datos[2], datos[3], datos[4], prestado);
				libro.setIsbn(datos[0]);
				libro.setTitulo(datos[1]);
				libro.setAutor(datos[2]);
				libro.setEditorial(datos[3]);
				libro.setFecha(datos[4]);
				libro.setPrestado(prestado);
				//System.out.println();
			}
		}
		FileWriter fw = new FileWriter("libros.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (Libro libro2 : biblioteca) {
			bw.write(libro2.toString());
			bw.newLine();
		}
		fw.flush();
		bw.close();
		fw.close();
		bw = null;
		fw = null;
	}
	
	public void borrar(Libro libro) throws IOException {
		biblioteca.remove(libro);
		c--;
		FileWriter fw = new FileWriter("libros.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for (Libro libro2 : biblioteca) {
			bw.write(libro2.toString());
			bw.newLine();
		}
		fw.flush();
		bw.close();
		fw.close();
		bw = null;
		fw = null;
	}

	public List<Libro> getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(List<Libro> biblioteca) {
		this.biblioteca = biblioteca;
	}

	public String[][] getDato() {
		return dato;
	}

	public void setDato(String[][] dato) {
		this.dato = dato;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

}
