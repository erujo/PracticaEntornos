package modelo;

import exception.dniException;
import exception.matriculaException;

public class vehiculo {

	private String nombre;
	private String apellidos;
	private String dni;
	private String matricula;
	private String identificador;
	
	public vehiculo(String nombre, String apellidos, String dni, String matricula) throws dniException, matriculaException {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		setDni(dni);
		setMatricula(matricula);
		setIdentificador(nombre, apellidos, dni);
	}

	private String creaIdentificador(String nombre, String apellidos, String dni) {
		String apellido[] = apellidos.split(" ");
		String letras = "";
		for (int x = 0; x < apellido.length; x++) {
			letras+=apellido[x].charAt(0);
		}
		return nombre.charAt(0) + letras + dni.substring(5, 8);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws dniException {
		compruebaDni(dni);
		this.dni = dni;
	}

	private void compruebaDni(String dni) throws dniException {
		if (dni.length() == 9) {
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			char letra = dni.charAt(8);
			letra = Character.toUpperCase(letra);
			String numero = dni.substring(0, 8);
			try {
				int num = Integer.parseInt(numero);
				int resto = num % 23;
				if (letra != letras.charAt(resto)) {
					throw new dniException();
				}
			} catch (NumberFormatException e) {
				throw new dniException();
			}
		} else {
			throw new dniException();
		}
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) throws matriculaException {
		compruebaMatricula(matricula);
		this.matricula = matricula;
	}

	private void compruebaMatricula(String matricula) throws matriculaException {
		if (matricula.length() == 7) {
			String numeros = matricula.substring(0, 4);
			String letras = matricula.substring(4, 7);
			try {
				int num = Integer.parseInt(numeros);
			} catch (NumberFormatException e) {
				throw new matriculaException();
			}
			for (int x = 0; x < letras.length(); x++) {
				if (!Character.isUpperCase(letras.charAt(x))) {
					throw new matriculaException();
				}
			}
		} else {
			throw new matriculaException();
		}
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String nombre, String apellidos, String dni) {
		this.identificador = creaIdentificador(nombre, apellidos, dni);
	}

	@Override
	public String toString() {
		return "vehiculo [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", matricula=" + matricula
				+ ", identificador=" + identificador + "]";
	}
	
}
