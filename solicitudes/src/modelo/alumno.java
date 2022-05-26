package modelo;

import excepciones.dniException;

public class alumno extends persona{

	private String curso;
	
	public alumno(String nombre, String dni, String calle, String poblacion, String cp, String fechaNacimiento, String curso) throws dniException {
		super(nombre, dni, calle, poblacion, cp, fechaNacimiento);
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
		return getNombre() + ", " + getDni() + ", " + getDireccion() + ", " + getFechaNacimiento() + ", " + curso;
	}

}
