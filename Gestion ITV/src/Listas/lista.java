package Listas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Exception.DniException;
import Exception.matriculaException;
import Gestion_ITV.colaEspera;
import Gestion_ITV.vehiculo;

public class lista {

	int registros;
	String datos[][];
	
	public lista() throws IOException {
		File fichero = new File("vehiculos.txt");
		cuentaRegistros(fichero);
		sacaDatos(fichero);
		String nombre[] = new String[registros];
		String apellidos[] = new String[registros];
		String dni[] = new String[registros];
		String matricula[] = new String[registros];
		for (int x = 0; x < datos.length; x++) {
			nombre[x] = datos[x][0];
			apellidos[x] = datos[x][1];
			dni[x] = datos[x][2];
			matricula[x] = datos[x][3];
		}
		colaEspera cola = new colaEspera();
		vehiculo vehiculo;
		for (int x = 0; x < matricula.length; x++) {
			try {
				vehiculo = new vehiculo(nombre[x], apellidos[x], dni[x], matricula[x]);
				cola.nuevoVehiculo(vehiculo);
				vehiculo = null;
			} catch (DniException | matriculaException e) {
				System.out.println(e.getMessage());
			}
		}
		for (int x = 0; x < matricula.length; x++) {
			vehiculo = cola.llamarVehiculo();
			System.out.println(vehiculo);
			vehiculo = null;
		}
		System.out.println();
	}

	private void sacaDatos(File fichero) throws IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		datos = new String[registros][];
		String linea = "";
		for (int x = 0; x < datos.length; x++) {
			linea = br.readLine();
			datos[x] = linea.split(",");
		}
		fr.close();
		br.close();
		fr = null;
		br = null;
	}

	private void cuentaRegistros(File fichero) throws IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		registros = 0;
		String linea = "";
		while ((linea = br.readLine()) != null) {
			registros++;
		}
		fr.close();
		br.close();
		fr = null;
		br = null;
	}

}
