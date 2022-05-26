package estudioPoo;

public class bicicleta {
	
	private int numMarchas;
	private int diametros;
	private int velocidad;
	private int id;
	
	private static int numeroDeBicicleta = 0;

	public static int getNumeroDeBicicleta() {
		return numeroDeBicicleta;
	}

	public bicicleta(int numMarchas, int diametros, int velocidad) {
		super();
		this.numMarchas = numMarchas;
		this.diametros = diametros;
		this.velocidad = velocidad;
		id = ++numeroDeBicicleta;
	}

	public int getNumMarchas() {
		return numMarchas;
	}

	public void setNumMarchas(int numMarchas) {
		this.numMarchas = numMarchas;
	}

	public int getDiametros() {
		return diametros;
	}

	public void setDiametros(int diametros) {
		this.diametros = diametros;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "bicicleta [numMarchas=" + numMarchas + ", diametros=" + diametros + ", velocidad=" + velocidad + ", id="
				+ id + "]";
	}
	
}
