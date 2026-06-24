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
	private String pinCajero;
	private LinkedList<Movimiento> movimientos;

	public Cuenta() {
		setNroDeCuenta(numero);
		numero++;
		setCbu(GenerarCbu());
		DefinirTipoDeCuenta();
		this.tarjetas = new LinkedList<Tarjeta>();
		setSaldo(0);
		blanquerPin();
		this.movimientos = new LinkedList<Movimiento>();
	}

	public Cuenta(TipoDeCuenta tipoDeCuenta, String pinCajero, double saldo) {
		setNroDeCuenta(numero);
		numero++;
		setCbu(GenerarCbu());
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
	
	public void IngresarDinero() {
		double dinero = Double.parseDouble(validarNumero("Ingrese el monto que quiere ingresar:"));
		ModificarSaldo(getSaldo() + dinero);
		JOptionPane.showMessageDialog(null, "El dinero fue ingresado con exito");
	}

	public void ModificarSaldo(double saldo) {
		setSaldo(saldo);
	};
	
	private void blanquerPin() {
		String pin ="";
		do {
			pin = validarNumero("Ingresa un PIN de 4 digitos:");
			if (pin.length() > 4 || pin.length() < 4) {
				JOptionPane.showMessageDialog(null, "El PIN debe ser de 4 digitos");
			}
		} while (pin.length() > 4 || pin.length() < 4);
		
		setPinCajero(pin);
	};

	private void DefinirTipoDeCuenta() {
		String[] opciones = { "Caja de ahorro", "Cuenta corriente" };
		int opcion = JOptionPane.showOptionDialog(null, "Seleccione un tipo de cuenta:", "Tipo de cuenta",
				0, 0, null, opciones, opciones[0]);

		switch (opcion) {
		
		case 0:
            setTipoDeCuenta(TipoDeCuenta.CAJA_AHORRO);
			break;
			
		case 1:
			setTipoDeCuenta(TipoDeCuenta.CUENTA_CORRIENTE);
			break;

		}

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
	
	private String validarNumero(String mensaje) {
		String input;
		boolean flag;
		do {
			flag = true;
			input = JOptionPane.showInputDialog(mensaje);
			if (input.trim().isEmpty()) {
				input = JOptionPane.showInputDialog("No puede estar vacío, " + mensaje);
				flag = false;
			} else {
				for (int i = 0; i < input.length(); i++) {
					if (!Character.isDigit(input.charAt(i))) {
						JOptionPane.showMessageDialog(null, "Solo puedes ingresar números");
						flag = false;
						break;
					}
				}
			}

		} while (!flag);

		return input;
	}

//	private String validarTexto(String mensaje) {
//		String input;
//		boolean flag;
//		do {
//			flag = true;
//			input = JOptionPane.showInputDialog(mensaje);
//			if (input.trim().isEmpty()) {
//				input = JOptionPane.showInputDialog("No puede estar vacío, " + mensaje);
//				flag = false;
//			} else {
//				for (int i = 0; i < input.length(); i++) {
//					if (Character.isDigit(input.charAt(i))) {
//						JOptionPane.showMessageDialog(null, "Solo puede ingresar un texto");
//						flag = false;
//						break;
//					}
//				}
//			}
//
//		} while (!flag);
//
//		return input;
//	}

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

	public String getPinCajero() {
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

	private void setPinCajero(String pinCajero) {
		this.pinCajero = pinCajero;
	}

	@Override
	public String toString() {
		return "nroDeCuenta: " + nroDeCuenta + ", cbu: " + cbu + ", tipoDeCuenta: " + tipoDeCuenta + ", tarjetas: "
				+ tarjetas + ", saldo: " + saldo + ", pinCajero: " + pinCajero + ", movimientos: " + movimientos ;
	}

}
