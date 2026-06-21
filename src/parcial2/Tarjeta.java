package parcial2;

import java.time.LocalDate;

public abstract class Tarjeta{
	private String titular;
	private String numTarjeta;
	private String codSeguridad;
	private boolean estaActiva;
	private LocalDate fechaImpresion;
	private LocalDate fechaVencimiento;
	
	public Tarjeta(String titular, String numTarjeta, String codSeguridad, LocalDate fechaImpresion, LocalDate fechaVencimiento) {

		setTitular(titular);
		setNumTarjeta(numTarjeta);
		setCodSeguridad(codSeguridad);
		setEstaActiva(true);
		setFechaImpresion(fechaImpresion);
		setFechaVencimiento(fechaVencimiento);
	}
	
	public abstract void Pagar(double monto, Cuenta cuenta);
	
	public abstract void Transferir(double monto, Cuenta cuenta);

	public String getTitular() {
		return titular;
	}

	private void setTitular(String titular) {
		this.titular = titular;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	private void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getCodSeguridad() {
		return codSeguridad;
	}

	private void setCodSeguridad(String codSeguridad) {
		this.codSeguridad = codSeguridad;
	}

	public boolean isEstaActiva() {
		return estaActiva;
	}

	private void setEstaActiva(boolean estaActiva) {
		this.estaActiva = estaActiva;
	}

	public LocalDate getFechaImpresion() {
		return fechaImpresion;
	}

	private void setFechaImpresion(LocalDate fechaImpresion) {
		this.fechaImpresion = fechaImpresion;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	private void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	
	
	
}
