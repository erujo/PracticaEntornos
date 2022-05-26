package vista;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.List;

import controlador.bibliotecaController;
import exception.isbnException;
import modelo.Libro;

public class main {

	public static void main(String[] args) {
		String isbn = "978-84-17157-92-0";String titulo = "La Bestia";String autor = "Carmen Mola"; String editorial = "Planeta";
		String fechaDevolucin = "2022-03-20";String precio = "20.5"; String prestado = "false";
		try {
			Libro libro = new Libro(isbn, titulo, autor, editorial, fechaDevolucin, precio, prestado);
			System.out.println(libro);
			System.out.println("================================");
			bibliotecaController biblioteca = new bibliotecaController();
			mostrar(biblioteca.getBiblioteca());
			System.out.println("================agregar libro================");
			if (biblioteca.agregarLibro(isbn, titulo, autor, editorial, precio)) {
				System.out.println("Libro añadido");
			} else {
				System.out.println("Libro repetido");
			}
			mostrar(biblioteca.getBiblioteca());
			System.out.println("================prestar libro================");
			String fecha = "2022-03-25";
			Libro l = biblioteca.prestarLibro(isbn, fecha);
			if (l != null) {
				System.out.println(l.getTitulo() + " Fecha devolucion:" + l.getFechaDevolucion());
			} else {
				System.out.println("No se encontro el libro");
			}
			mostrar(biblioteca.getBiblioteca());
			
		} catch (NumberFormatException | DateTimeParseException | isbnException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void mostrar(List<Libro> biblioteca) {
		for (Libro libro : biblioteca) {
			System.out.println(libro);
		}
	}

}
