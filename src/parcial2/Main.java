package parcial2;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SeederClientes();
		SeederEmpleado();
		
		String[] opciones = {"Iniciar Sesión", "Registrarse", "Cerrar"};
		int opcion;
		
		do {
			
			opcion = JOptionPane.showOptionDialog(null, null , "Inicia Sesión o regístrate", 0, -1, null, opciones, opciones[2]);
			
			
			
		} while (opcion != 2);
		
	}
	
	public static void SeederClientes() {
		
	}
	public static void SeederEmpleado() {
		
	}

}
