package parcial2;

import java.time.LocalDate;

public class TarjetaCredito extends TarjetaDebito {
	
	private double limite;

	public TarjetaCredito(String titular, String numTarjeta, String codSeguridad, boolean estaActiva,
			LocalDate fechaImpresion, LocalDate fechaVencimiento, double limite) {
		
		super(titular, numTarjeta, codSeguridad, estaActiva, fechaImpresion, fechaVencimiento);
		
		setLimite(limite);
	}

	public double getLimite() {
		return limite;
	}

	private void setLimite(double limite) {
		this.limite = limite;
	}
	
		
	
	
}
