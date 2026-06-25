package parcial2;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cuenta {
	private static int numero = 1;
	protected static LinkedList<String> listaCbus = new LinkedList<String>();
	private int nroDeCuenta;
	private String cbu;
	private TipoDeCuenta tipoDeCuenta;
	private LinkedList<Tarjeta> tarjetas;
	private LinkedList<Servicio> servicios;
	private double saldo;
	private String pinCajero;
	private LinkedList<Movimiento> movimientos;

	public Cuenta() {
		setNroDeCuenta(numero);
		numero++;
		setCbu(GenerarCbu());
		DefinirTipoDeCuenta();
		this.tarjetas = new LinkedList<Tarjeta>();
		this.servicios = new LinkedList<Servicio>();
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
		this.servicios = new LinkedList<Servicio>();
		setSaldo(saldo);
		setPinCajero(pinCajero);
		this.movimientos = new LinkedList<Movimiento>();
	}

	public static void SolicitarTarjetaDebito(Cliente cliente) {
		String nombre = cliente.getNombre().toUpperCase() + " " + cliente.getApellido().toUpperCase();
		LocalDate fechaActual = LocalDate.now();
		cliente.getCuenta().getTarjetas().add(
				new Debito(nombre, Cuenta.GenerarNroTarjeta(), "123", true, fechaActual, fechaActual.plusYears(4)));
	};

	public void SolicitarTarjetaCredito() {

	};
	
	public void AgregarMovimiento(Movimiento movimiento) {
		this.movimientos.add(movimiento);
	}
	
	public void AgregarServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	public String MostrarMovimientos() {
		String movimientos = "";
		
		for (Movimiento movimiento : this.movimientos) {
			movimientos += movimiento;
		}
		
		if (this.movimientos.isEmpty()) {
			return "No hay movimientos registrados";
		} else {

			return movimientos;
		}
		
	}

	public void GenerarOrdenRetiro(String dni, double monto) {

		String nroRetiro = GenerarCodRetiro();

		if (this.getSaldo() < monto) {
			JOptionPane.showMessageDialog(null,"Saldo insuficiente");
		} else {

			JOptionPane.showMessageDialog(null,
					"DNI: " + dni + "\nNumero de retiro: " + nroRetiro + "\nMonto: " + monto);
			this.ModificarSaldo(this.saldo - monto);
		}
		
		Movimiento movimiento = new Movimiento("Retiro de dinero", monto);
		this.AgregarMovimiento(movimiento);

	}

	public void IngresarDinero() {
		double dinero = Double.parseDouble(validarNumero("Ingrese el monto que quiere ingresar:"));
		ModificarSaldo(getSaldo() + dinero);
		JOptionPane.showMessageDialog(null, "El dinero fue ingresado con exito");
		Movimiento movimiento = new Movimiento("Ingreso de dinero", dinero);
		this.AgregarMovimiento(movimiento);
	}

	public void ModificarSaldo(double saldo) {
		setSaldo(saldo);
	};

	private void blanquerPin() {
		String pin = "";
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
		int opcion = JOptionPane.showOptionDialog(null, "Seleccione un tipo de cuenta:", "Tipo de cuenta", 0, 0, null,
				opciones, opciones[0]);

		switch (opcion) {

		case 0:
			setTipoDeCuenta(TipoDeCuenta.CAJA_AHORRO);
			break;

		case 1:
			setTipoDeCuenta(TipoDeCuenta.CUENTA_CORRIENTE);
			break;

		}

	};

	private String GenerarCodRetiro() {
		String codRetiro = "";
		boolean flag;

		do {
			flag = true;
			for (int i = 0; i < 6; i++) {
				int digito = (int) (Math.random() * 10);
				codRetiro += digito;
			}

		} while (!flag);

		return codRetiro;
	}

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

		listaCbus.add(cbuGenerado);

		return cbuGenerado;
	};

	private static String GenerarNroTarjeta() {

		String nroGenerado = "";
		boolean flag;

		do {
			flag = true;
			for (int i = 0; i < 16; i++) {
				int digito = (int) (Math.random() * 10);
				nroGenerado += digito;
			}

		} while (!flag);

		return nroGenerado;
	};

	public static void Transferir(double monto, Cuenta cuentaRemitente, Cuenta cuentaDestinataria) {

		String[] opciones = { "Dinero en cuenta", "Crédito", "Cancelar" };

		int opcion;
		boolean transferido = false;

		do {
			opcion = JOptionPane.showOptionDialog(null, "Seleccione una de las opciones para transferir:", "Transferir",
					0, 0, null, opciones, opciones[2]);

			if (opcion == 0) {
				for (Tarjeta tarjeta : cuentaRemitente.getTarjetas()) {
					if (tarjeta instanceof Debito) {
						transferido = tarjeta.Transferir(monto, cuentaRemitente, cuentaDestinataria);

						if (!transferido) {
							JOptionPane.showMessageDialog(null,
									"Saldo insuficiente. \n Ingrese dinero en su cuenta o transfiera con crédito");

						} else {
							JOptionPane.showMessageDialog(null, "Trasferencia completada");
							transferido = true;
							Movimiento movimientoRemitente = new Movimiento("Transferiste dinero" + "\nCBU: " + cuentaDestinataria.getCbu(), monto);
							Movimiento movimientoDestinatario = new Movimiento("Reciviste dinero" + "\nCBU: " + cuentaRemitente.getCbu(), monto);
							cuentaRemitente.AgregarMovimiento(movimientoRemitente);
							cuentaDestinataria.AgregarMovimiento(movimientoDestinatario);
						}
					}
				}

			} else if (opcion == 1) {
				for (Tarjeta tarjeta : cuentaRemitente.getTarjetas()) {

					if (tarjeta instanceof Credito) {
						transferido = tarjeta.Transferir(monto, cuentaRemitente, cuentaDestinataria);

						if (!transferido) {
							JOptionPane.showMessageDialog(null,
									"Limite insuficiente. \n Adelanta cuotas para liberar limite");

						} else {
							JOptionPane.showMessageDialog(null, "Trasferencia completada");
							transferido = true;
						}
					}
				}
			}

		} while (opcion != 2 && transferido == false);

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
		return "Numero de Cuenta: " + nroDeCuenta + "\nCBU: " + cbu + "\nTipo de Cuenta: " + tipoDeCuenta
				+ "\nTarjetas: " + tarjetas + "\nSaldo: " + saldo + "\nPin: " + pinCajero + "\n";
	}

}
