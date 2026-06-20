package parcial2;

import java.time.LocalDate;

public class Movimiento {

	private LocalDate fechaRealizada;
	private int nroOperacion;
	private String nombreCuenta;
	private double monto;
	
	public Movimiento(LocalDate fechaRealizada, int nroOperacion, String nombreCuenta, double monto) {
		
		setFechaRealizada(fechaRealizada);
		setNroOperacion(nroOperacion);
		setNombreCuenta(nombreCuenta);
		setMonto(monto);
	}

	public LocalDate getFechaRealizada() {
		return fechaRealizada;
	}

	private void setFechaRealizada(LocalDate fechaRealizada) {
		this.fechaRealizada = fechaRealizada;
	}

	public int getNroOperacion() {
		return nroOperacion;
	}

	private void setNroOperacion(int nroOperacion) {
		this.nroOperacion = nroOperacion;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	private void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public double getMonto() {
		return monto;
	}

	private void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	
}
