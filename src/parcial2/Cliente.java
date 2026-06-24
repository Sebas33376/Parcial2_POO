package parcial2;

import javax.swing.JOptionPane;

public class Cliente extends Usuario {

	private static int numero = 1;
	private int nroCliente;
	private Cuenta cuenta;
	private boolean estaActiva;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
		setNroCliente(numero);
		setCuenta(new Cuenta());
		numero++;
		this.estaActiva = true;
		JOptionPane.showInternalMessageDialog(null, "Te has registrado con éxito");

	}

	public Cliente(String nombre, String apellido, String username, String email, String contrasena, String dni,
			TipoDeCuenta tipoDeCuenta, String pinCajero, double saldo) {
		super(nombre, apellido, username, email, contrasena, dni);
		// TODO Auto-generated constructor stub
		setNroCliente(numero++);
		setCuenta(new Cuenta(tipoDeCuenta, pinCajero, saldo));
		this.estaActiva = true;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public boolean isEstaActiva() {
		return estaActiva;
	}

	private void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	private void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Cliente [nroCliente=" + nroCliente + ", cuenta=" + cuenta + ", estaActiva=" + estaActiva
				+ ", toString()=" + super.toString() + "]";
	}

}
