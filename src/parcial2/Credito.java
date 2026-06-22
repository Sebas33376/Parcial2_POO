package parcial2;

import java.time.LocalDate;

public class Credito extends Tarjeta {
	
	private double limite;
	private double limiteDisponible;

	public Credito(String titular, String numTarjeta, String codSeguridad, boolean estaActiva,
			LocalDate fechaImpresion, LocalDate fechaVencimiento, double limite) {
		
		super(titular, numTarjeta, codSeguridad, fechaImpresion, fechaVencimiento);
		
		setLimite(limite);
		setLimiteDisponible(limite);
	}

	public double getLimite() {
		return limite;
	}
	
	public double getLimiteDiponible() {
		return limiteDisponible;
	}
	
	private void setLimite(double limite) {
		this.limite = limite;
	}
	
	private void setLimiteDisponible(double limiteDisponible) {
		this.limiteDisponible = limiteDisponible;
	}

	@Override
	public void Pagar(double monto, Cuenta cuenta) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean Transferir(double monto, Cuenta cuentaRemitente, Cuenta cuentaDestinataria) {
		// TODO Auto-generated method stub
		
		return false;
	}
	
		
	
	
}
