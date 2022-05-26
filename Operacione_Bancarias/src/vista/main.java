package vista;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Modelo.cuentaCorriente;
import Modelo.operacion;
import controlador.operaciones;
import excepciones.saldoException;

public class main {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		/*cuentaCorriente c1 = new cuentaCorriente("12345", 1640);
		System.out.println(c1);
		try {
			operacion operacion = new operacion(c1, "2021-12-30", "nomina", "1500");
			System.out.println(operacion);
		} catch (saldoException e) {
			System.out.println(e.getMessage());
		}*/
		cuentaCorriente c1 = new cuentaCorriente("123456", 1640);
		cuentaCorriente c2 = new cuentaCorriente("654321", 1810);
		/*try {
			operaciones op = new operaciones();
			for (operacion o : op.getMovimientos()) {
				System.out.println(o);
			}
			System.out.println("Ingreso++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(c1);
			if (op.ingreso(c1, "2022-03-10", "Bizum", "40")) {
				System.out.println("Ingreso completado");
			} else {
				System.out.println("Fallo en ingreso");
			}
			System.out.println(op.getMovimientos().get(op.getMovimientos().size()-1));
			System.out.println(c1);
			System.out.println("Cargo+++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(c1);
			if (op.cargo(c1, "2022-03-10", "Agua", "-80")) {
				System.out.println("Cargo completado");
			} else {
				System.out.println("Fallo en el cargo");
			}
			System.out.println(op.getMovimientos().get(op.getMovimientos().size()-1));
			System.out.println(c1);
			System.out.println("Transferencia++++++++++++++++++++++++++++++++++++++++");
			System.out.println(c1 + "\n" + c2);
			if (op.transferencia(c1, c2, "-1600")) {
				System.out.println("Transferencia completa");
			} else {
				System.out.println("Fallo en transferencia");
			}
			System.out.println(c1 + "\n" + c2);
			System.out.println(op.getMovimientos().get(op.getMovimientos().size()-2));
			System.out.println(op.getMovimientos().get(op.getMovimientos().size()-1));
			System.out.println("Todo++++++++++++++++++++++++++++++");
			for (operacion o : op.getMovimientos()) {
				System.out.println(o);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (saldoException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}*/
		System.out.println(c1);
		System.out.println(c2);
		
		try {
			operaciones operaciones = new operaciones();
			for (operacion op : operaciones.getMovimientos()) {
				System.out.println(op);
			}
			boolean seguir = true;
			do {
				System.out.println("Introduzca lo que quiera hacer\n1. Ingresar dinero\n2. Retirar dinero\n3. Transferir dinero\n4. Salir");
				int n = leer.nextInt();
				switch (n) {
				case 1:
					System.out.print("Introduzca cuanto dinero quiere ingresar: ");
					String num = leer.next();
					System.out.println("Introduzca el concepto");
					String concepto = leer.next();
					if (operaciones.ingreso(c1, concepto, num)) {
						System.out.println("Transferencia completada");
						System.out.println(operaciones.getMovimientos().get(operaciones.getMovimientos().size()-1));
						System.out.println(c1);
					} else {
						System.out.println("Fallo en transferencia");
					}
					break;
				case 2:
					System.out.print("Introduzca cuanto dinero quiere retirar: ");
					num = leer.next();
					System.out.println("Introduzca el concepto");
					concepto = leer.next();
					if (operaciones.cargo(c1, concepto, num)) {
						System.out.println("Cargo completada");
						System.out.println(operaciones.getMovimientos().get(operaciones.getMovimientos().size()-1));
						System.out.println(c1);
					} else {
						System.out.println("Fallo en la retirada");
					}
					break;
				case 3:
					System.out.print("Introduzca cuanto dinero quiere transferir: ");
					num = leer.next();
					if (operaciones.transferencia(c1, c2, num)) {
						System.out.println("Transferencia completada");
						System.out.println(operaciones.getMovimientos().get(operaciones.getMovimientos().size()-1));
						System.out.println(c1);
					} else {
						System.out.println("Fallo en la transferencia");
					}
					break;
				case 4:
					System.out.println("Hasta pronto");
					seguir = false;
					break;

				default:
					System.out.println("Comando no valido");
					break;
				}
			} while (seguir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (saldoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
