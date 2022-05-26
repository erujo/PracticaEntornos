package vista;

import modelo.Calculadora;

public class main {

	public main() {}

	public static void main(String[] args) {
		Calculadora calculadora=new Calculadora();
		int suma = calculadora.suma(3,-4);
		System.out.println(suma);
	}

}
