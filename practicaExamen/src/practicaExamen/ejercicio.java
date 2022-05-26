package practicaExamen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ejercicio {

		String usuarios[];
		int claves[][];
		int registros;
		
	public ejercicio() throws IOException {
		File fichero = new File("datos.txt");
		if (!fichero.exists()) {
			fichero.createNewFile();
		}
		cuentaregistros(fichero);
		//System.out.println(registros);
		leerDatos(fichero);
		//System.out.println(Arrays.toString(usuarios));
		//System.out.println(Arrays.deepToString(claves));
		
	}
	
	private void leerDatos(File fichero) throws IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		usuarios = new String[registros/2];
		claves = new int[registros/2][];
		String linea = "";
		for (int x = 0; x < usuarios.length; x++) {
			linea = br.readLine();
			usuarios[x] = linea;
			linea = br.readLine();
			String clave[] = linea.split(", ");
			int cla[] = new int[clave.length];
			for (int y = 0; y < cla.length; y++) {
				cla[y] = Integer.parseInt(clave[y]);
			}
			claves[x] = cla;
		}
		fr.close();
		br.close();
		fr = null;
		br = null;
	}

	private void cuentaregistros(File fichero) throws IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
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
