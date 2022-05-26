package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exception.dniException;
import modelo.alumno;

public class solicitudesController {

	private List<alumno> movimientos;
	
	public solicitudesController() throws IOException, dniException {
		movimientos = leerFichero();
	}

	public List<alumno> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<alumno> movimientos) {
		this.movimientos = movimientos;
	}
	
	public boolean meter(alumno alumno) {
		movimientos.add(alumno);
		return true;
	}
	
	public String recoger(String dni) {
		boolean guay = false;
		String al = "";
		for (alumno alumno : movimientos) {
			if (alumno.getDni().equals(dni)) {
				guay = true;
				al = alumno.toString();
			}
		}
		if (guay) {
			return al;
		} else {
			return "Alumno no encontrado";
		}
	}

	private List<alumno> leerFichero() throws IOException, dniException {
		List<alumno> movimientos = new ArrayList<alumno>();
		FileReader fr = new FileReader("alumnos.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		while ((linea = br.readLine()) != null) {
			String datos[] = linea.split(",");
			alumno alumno = new alumno(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
			movimientos.add(alumno);
		}
		return movimientos;
	}
}
