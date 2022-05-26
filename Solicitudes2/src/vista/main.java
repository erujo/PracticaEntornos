package vista;

import java.io.IOException;

import controlador.solicitudesController;
import exception.dniException;
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
			alumno alumno = new alumno(nombre, dni, fechaNacimiento, calle, poblacion, cp, curso);
			//System.out.println(alumno);
			solicitudesController solicitudes = new solicitudesController();
			for (alumno a : solicitudes.getMovimientos()) {
				System.out.println(a);
			}
			solicitudes.meter(alumno);
			System.out.println(solicitudes.recoger(dni));
		} catch (dniException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
