package modelo;

public class datosVehiculo {

	vehiculo vehiculo;
	long entrada, salida;
	long tiempoEspera;
	
	public datosVehiculo(vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		entrada = relog.ahora();
	}
	
	public void atiende() {
		salida = relog.ahora();
		/*tiempoEspera = tiempoEspera + salida - entrada;
		return (double) tiempoEspera/1000.0;
		for (datosVehiculo datos : colaAtendidos) {
			tiempo = tiempo + datos.salida - datos.entrada;
			num++;
		}
		if (num == 0) {
			return 0;
		} else {
			return (((double) tiempo)/num)/1000;
		}*/
	}
}
