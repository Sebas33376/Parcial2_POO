package parcial2;

import java.time.LocalDateTime;

public class OrdenDeRetiro {
	
	private final static String HORA_VENCIMIENTO = "23:59";
	private LocalDateTime fechaYhoraEmicion;
	private double monto;
	private int codExtraccion;
	
	public OrdenDeRetiro(LocalDateTime fechaYhoraEmicion, double monto, int codExtraccion) {
	
		setFechaYhoraEmicion(fechaYhoraEmicion);
		setMonto(monto);
		setCodExtraccion(codExtraccion);
		
	}
	
	
	public static String getHoraVencimiento() {
		return HORA_VENCIMIENTO;
	}

	public LocalDateTime getFechaYhoraEmicion() {
		return fechaYhoraEmicion;
	}

	private void setFechaYhoraEmicion(LocalDateTime fechaYhoraEmicion) {
		this.fechaYhoraEmicion = fechaYhoraEmicion;
	}

	public double getMonto() {
		return monto;
	}

	private void setMonto(double monto) {
		this.monto = monto;
	}

	public int getCodExtraccion() {
		return codExtraccion;
	}

	private void setCodExtraccion(int codExtraccion) {
		this.codExtraccion = codExtraccion;
	}
	
	
	
}
