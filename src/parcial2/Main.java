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
			Usuario usuario = null;
			switch (opcion) {

			case 0:
				boolean flag = false;
				do {
					String usernameOrEmail = JOptionPane.showInputDialog("Ingrese su nombre de usuario o su email:");
					String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

					usuario = Usuario.Login(usernameOrEmail, contrasena);
					System.out.println(usuario);

					if (usuario != null) {
						flag = true;
					} else {
						JOptionPane.showMessageDialog(null, "El nombre de usuaro/email o contraseña son incorrectos");
					}

				} while (!flag);
				break;
			case 1:
				usuario = new Cliente();
				Usuario.AgregarUsuario(usuario);
				// JOptionPane.showMessageDialog(null, usuario);
				break;

			}
			Home(usuario);

		} while (opcion != 2);

	}

	public static void Home(Usuario usuario) {

		String[] opciones = { "Ingresar dinero", "Transferir dinero", "Retirar dinero", "Mis datos", "Pagar servicios",
				"Cerrar Sesión" };

		int opcion;

		do {
			Cliente cliente = (Cliente) usuario;

			opcion = JOptionPane.showOptionDialog(null, "Saldo: $" + cliente.getCuenta().getSaldo(),
					"Bienvenido " + usuario.getNombre(), 0, -1, null, opciones, opciones[5]);

			switch (opcion) {

			case 0:
				cliente.getCuenta().IngresarDinero();
				break;
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;

			}

		} while (opcion != 5);
	}
	
	public static Cliente ObtenerClientePorCbu(String cbu) {
		
		Cliente cliente = null;
		boolean flag = false;
		
		do {
			for (Usuario usuario : Usuario.listaUsuarios) {
				if (usuario instanceof Cliente) {
					cliente = (Cliente) usuario;
					if (cbu.equals(cliente.getCuenta().getCbu())) {
						flag = true;
					}
				}
			}
		} while (!flag);
		
		return cliente;
	}

	public static void Seeder() {
		LinkedList<Usuario> usuarios = new LinkedList<>();

		usuarios.add(new Cliente("Juan", "Pérez", "juanp89", "juan.perez@email.com", "Clave123!", "38444555",
				TipoDeCuenta.CAJA_AHORRO, "1234",350000.64));
		usuarios.add(new Cliente("María", "Gómez", "mariag", "maria.gomez@email.com", "Password987", "40111222",
				TipoDeCuenta.CUENTA_CORRIENTE, "4321", 87345.01));
		usuarios.add(new Cliente("Lucas", "Rodríguez", "lucas_rod", "lucas.r@email.com", "Admin2026*", "35666777",
				TipoDeCuenta.CAJA_AHORRO, "9876", 826789.00));
		usuarios.add(new Cliente("Ana", "Martínez", "anamart", "ana.mtz@email.com", "Segura321", "42999888",
				TipoDeCuenta.CUENTA_CORRIENTE, "5678", 16489.21));

		for (Usuario usuario : usuarios) {
			Usuario.AgregarUsuario(usuario);
		}
	}

}
