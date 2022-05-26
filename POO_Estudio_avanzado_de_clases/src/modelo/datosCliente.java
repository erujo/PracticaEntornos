package modelo;

public class datosCliente {

	cliente cliente;
	long entrada, salida;
	
	public datosCliente(cliente c) {
		this.cliente = c;
		entrada=relog.ahora();
	}
	
	public void atiende(){
		salida = relog.ahora();
	}
	
}
