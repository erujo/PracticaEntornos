package modelo;

import java.util.Objects;
import java.util.SortedMap;

public class persona implements Comparable<persona>{
	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;
	private int altura;
	private float peso;
	private int numPersona;
	private SortedMap<String, String> agendate1;
	
	public persona() {
		this.nombre = "desconocido";
		this.apellidos = "desconocido";
	}

	public persona(String nombre, String apeliidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apeliidos;
	}

	public persona(String nombre, String apeliidos, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apeliidos;
		this.dni = dni;
	}

	/*public persona(String nombre, String apeliidos, int edad) {
		this.nombre = nombre;
		this.apellidos = apeliidos;
		this.edad = edad;
	}*/
	
	public persona(String nombre, String apellidos, int numPersona) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numPersona = numPersona;
	}
	
	public SortedMap<String, String> getAgendate1() {
		return agendate1;
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
		persona other = (persona) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "persona"+ numPersona + " [nombre=" + nombre + ", apeliidos=" + apellidos + ", dni=" + dni + ", edad=" + edad
				+ ", altura=" + altura + ", peso=" + peso + "]";
	}

	@Override
	public int compareTo(persona o) {
		// TODO Auto-generated method stub
		return this.apellidos.compareTo(o.apellidos);
	}

	
}
