package parcial2;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cuenta {
    private static int numero = 1;
    private static LinkedList<String> listaCbus = new LinkedList<String>(); 
	private int nroDeCuenta;
	private String cbu;
	private TipoDeCuenta tipoDeCuenta;
	private LinkedList<Tarjeta> tarjetas;
	private double saldo;
	private int pinCajero;
	private LinkedList<Movimiento> movimientos;

	public Cuenta() {
	}

	public Cuenta(TipoDeCuenta tipoDeCuenta, int pinCajero) {
		setNroDeCuenta(numero);
		numero++;
		setCbu(GenerarCbu());
		setTipoDeCuenta(tipoDeCuenta);
		this.tarjetas = new LinkedList<Tarjeta>();
		setSaldo(0);
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
	
	private String GenerarCbu() {
		
		String cbuGenerado = "";
		boolean flag;
		
		do {
			flag = true;
			for (int i = 0; i < 22; i++) {
				int digito = (int) (Math.random() * 10);
				cbuGenerado += digito;
			}
			
			for (String cbu : listaCbus) {
				if (cbuGenerado.equals(cbu)) {
					flag = false;
					break;
				}
			}
		} while (!flag);
	
		                                                          
		return cbuGenerado;
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

	public int getNroDeCuenta() {
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

	private void setNroDeCuenta(int nroDeCuenta) {
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
