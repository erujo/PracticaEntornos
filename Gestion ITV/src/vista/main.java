package vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Exception.DniException;
import Exception.matriculaException;
import Gestion_ITV.vehiculo;
import Leer.leer;
import Listas.lista;

public class main {
	
	public static void main(String[] args) {
		/*try {
			vehiculo vehiculo = new vehiculo("Hugo", "Parada Cañas", "32935812l", "1234LKJ");
			System.out.println(vehiculo);
		} catch (DniException e) {
			System.out.println(e.getMessage());
		} catch (matriculaException e) {
			System.out.println(e.getMessage());
		}*/
		try {
			lista lista = new lista();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
