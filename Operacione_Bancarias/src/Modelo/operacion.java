package Modelo;

import java.time.LocalDate;

import excepciones.saldoException;

public class operacion {

	private cuentaCorriente ccc;
	private LocalDate fecha;
	private String concepto;
	private double cargoIngreso;
	private double saldoActual;
	
	public operacion(cuentaCorriente ccc, LocalDate fecha, String concepto, String cargoIngreso) throws saldoException {
		this.ccc = ccc;
		this.fecha = fecha;
		this.concepto = concepto;
		setCargoIngreso(cargoIngreso, this.ccc);
		this.saldoActual = this.ccc.getSaldo();
	}
	
	public operacion(String ccc, String fecha, String concepto, String cargoIngreso, double saldo) throws saldoException {
		this.ccc = new cuentaCorriente(ccc, saldo);
		setFecha(fecha);
		this.concepto = concepto;
		this.cargoIngreso = Double.parseDouble(cargoIngreso);
		this.saldoActual = this.ccc.getSaldo();
	}

	public cuentaCorriente getCcc() {
		return ccc;
	}

	public void setCcc(cuentaCorriente ccc) {
		this.ccc = ccc;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = LocalDate.parse(fecha);
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getCargoIngreso() {
		return cargoIngreso;
	}

	public void setCargoIngreso(String cargoIngreso, cuentaCorriente ccc) throws saldoException {
		compruebaIngreso(cargoIngreso, ccc);
		this.cargoIngreso = Double.parseDouble(cargoIngreso);
	}

	private void compruebaIngreso(String cargoIngreso, cuentaCorriente ccc) throws saldoException {
		try {
			double num = Double.parseDouble(cargoIngreso) + ccc.getSaldo();
			if (num >= 0) {
				ccc.setSaldo(num);
			} else {
				throw new saldoException();
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Numero no valido");
		}
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	@Override
	public String toString() {
		String frase = ccc.getCcc() + ", " + ccc.getSaldo() + ", " + fecha + ", " + concepto + ", " + cargoIngreso + ", " + saldoActual;
		return frase;
	}
	
}
