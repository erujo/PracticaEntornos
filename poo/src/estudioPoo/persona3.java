package estudioPoo;

import java.util.Objects;

public class persona3 {

	private String nombre;
	private String apeliidos;
	private String dni;
	private int edad;
	private int altura;
	private float peso;
	
	public persona3() {
		this.nombre = "desconocido";
		this.apeliidos = "desconocido";
	}

	public persona3(String nombre, String apeliidos) {
		super();
		this.nombre = nombre;
		this.apeliidos = apeliidos;
	}

	public persona3(String nombre, String apeliidos, String dni) {
		super();
		this.nombre = nombre;
		this.apeliidos = apeliidos;
		this.dni = dni;
	}

	public persona3(String nombre, String apeliidos, int edad) {
		this.nombre = nombre;
		this.apeliidos = apeliidos;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "persona3 [nombre=" + nombre + ", apeliidos=" + apeliidos + ", dni=" + dni + ", edad=" + edad
				+ ", altura=" + altura + ", peso=" + peso + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		persona3 other = (persona3) obj;
		return Objects.equals(dni, other.dni);
	}
	

}
