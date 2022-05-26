package Modelo;

public class cuentaCorriente {

	private String ccc;
	private double saldo;
	
	public cuentaCorriente() {}
	
	public cuentaCorriente(String ccc, double saldo) {
		this.ccc = ccc;
		this.saldo = saldo;
	}

	public String getCcc() {
		return ccc;
	}

	public void setCcc(String ccc) {
		this.ccc = ccc;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "cuentaCorriente [ccc=" + ccc + ", saldo=" + saldo + "]";
	}

}
