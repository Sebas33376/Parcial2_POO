package parcial2;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SeederClientes();
		SeederEmpleado();

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
						flag = true;
					}

				} while (flag);
				break;
			case 1:
                   Usuario usuario = new Usuario();
                   Usuario.AgregarUsuario(usuario);
                   JOptionPane.showMessageDialog(null,usuario);
				break;

			}

		} while (opcion != 2);

	}

	public static void SeederClientes() {

	}

	public static void SeederEmpleado() {

	}

}
