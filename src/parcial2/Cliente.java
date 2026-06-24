package parcial2;

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

	}

	public Cliente(String nombre, String apellido, String username, String email, String contrasena, String dni,
			TipoDeCuenta tipoDeCuenta, String pinCajero) {
		super(nombre, apellido, username, email, contrasena, dni);
		// TODO Auto-generated constructor stub
		setNroCliente(numero++);
		setCuenta(new Cuenta(tipoDeCuenta, pinCajero));
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
