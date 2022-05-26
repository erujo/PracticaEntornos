package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import exception.isbnException;

public class Libro {

	private int idLibro;
	private String titulo;
	private String autor;
	private String editorial;
	private boolean prestado;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;
	private String isbn;
	private LocalDateTime fechaAlta;
	
	public Libro(int idLibro, String titulo, String autor, String editorial, boolean prestado, LocalDate fechaPrestamo,
			LocalDate fechaDevolucion, String isbn, LocalDateTime fechaAlta) throws isbnException {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.prestado = prestado;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.isbn = isbn;
		this.fechaAlta = fechaAlta;
	}
	
	public Libro(int idLibro, String titulo, String autor, String editorial, boolean prestado, String fechaPrestamo,
			String fechaDevolucion, String isbn, String fechaAlta) throws isbnException {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.prestado = prestado;
		setFechaPrestamo(fechaPrestamo);
		setFechaDevolucion(fechaDevolucion);
		setIsbn(isbn);
		setFechaAlta(fechaAlta);
	}
	
	public Libro(int idLibro, String titulo, String autor, String editorial, boolean prestado,
			String isbn) throws isbnException {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.prestado = prestado;
		fechaPrestamo = null;
		fechaDevolucion = null;
		setIsbn(isbn);
		fechaAlta = null;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = LocalDate.parse(fechaPrestamo);
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = LocalDate.parse(fechaDevolucion);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws isbnException {
		compruebaIsbn(isbn);
		this.isbn = isbn;
	}

	private void compruebaIsbn(String isbn) throws isbnException {
		isbn = isbn.replace("-", "");
		if (isbn.length() == 13) {
			int numControl = Integer.parseInt(Character.toString(isbn.charAt(12)));
			String numeros = isbn.substring(0, 12);
			int suma = 0;
			for (int x = 0; x < numeros.length(); x++) {
				if ((x+1) % 2 == 0) {
					int num = Integer.parseInt(Character.toString(numeros.charAt(x)));
					num*=3;
					suma+=num;
				} else {
					int num = Integer.parseInt(Character.toString(numeros.charAt(x)));
					suma+=num;
				}
			}
			int resto = suma % 10;
			if (resto != 0) {
				resto = 10 - resto;
			}
			if (resto != numControl) {
				throw new isbnException();
			}
		} else {
			throw new isbnException();
		}
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = LocalDateTime.parse(fechaAlta);
	}

	@Override
	public String toString() {
		return idLibro + ",," + titulo + ",," + autor + ",," + editorial
				+ ",," + fechaPrestamo + ",," + fechaDevolucion
				+ ",," + isbn + ",," + fechaAlta + ",," + prestado;
	}
	
}
