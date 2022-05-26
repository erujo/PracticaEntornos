package listas;

import modelo.cliente;
import modelo.colaEspera;

public class listaColaEspera {

	public listaColaEspera() throws InterruptedException {
		colaEspera cola = new colaEspera();
		cliente cliente = new cliente("Pepe", "1");
		cola.nuevoCliente(cliente);
		cliente = null;
		Thread.sleep(1000);
		cliente = new cliente("Ana", "2");
		cola.nuevoCliente(cliente);
		cliente = null;
		Thread.sleep(1000);
		cliente = new cliente("Luis", "3");
		cola.nuevoCliente(cliente);
		cliente = null;
		Thread.sleep(1000);
		cliente = new cliente("Maria", "4");
		cola.nuevoCliente(cliente);
		cliente = null;
		Thread.sleep(1000);
		
		cliente = cola.atenderCliente();
		System.out.println(cliente);
	}

}
