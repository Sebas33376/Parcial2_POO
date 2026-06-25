package parcial2;

import java.time.LocalDate;

public class Movimiento {

	private static int numero = 1;
	private LocalDate fechaRealizada;
	private int nroOperacion;
	private String nombre;
	private double monto;
	
	public Movimiento(String nombre, double monto) {
		
		setFechaRealizada(LocalDate.now());
		setNroOperacion(numero);
		numero++;
		setNombre(nombre);
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

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombreCuenta) {
		this.nombre = nombreCuenta;
	}

	public double getMonto() {
		return monto;
	}

	private void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Fecha: " + fechaRealizada + "\nN° Operacion:" + nroOperacion + "\nNombre: " + nombre
				+ "\nMonto: " + monto + "\n\n";
	}
	
	
	
}
