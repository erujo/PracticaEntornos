package vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import exception.dniException;
import exception.matriculaException;
import modelo.colaEspera;
import modelo.datosVehiculo;
import modelo.vehiculo;

public class main {

	public static void main(String[] args) throws InterruptedException {
		/*Scanner leer = new Scanner(System.in);
		boolean para = false;
		do {
			System.out.print("Dime tu nombre: ");
			String nombre = leer.nextLine();
			System.out.print("Dime tus apellidos: ");
			String apellidos = leer.nextLine();
			System.out.print("Dime tu DNI: ");
			String dni = leer.nextLine();
			System.out.print("Dime tu matricula: ");
			String matricula = leer.nextLine();
			try {
				vehiculo vehiculo = new vehiculo(nombre, apellidos, dni, matricula);
				System.out.println(vehiculo);
				para = true;
			} catch (dniException e) {
				System.out.println(e.getMessage());
			} catch (matriculaException e) {
				System.out.println(e.getMessage());
			}
		} while (!para);*/
		
		File fichero = new File("vehiculos.txt");
		int registros = 0;
		try {
			registros = cuentaRegistros(fichero);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String datos[][] = null;
		try {
			datos = sacaDatos(registros, fichero);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		for (int x = 0; x < registros; x++) {
			try {
				vehiculo = new vehiculo(nombre[x], apellidos[x], dni[x], matricula[x]);
				System.out.println(vehiculo);
				cola.nuevoVehiculo(vehiculo);
				Thread.sleep(1000);
				vehiculo = null;
			} catch (dniException e) {
				System.out.println(e.getMessage());
			} catch (matriculaException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println();
		for (int x = 0; x < matricula.length; x++) {
			vehiculo = cola.llamarVehiculo();
			System.out.println(vehiculo);
			System.out.println(cola.tiempoEspera());
			/*try {
				meteDatos(vehiculo, cola);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			Thread.sleep(1000);
			vehiculo = null;
		}
		//System.out.println(cola.tiempoEspera());
	}

	private static void meteDatos(vehiculo vehiculo, colaEspera cola) throws IOException {
		File fichero = new File("atendidos.txt");
		if (!fichero.exists()) {
			fichero.createNewFile();
		}
		FileWriter fw = new FileWriter(fichero.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		
	}

	private static String[][] sacaDatos(int registros, File fichero) throws IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		String datos[][] = new String[registros][];
		String linea = "";
		for (int x = 0; x < datos.length; x++) {
			linea = br.readLine();
			datos[x] = linea.split(",");
		}
		return datos;
	}

	private static int cuentaRegistros(File fichero) throws IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		int registros = 0;
		while ((linea = br.readLine()) != null) {
			registros++;
		}
		fr.close();
		br.close();
		fr = null;
		br = null;
		return registros;
	}

}
