package modelo;

import java.time.LocalDate;

import exception.dniException;

public class persona {

	String nombre, dni;
	LocalDate fechaNacimiento;
	Direccion direccion;
	
	public persona(String nombre, String dni, String fechaNacimiento, String calle, String poblacion, String cp) throws dniException {
		this.nombre = nombre;
		setDni(dni);
		setFechaNacimiento(fechaNacimiento);;
		setDireccion(calle, poblacion, cp);;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws dniException {
		compruebaDni(dni);
		this.dni = dni;
	}

	private void compruebaDni(String dni) throws dniException {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		dni = dni.toUpperCase();
		if (dni.length() == 9) {
			char letra = dni.charAt(8);
			try {
				int num = Integer.parseInt(dni.substring(0, 8));
				int resto = num % 23;
				if (letras.charAt(resto) != letra) {
					throw new dniException();
				}
			} catch (NumberFormatException e) {
				throw new dniException();
			}
		} else {
			throw new dniException();
		}
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(String calle, String poblacion, String cp) {
		Direccion direccion = new Direccion(calle, poblacion, cp);
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "persona [nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", direccion="
				+ direccion + "]";
	}
	
}
