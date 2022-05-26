package leer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class leer {

	public static String dato() throws IOException {
		String dato = "";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		dato = br.readLine();
		return dato;
	}
	
	public static int datoint() throws IOException {
		int num = 0;
		String datoCadena = dato();
		num = Integer.parseInt(datoCadena);
		return num;
	}
}
