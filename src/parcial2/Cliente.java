package parcial2;

public class Cliente extends Usuario {
	
	private int nroCliente;
	private Cuenta cuenta;
	private boolean estaActiva;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(String nombre, String apellido, String username, String email, String contrasena, String dni) {
		super(nombre, apellido, username, email, contrasena, dni);
		// TODO Auto-generated constructor stub
		setNroCliente(nroCliente);
		setCuenta(cuenta);
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
	
	
	
	
	
	
	
	
	
	
}
