package Gestion_ITV;

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
	
}
