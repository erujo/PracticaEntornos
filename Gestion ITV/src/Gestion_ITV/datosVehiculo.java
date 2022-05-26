package Gestion_ITV;

public class datosVehiculo {

	vehiculo vehiculo;
	long entrada, salida;
	
	public datosVehiculo(vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		entrada = relog.ahora();
	}
	
	public void atiende() {
		salida = relog.ahora();
	}
	
}
