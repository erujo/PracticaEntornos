package modelo;

public class Persona {
	private String nombre;
	private String poblacion;
	private String dni;
	
	public Persona(String nombre, String poblacion, String dni) {
		super();
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.dni = dni;
	}
	
	public static boolean compruebaDni( String dni) {
		boolean dniCorrecto=true;
		String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		dni=dni.toUpperCase();
		if(dni.length()==9) {
			String numeroDNI=dni.substring(0, 8);
		char letra=dni.charAt(8);
		System.out.println(numeroDNI+"-"+letra);
		try {
			int numDni=Integer.parseInt(numeroDNI);
			int resto = numDni % 23;
			char letraDni=letrasDNI.charAt(resto);
			System.out.println("----"+letraDni+"------");
			if(letra==letraDni)
				System.out.println("DNI correcto");
			else {
				System.err.println("DNI Incorrecto");
				}
		} catch (NumberFormatException e) {
			dniCorrecto=false;
		}
		
	}
		else {
			System.err.println("Dni Incorrecto");
			dniCorrecto=false;
		}
		return dniCorrecto;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", poblacion=" + poblacion + ", dni=" + dni + "]";
	}
	
}
