package parcial2;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cuenta {

	private String nroDeCuenta;
	private String cbu;
	private TipoDeCuenta tipoDeCuenta;
	private LinkedList<Tarjeta> tarjetas;
	private double saldo;
	private int pinCajero;
	private LinkedList<Movimiento> movimientos;

	public Cuenta() {
	}

	public Cuenta(String nroDeCuenta, String cbu, TipoDeCuenta tipoDeCuenta, double saldo, int pinCajero) {
		setNroDeCuenta(nroDeCuenta);
		setCbu(cbu);
		setTipoDeCuenta(tipoDeCuenta);
		this.tarjetas = new LinkedList<Tarjeta>();
		setSaldo(saldo);
		setPinCajero(pinCajero);
		this.movimientos = new LinkedList<Movimiento>();
	}

	public void SolicitarTarjetaDebito() {

	};

	public void SolicitarTarjetaCredito() {

	};

	public void ModificarSaldo(double saldo) {
		setSaldo(saldo);
	};

	public void Transferir(double monto, Cuenta cuentaRemitente, Cuenta cuentaDestinataria) {

		String[] opciones = { "Dinero en cuenta", "Crédito", "Cancelar" };

		int opcion;
		boolean transferido = false;

		do {
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una de las opciones para transferir:", "Transferir",
					0, 0, null, opciones, opciones[2]);

			if (opcion == 0) {
				for (Tarjeta tarjeta : this.tarjetas) {
					if (tarjeta instanceof Debito) {
						transferido = tarjeta.Transferir(monto, cuentaRemitente, cuentaDestinataria);

						if (!transferido) {
							JOptionPane.showMessageDialog(null,
									"Saldo insuficiente. \n Ingrese dinero en su cuenta o transfiera con crédito");

						} else {
							JOptionPane.showMessageDialog(null, "Trasferencia completada");
						}
					}
				}

			} else if (opcion == 1) {
				for (Tarjeta tarjeta : this.tarjetas) {
					
					if (tarjeta instanceof Credito) {
						transferido = tarjeta.Transferir(monto, cuentaRemitente, cuentaDestinataria);

						if (!transferido) {
							JOptionPane.showMessageDialog(null,
									"Limite insuficiente. \n Adelanta cuotas para liberar limite");

						} else {
							JOptionPane.showMessageDialog(null, "Trasferencia completada");
						}
					}
				}
			}

		} while (opcion != 2 || transferido == false);

	};

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

	public LinkedList<Tarjeta> getTarjetas() {
		return tarjetas;
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
