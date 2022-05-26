package Gestion_ITV;

import java.util.Objects;

import Exception.DniException;
import Exception.matriculaException;

public class vehiculo {

	private String nombre;
	private String apellidos;
	private String dni;
	private String matricula;
	private String identificador;
	
	public vehiculo(String nombre, String apellidos, String dni, String matricula) throws DniException, matriculaException {
		this.nombre = nombre;
		this.apellidos = apellidos;
		String ape[] = apellidos.split(" ");
		String letras = "";
		for (int x = 0; x < ape.length; x++) {
			letras+=ape[x].charAt(0);
		}
		this.dni = compruebaDni(dni);
		this.matricula = compruebaMatricula(matricula);
		this.identificador = nombre.charAt(0) + letras + dni.substring(5, 8);
	}

	private String compruebaMatricula(String matricula) throws matriculaException {
		if (matricula.length() == 7) {
			String numeros = matricula.substring(0, 4);
			String letras = matricula.substring(4, 7);
			try {
				int nums = Integer.parseInt(numeros);
			} catch (NumberFormatException e) {
				throw new matriculaException();
			}
			boolean a = true;
			for (int x = 0; x < letras.length(); x++) {
				if (!Character.isUpperCase(letras.charAt(x))) {
					a = false;
				}
			}
			if (a) {
				return matricula;
			} else {
				throw new matriculaException();
			}
		} else {
			throw new matriculaException();
		}
	}

	private String compruebaDni(String dni) throws DniException {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		if (dni.length() == 9) {
			char letra = dni.charAt(8);
			if (!Character.isLetter(letra)) {
				throw new DniException();
			}
			letra = Character.toUpperCase(letra);
			String numeros = dni.substring(0, 8);
			try {
				int nums = Integer.parseInt(numeros);
				int resto = nums % 23;
				if (letras.charAt(resto) == letra) {
					return dni;
				} else {
					throw new DniException();
				}
			} catch (NumberFormatException e) {
				throw new DniException();
			}
		} else {
			throw new DniException();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		vehiculo other = (vehiculo) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "vehiculo [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", matricula=" + matricula
				+ ", identificador=" + identificador + "]";
	}
	
}
