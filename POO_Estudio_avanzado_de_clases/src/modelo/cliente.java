package modelo;

public class cliente {

	private String numero, nombre;
	//private String nombre;
	
	public cliente(String numero, String nombre) {
		this.numero = numero;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "cliente [numero=" + numero + ", nombre=" + nombre + "]";
	}
	
}
