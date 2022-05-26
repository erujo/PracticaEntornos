package vista;

import listas.Lista_1;
import listas.Lista_2;
import listas.listaColaEspera;
import modelo.cliente;
import modelo.colaEspera;

public class main {

	public static void main(String[] args) {
		//Lista_1 lista = new Lista_1();
		//Lista_2 lista2 = new Lista_2();
		try {
			listaColaEspera lista = new listaColaEspera();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
