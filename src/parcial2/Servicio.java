package parcial2;

import java.time.LocalDate;
import java.util.LinkedList;

public class Servicio {
    private static int numero = 1;
    private int nroServicio;
	private LocalDate fechaVencimiento;
	private String nombre;
	private double costo;
	
	public Servicio(LocalDate fechaVencimiento, String nombre, double costo) {
		setNroServicio(numero);
		numero++;
		setFechaVencimiento(fechaVencimiento);
		setNombre(nombre);
		setCosto(costo);
		
	}
	
	
	public int getNroServicio() {
		return nroServicio;
	}
	
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setNroServicio(int nroServicio) {
		this.nroServicio = nroServicio;
	}
	
	private void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Fecha de vencimiento: " + fechaVencimiento + "\nNombre: " + nombre + "\nCosto:" + costo;
	};
	
	
	
	
	
}
