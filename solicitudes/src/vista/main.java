package vista;

import excepciones.dniException;
import modelo.alumno;

public class main {

	public static void main(String[] args) {
		String nombre = "Hugo";
		String dni = "32935812l";
		String calle = "Benito";
		String poblacion = "Jerez";
		String cp = "12345";
		String fechaNacimiento = "2002-04-11";
		String curso = "1WEB";
		try {
			alumno alumno = new alumno(nombre, dni, calle, poblacion, cp, fechaNacimiento, curso);
			System.out.println(alumno);
		} catch (dniException e) {
			System.out.println(e.getMessage());
		}
	}

}
