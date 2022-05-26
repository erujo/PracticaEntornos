package modelo;

import java.util.LinkedList;
import java.util.Queue;

public class colaEspera {

	private Queue<datosVehiculo> colaEspera;
	private Queue<datosVehiculo> colaAtendidos;
	
	public colaEspera() {
		colaEspera = new LinkedList<datosVehiculo>();
		colaAtendidos = new LinkedList<datosVehiculo>();
	}
	
	public void nuevoVehiculo(vehiculo v) {
		datosVehiculo datos = new datosVehiculo(v);
		colaEspera.add(datos);
	}
	
	public vehiculo llamarVehiculo() {
		datosVehiculo datos = colaEspera.remove();
		datos.atiende();
		colaAtendidos.add(datos);
		return datos.vehiculo;
	}
	
	public double tiempoEspera() {
		int num = 0;
		long tiempo = 0;;
		for (datosVehiculo datos : colaAtendidos) {
			datos.tiempoEspera = datos.tiempoEspera + datos.salida - datos.entrada;
			tiempo = datos.tiempoEspera;
			num++;
		}
		if (num == 0) {
			return 0;
		} else {
			return ((double) tiempo)/1000;
		}
	}
}
