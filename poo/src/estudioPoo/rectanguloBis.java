package estudioPoo;

public class rectanguloBis implements Geometria {

	private double largo;
	private double ancho;

	public rectanguloBis(double largo, double ancho) {
		super();
		this.largo = largo;
		this.ancho = ancho;
	}

	public double getArea() {
		return largo * ancho;
	}

	@Override
	public int compareTo(Geometria figura) {
		rectanguloBis rectangulo = (rectanguloBis)figura;
		if (getArea() > rectangulo.getArea()) {
			return 1;
		} else if (getArea() < rectangulo.getArea()) {
			return -1;
		} else {
			return 0;
		}
	}
}
