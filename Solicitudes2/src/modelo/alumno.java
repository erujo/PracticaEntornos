package modelo;

import exception.dniException;

public class alumno extends persona{

	String curso;

	public alumno(String nombre, String dni, String fechaNacimiento, String calle, String poblacion, String cp, String curso) throws dniException {
		super(nombre, dni, fechaNacimiento, calle, poblacion, cp);
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return getNombre() + ", " + getDni() + ", " + getFechaNacimiento() + ", " + getDireccion() + ", " + curso;
	}

}
