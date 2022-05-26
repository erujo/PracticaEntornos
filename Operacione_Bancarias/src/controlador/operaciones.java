package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Modelo.cuentaCorriente;
import Modelo.operacion;
import excepciones.saldoException;

public class operaciones {

	private List<operacion> movimientos;
	
	public operaciones() throws IOException, saldoException {
		movimientos = leerFichero();
	}

	public List<operacion> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<operacion> movimientos) {
		this.movimientos = movimientos;
	}
	
	public boolean ingreso(cuentaCorriente ccc, String concepto, String ingreso) throws saldoException {
		double ing = Double.parseDouble(ingreso);
		if (ing >= 0) {
			//LocalDate fecha = LocalDate.now();
			operacion op = new operacion(ccc, LocalDate.now(), concepto, ingreso);
			movimientos.add(op);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean cargo(cuentaCorriente ccc, String concepto, String ingreso) throws saldoException {
		double ing = Double.parseDouble(ingreso);
		if (ing <= 0) {
			//LocalDate fecha = LocalDate.now();
			operacion op = new operacion(ccc, LocalDate.now(), concepto, ingreso);
			movimientos.add(op);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean transferencia(cuentaCorriente cccOrigen, cuentaCorriente cccDestino, String cargo) throws IOException, saldoException {
		double car = Double.parseDouble(cargo);
		if (car <= 0 && car <= cccOrigen.getSaldo()) {
			operacion op1 = new operacion(cccOrigen, LocalDate.now(), "Transferencia", cargo);
			cargo = Double.toString(car);
			operacion op2 = new operacion(cccDestino, LocalDate.now(), "Abono Transferencia", cargo);
			movimientos.add(op1);
			movimientos.add(op2);
			return true;
		} else {
			return false;
		}
	}

	private List<operacion> leerFichero() throws IOException, saldoException {
		FileReader fr = new FileReader("movimientos.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		//int registros = cuentaregistros();
		List<operacion> movimientos = new ArrayList<operacion>();
		while ((linea = br.readLine()) != null) {
			String datos[] = linea.split(",");
			double saldo = 0;
			try {
				saldo = Double.parseDouble(datos[4]);
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Numero no valido");
			}
			operacion op = new operacion(datos[0], datos[1], datos[2], datos[3], saldo);
			movimientos.add(op);
		}
		return movimientos;
	}

	private int cuentaregistros() throws IOException {
		FileReader fr = new FileReader("movimientos.txt");
		BufferedReader br = new BufferedReader(fr);
		int registros = 0;
		String linea = "";
		while ((linea = br.readLine()) != null) {
			registros++;
		}
		br.close();
		fr.close();
		br = null;
		fr = null;
		return registros;
	}
	
}
