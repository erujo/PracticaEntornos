package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import exception.isbnException;

public class Libro {

	private String isbn, titulo, autor, editorial;
	private LocalDate fechaDevolucion;
	private double precio;
	private boolean prestado;
	
	public Libro() {}

	public Libro(String isbn, String titulo, String autor, String editorial, String fechaDevolucion, String precio,
			String prestado) throws isbnException, NumberFormatException, DateTimeParseException {
		setIsbn(isbn);
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		setFechaDevolucion(fechaDevolucion);;
		setPrecio(precio);
		setPrestado(prestado);
	}

	public Libro(String titulo, String autor, String editorial, String precio) throws NumberFormatException, isbnException {
		creaIsbn();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.fechaDevolucion = null;
		setPrecio(precio);
		this.prestado = false;
	}

	private void creaIsbn() {
		/*long max = 9999999999999;
		long isbn = Math.floor(Math.random() * );*/
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
			int digitoControl = Integer.parseInt(Character.toString(isbn.charAt(12)));
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
			if (resto == 0) {
				resto = 10;
			}
			if (digitoControl != 10 - resto) {
				throw new isbnException();
			}
		} else {
			throw new isbnException();
		}
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

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) throws DateTimeParseException{
		if (fechaDevolucion.equals("null")) {
			this.fechaDevolucion = null;
		} else {
			try {
				this.fechaDevolucion = LocalDate.parse(fechaDevolucion);
			} catch (DateTimeParseException e) {
				throw new DateTimeParseException("Fecha no valida", fechaDevolucion, 0);
			}
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) throws NumberFormatException{
		try {
			this.precio = Double.parseDouble(precio);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Numero no valido");
		}
	}

	public boolean getPrestado() {
		return prestado;
	}

	public void setPrestado(String prestado) {
		if (prestado.equals("true")) {
			this.prestado = true;
		} else {
			this.prestado = false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return isbn + "," + titulo + "," + autor + "," + editorial + "," + fechaDevolucion + "," + precio + "," + prestado;
	}
	
}
