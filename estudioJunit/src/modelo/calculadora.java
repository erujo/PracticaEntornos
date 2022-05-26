package modelo;

public class calculadora {

	private int mr;
	
	public calculadora() {
		// TODO Auto-generated constructor stub
	}
	
	public int suma(int a, int b) {
		mr = a + b;
		return mr;
	}
	
	public int resta(int a, int b) {
		mr = a - b;
		return mr;
	}
	
	public int suma(int a) {
		mr+=a;
		return mr;
	}
	
	public double suma(double a, double b) {
		return a + b;
	}
	
	public int resta(int a) {
		mr-=a;
		return mr;
	}
	
	public int mr() {
		return mr;
	}
	
	public int div(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("No puedes dividir entre cero");
		}
		mr = a/b;
		return mr;
	}
	
	public void operacionOptima() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			System.out.println("Operacion interrumpida");
		}
	}
	
}
