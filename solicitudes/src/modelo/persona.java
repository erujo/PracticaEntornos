package modelo;

import java.time.LocalDate;
import java.util.Objects;

import excepciones.dniException;

public class persona {

	private String nombre, dni, calle, poblacion, cp;
	private LocalDate fechaNacimiento;
	private Direccion direccion;
	
	public persona(String nombre, String dni, String calle, String poblacion, String cp, String fechaNacimiento) throws dniException {
		this.nombre = nombre;
		setDni(dni);
		this.calle = calle;
		this.poblacion = poblacion;
		this.cp = cp;
		setFechaNacimiento(fechaNacimiento);
		setDireccion(calle, poblacion, cp);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws dniException {
		compruebaDni(dni);
		this.dni = dni;
	}

	private void compruebaDni(String dni) throws dniException {
		if (dni.length() == 9) {
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			char letra = dni.charAt(8);
			letra = Character.toUpperCase(letra);
			String numero = dni.substring(0, 8);
			try {
				int num = Integer.parseInt(numero);
				int resto = num % 23;
				if (letra != letras.charAt(resto)) {
					throw new dniException();
				}
			} catch (NumberFormatException e) {
				throw new dniException();
			}
		} else {
			throw new dniException();
		}
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(String calle, String poblacion, String cp) {
		Direccion direccion = new Direccion(calle, poblacion, cp);
		this.direccion = direccion;
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

	
}
