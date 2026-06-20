package parcial2;

import java.util.LinkedList;

public class Cuenta {
	
	private String nroDeCuenta;
	private String cbu;
	private TipoDeCuenta tipoDeCuenta;
	private double saldo;
	private int pinCajero;
	private LinkedList<Movimiento> movimientos;
	
	
	
	public Cuenta() {
	}

	public Cuenta(String nroDeCuenta, String cbu, TipoDeCuenta tipoDeCuenta, double saldo, int pinCajero) {
		setNroDeCuenta(nroDeCuenta);
		setCbu(cbu);
		setTipoDeCuenta(tipoDeCuenta);
		setSaldo(saldo);
		setPinCajero(pinCajero);
		this.movimientos = new LinkedList<Movimiento>();
	}
	
	public void AgregarTarjeta() {};

	public String getNroDeCuenta() {
		return nroDeCuenta;
	}

	public String getCbu() {
		return cbu;
	}

	public TipoDeCuenta getTipoDeCuenta() {
		return tipoDeCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getPinCajero() {
		return pinCajero;
	}

	public LinkedList<Movimiento> getMovimientos() {
		return movimientos;
	}

	private void setNroDeCuenta(String nroDeCuenta) {
		this.nroDeCuenta = nroDeCuenta;
	}

	private void setCbu(String cbu) {
		this.cbu = cbu;
	}

	private void setTipoDeCuenta(TipoDeCuenta tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private void setPinCajero(int pinCajero) {
		this.pinCajero = pinCajero;
	}

	
}
