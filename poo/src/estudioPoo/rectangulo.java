package estudioPoo;

import java.util.Arrays;

public class rectangulo {
		
	private Punto[] puntos;
	
	public rectangulo() {
		
	}
	
	public rectangulo(Punto p1, Punto p2, Punto p3, Punto p4) {
		puntos = new Punto[] {p1, p2, p3, p4}; 
	}
	
	public rectangulo(Punto[] puntos) {
		this.puntos = puntos;
	}
	
	public void setOtraFigura(Punto... puntos) {
		this.puntos = puntos;
	}
	
	public Punto[] getPuntos() {
		return puntos;
	}
	
	public void setPuntos(Punto[] puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "rectangulo [puntos=" + Arrays.toString(puntos) + "]";
	}
	
	
}
