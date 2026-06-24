package parcial2;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Seeder();

		String[] opciones = { "Iniciar Sesión", "Registrarse", "Cerrar" };
		int opcion;

		do {

			opcion = JOptionPane.showOptionDialog(null, null, "Inicia Sesión o regístrate", 0, -1, null, opciones,
					opciones[2]);

			switch (opcion) {

			case 0:
				boolean flag = false;
				do {
					String usernameOrEmail = JOptionPane.showInputDialog("Ingrese su nombre de usuario o su email:");
					String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

					Usuario usuario = Usuario.Login(usernameOrEmail, contrasena);
					
					if (usuario != null) {
						Home(usuario);
						flag = true;
					}

				} while (flag);
				break;
			case 1:
				Cliente usuario = new Cliente();
				Usuario.AgregarUsuario(usuario);
				JOptionPane.showMessageDialog(null, usuario);
				Home(usuario);
				break;

			}

		} while (opcion != 2);

	}

	public static void Home(Usuario usuario) {

		String[] opciones = { "Ingresar dinero", "Transferir dinero", "Retirar dinero", "Mis datos", "Pagar servicios",
				"Cerrar Sesión" };
		int opcion;
		do {
			opcion = JOptionPane.showOptionDialog(null, null, "Bienvenido " + usuario.getNombre() , 0, -1, null, opciones,
					opciones[5]);
		} while (opcion != 5);
	}

	public static void Seeder() {
         LinkedList<Usuario> usuarios = new LinkedList<>();
         
         usuarios.add(new Cliente("Juan", "Pérez", "juanp89", "juan.perez@email.com", "Clave123!", "38444555", TipoDeCuenta.CAJA_AHORRO, "1234"));
         usuarios.add(new Cliente("María", "Gómez", "mariag", "maria.gomez@email.com", "Password987", "40111222", TipoDeCuenta.CUENTA_CORRIENTE, "4321"));
         usuarios.add(new Cliente("Lucas", "Rodríguez", "lucas_rod", "lucas.r@email.com", "Admin2026*", "35666777", TipoDeCuenta.CAJA_AHORRO, "9876"));
         usuarios.add(new Cliente("Ana", "Martínez", "anamart", "ana.mtz@email.com", "Segura321", "42999888", TipoDeCuenta.CUENTA_CORRIENTE, "5678"));
         
         for (Usuario usuario : usuarios) {
			Usuario.AgregarUsuario(usuario);
		}
	}

	
}
