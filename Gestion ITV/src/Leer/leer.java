package Leer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class leer {

	public static String dato() throws IOException {
		String dato = "";
		InputStreamReader isp = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isp);
		dato = br.readLine();
		return dato;
	}
	
	public static int datoInt() throws IOException {
		int datoInt = Integer.parseInt(dato());
		return datoInt;
	}
}
