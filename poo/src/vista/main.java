package vista;

//import estudioPoo.A;
import estudioPoo.Punto;
import estudioPoo.bicicleta;
import estudioPoo.circulo;
import estudioPoo.empleado;
import estudioPoo.estudioEquals;
import estudioPoo.persona;
import estudioPoo.persona1;
import estudioPoo.persona2;
import estudioPoo.rectangulo;
import estudioPoo.rectanguloBis;
import estudioPoo.trabajador;

public class main {

	public static void main(String[] args) {
		//contructores();
		//propiedadesymetodos();
		//argumentos();
		//PasoValorReferencia();
		//modificadores();
		//estatico();
		//sobrecarga();
		//herencia();
		//polimorfismo();
		//interfaces();
		estudioEquals eq = new estudioEquals();
	}

	private static void polimorfismo() {
		trabajador trabajador = new trabajador("Bill Gates", "Presidente", "Redmond", "", "");
		trabajador empleado = new empleado("Jon maquenrou", "Presidente", "Redmond", "", "", 100000, 10000);
		saludar(trabajador);
		saludar(empleado);
	}
	
	private static void saludar(trabajador trabajador) {
		System.out.println("Hola, soy " + trabajador.getNombre());
	}

	private static void interfaces() {
		rectanguloBis rectangulo1 = new rectanguloBis(5, 4);
		rectanguloBis rectangulo2 = new rectanguloBis(4, 5);
		System.out.println(rectangulo1.compareTo(rectangulo2));
	}

	private static void herencia() {
		
	}

	private static void sobrecarga() {
		
	}

	private static void estatico() {
		bicicleta bici1 = new bicicleta(21, 27, 0);
		System.out.println(bicicleta.getNumeroDeBicicleta());
		bicicleta bici2 = new bicicleta(18, 24, 0);
		System.out.println(bicicleta.getNumeroDeBicicleta());
		System.out.println(bici1);
		System.out.println(bici2);
	}

	/*private static void modificadores() {
		A a = new A();
		System.out.println(a.getA());
	}*/

	private static void PasoValorReferencia() {
		circulo circulo1 = new circulo(2, 3);
		System.out.println(circulo1);
		moverCirculo(circulo1, 23, 56); 
		System.out.println(circulo1);
	}

	private static void moverCirculo(circulo circulo1, int i, int j) {
		circulo1.setX(circulo1.getX() + i);
		circulo1.setY(circulo1.getY() + j);
		circulo1 = new circulo(0, 0);
	}

	private static void argumentos() {
		//rectangulo rec = new rectangulo();
		Punto punto1 = new Punto(0, 0);Punto punto2 = new Punto(5, 0);
		Punto punto3 = new Punto(5, 3);Punto punto4 = new Punto(0, 3);
		Punto puntos[] = {punto1, punto2, punto3, punto4};
		rectangulo rectangulo = new rectangulo(punto1, punto2, punto3, punto4);
		rectangulo rectangulo2 = new rectangulo(puntos);
		System.out.println(rectangulo.toString());
		rectangulo = null;
		rectangulo = new rectangulo();
		rectangulo.setOtraFigura(punto1, punto2);
		System.out.println(rectangulo);
	}

	private static void propiedadesymetodos() {
		persona2 p = new persona2();
		p.setAltura(180);
		p.setNombre("Hugo");
		System.out.println(p.getNombre());
		System.out.println(p);
	}

	private static void contructores() {
		persona1 per1 = new persona1("Hugo", "Parada Cañas", 19, 180, 83);
		per1.presentacion();
	}

}
