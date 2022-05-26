package estudioPoo;

public class empleado extends trabajador {

	private double sueldo;
	private double impuestos;
	
	private final int PAGAS = 14;
	
	/*public empleado() {
		// TODO Auto-generated constructor stub
	}*/

	
	public empleado(String nombre, String puesto, String direccion, String telefono, String nSS, double sueldo, double impuestos) {
		super(nombre, puesto, direccion, telefono, nSS);
		this.sueldo = sueldo;
		this.impuestos = impuestos;
	}


	public double getSueldo() {
		return sueldo;
	}


	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}


	public double getImpuestos() {
		return impuestos;
	}


	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}
	
	public double calcularPaga() {
		return (sueldo - impuestos)/PAGAS;
	}
}
