package modelo;

import java.util.LinkedList;
import java.util.Queue;

public class colaEspera {

	private Queue<datosCliente> colaEspera;
	private Queue<datosCliente> colaAtendidos;
	
	public colaEspera() {
		colaEspera = new LinkedList<datosCliente>();
		colaAtendidos = new LinkedList<datosCliente>();
	}
	
	public void nuevoCliente(cliente cliente) {
		datosCliente datos = new datosCliente(cliente);
		colaEspera.add(datos);
	}
	
	public cliente atenderCliente() {
		datosCliente datos = colaEspera.remove();
		datos.atiende();
		colaAtendidos.add(datos);
		return datos.cliente;
	}
	
	public double tiempoEsperaAtendidos() {
		long tiempo = 0;
		int num = 0;
		for (datosCliente datos : colaAtendidos) {
			tiempo+=datos.salida-datos.entrada;
			num = 0;
		}
		if (num == 0) {
			return 0;
		} else {
			return (((double) (tiempo)/num))/1000;
		}
	}
}
