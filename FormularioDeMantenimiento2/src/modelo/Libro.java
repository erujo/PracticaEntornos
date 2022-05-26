package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import exception.FechaException;
import exception.IsbnException;

public class Libro implements Comparable<Libro>{

	private String isbn, titulo, autor, editorial;
	private LocalDate fecha;
	private boolean prestado;
	
	public Libro() {}

	public Libro(String isbn, String titulo, String autor, String editorial, String fecha, String prestado) throws FechaException, IsbnException {
		setIsbn(isbn);
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		setFecha(fecha);
		setPrestado(prestado);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws IsbnException {
		compruebaIsbn(isbn);
		this.isbn = isbn;
	}

	private void compruebaIsbn(String isbn) throws IsbnException {
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
				throw new IsbnException();
			}
		} else {
			throw new IsbnException();
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) throws FechaException {
		try {
			this.fecha = LocalDate.parse(fecha);
		} catch (DateTimeParseException e) {
			throw new FechaException();
		}
	}

	public boolean isPrestado() {
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
	public int compareTo(Libro o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return isbn + "," + titulo + "," + autor + "," + editorial + "," + fecha + "," + prestado;
	}
	
}
