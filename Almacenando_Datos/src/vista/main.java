package vista;

import java.io.FileNotFoundException;
import java.io.IOException;

import estudioFicheros.cuadradoMagico;
import estudioFicheros.ficheros;
import estudioFicheros.tarjetaClaves;
import estudioFicheros.trajetaClaves2;
import excepciones.datoException;

public class main {

	public static void main(String[] args) {
		/*try {
			//ficheros fich = new ficheros();
			cuadradoMagico cM = new cuadradoMagico();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			tarjetaClaves tc = new tarjetaClaves();
		} catch (IOException e) {
			e.printStackTrace();
		}*/ 
		try {
			trajetaClaves2 tc2 = new trajetaClaves2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
