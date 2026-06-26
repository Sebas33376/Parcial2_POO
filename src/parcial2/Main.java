package parcial2;

import java.time.LocalDate;
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
				Cuenta.SolicitarTarjetaDebito((Cliente) usuario);
				// JOptionPane.showMessageDialog(null, usuario);
				break;

			}
			Home(usuario);

		} while (opcion != 2);

	}

	public static void Home(Usuario usuario) {

		String[] opciones = { "Ingresar dinero", "Transferir dinero", "Retirar dinero", "Movimientos" ,"Mis datos", "Pagar servicios",
				"Cerrar Sesión" };

		int opcion;

		do {
			Cliente cliente = (Cliente) usuario;
			
			opcion = JOptionPane.showOptionDialog(null, "Saldo: $" + String.format("%.2f", cliente.getCuenta().getSaldo()),
					"Bienvenido " + usuario.getNombre(), 0, -1, null, opciones, opciones[5]);

			switch (opcion) {

			case 0:
				cliente.getCuenta().IngresarDinero();
				break;
			case 1:
				TransferirDinero(cliente);
				break;
			case 2:
				double monto = Double.parseDouble(validarNumero("Ingrese el monto que quiere retirar:"));
				cliente.getCuenta().GenerarOrdenRetiro(ValidarDni(), monto);

				break;
			case 3:
				JOptionPane.showMessageDialog(null, cliente.getCuenta().MostrarMovimientos());
				break;
			case 4:
				JOptionPane.showMessageDialog(null, cliente);
				break;
			case 5:
				JOptionPane.showMessageDialog(null, cliente);
				break;

			}

		} while (opcion != 6);
	}

	public static void TransferirDinero(Cliente cuentaRemitente) {
		String cbu = "";
		do {

			Object seleccion = JOptionPane.showInputDialog(null, "Elija el CBU de la cuenta a transferir", "Transferir",
					JOptionPane.QUESTION_MESSAGE, null, Cuenta.listaCbus.toArray(), Cuenta.listaCbus.get(0));

			cbu = (String) seleccion;

			if (cbu.length() > 22 && cbu.length() < 22) {
				JOptionPane.showMessageDialog(null, "El CBU ingresado es invalido");
			}
		} while (cbu.length() > 22 && cbu.length() < 22);

		Cliente cuentaDestinatario = ObtenerClientePorCbu(cbu);

		double dinero = Double.parseDouble(validarNumero("Ingrese el monto que quiere transferir:"));

		Cuenta.Transferir(dinero, cuentaRemitente.getCuenta(), cuentaDestinatario.getCuenta());

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
						break;
					}
				}
			}
		} while (!flag);

		return cliente;
	}

	public static void Seeder() {
		LinkedList<Usuario> usuarios = new LinkedList<>();

//		usuarios.add(new Cliente("Juan", "Pérez", "juanp89", "juan.perez@email.com", "Clave123!", "38444555",
//				TipoDeCuenta.CAJA_AHORRO, "1234", 350000.64));
//		usuarios.add(new Cliente("María", "Gómez", "mariag", "maria.gomez@email.com", "Password987", "40111222",
//				TipoDeCuenta.CUENTA_CORRIENTE, "4321", 87345.01));
//		usuarios.add(new Cliente("Lucas", "Rodríguez", "lucas_rod", "lucas.r@email.com", "Admin2026*", "35666777",
//				TipoDeCuenta.CAJA_AHORRO, "9876", 826789.00));
//		usuarios.add(new Cliente("Ana", "Martínez", "anamart", "ana.mtz@email.com", "Segura321", "42999888",
//				TipoDeCuenta.CUENTA_CORRIENTE, "5678", 16489.21));
//
//		for (Usuario usuario : usuarios) {
//			Usuario.AgregarUsuario(usuario);
//			if (usuario instanceof Cliente) {
//				Cuenta.SolicitarTarjetaDebito((Cliente) usuario);
//			}
//		}
		
		Cliente juan = new Cliente("Juan", "Pérez", "juanp89", "juan.perez@email.com", "Clave123!", "38444555",
	            TipoDeCuenta.CAJA_AHORRO, "1234", 350000.64);
	    
	    Cliente maria = new Cliente("María", "Gómez", "mariag", "maria.gomez@email.com", "Password987", "40111222",
	            TipoDeCuenta.CUENTA_CORRIENTE, "4321", 87345.01);
	    
	    Cliente lucas = new Cliente("Lucas", "Rodríguez", "lucas_rod", "lucas.r@email.com", "Admin2026*", "35666777",
	            TipoDeCuenta.CAJA_AHORRO, "9876", 826789.00);
	    
	    Cliente ana = new Cliente("Ana", "Martínez", "anamart", "ana.mtz@email.com", "Segura321", "42999888",
	            TipoDeCuenta.CUENTA_CORRIENTE, "5678", 16489.21);

	    juan.getCuenta().AgregarServicio(new Servicio(LocalDate.of(2026, 7, 10), "Luz Eléctrica", 4500.50));
	    juan.getCuenta().AgregarServicio(new Servicio(LocalDate.of(2026, 7, 5), "Internet 300MB", 5800.00));

	    // Servicios de María (Mismos servicios pero distintos precios/vencimientos + Netflix)
	    maria.getCuenta().AgregarServicio(new Servicio(LocalDate.of(2026, 7, 12), "Luz Eléctrica", 6100.00));
	    maria.getCuenta().AgregarServicio(new Servicio(LocalDate.of(2026, 7, 8), "Internet 300MB", 4900.00));
	    maria.getCuenta().AgregarServicio(new Servicio(LocalDate.of(2026, 7, 22), "Suscripción Netflix", 1200.90));

	    // Servicios de Lucas (Tiene Gas y un seguro alto)
	    lucas.getCuenta().AgregarServicio(new Servicio(LocalDate.of(2026, 7, 15), "Gas Natural", 3200.25));
	    lucas.getCuenta().AgregarServicio(new Servicio(LocalDate.of(2026, 7, 28), "Seguro del Hogar", 7500.00));

	    // Servicios de Ana (Tiene un combo completo pero ajustado a su presupuesto)
	    ana.getCuenta().AgregarServicio(new Servicio(LocalDate.of(2026, 7, 10), "Luz Eléctrica", 3800.00));
	    ana.getCuenta().AgregarServicio(new Servicio(LocalDate.of(2026, 7, 15), "Agua Corriente", 1800.00));
	    ana.getCuenta().AgregarServicio(new Servicio(LocalDate.of(2026, 7, 5), "Internet 100MB", 3500.00));


	    usuarios.add(juan);
	    usuarios.add(maria);
	    usuarios.add(lucas);
	    usuarios.add(ana);
		
	}

	private static String ValidarDni() {

		String dni = "";
		do {
			dni = validarNumero("Ingrese su DNI:");

			if (dni.length() > 8 || dni.length() < 8) {
				JOptionPane.showMessageDialog(null, "El DNI ingresado es invalido");
			}

		} while (dni.length() > 8 || dni.length() < 8);

		return dni;
	};

	private static String validarNumero(String mensaje) {
		String input;
		boolean flag;
		do {
			flag = true;
			input = JOptionPane.showInputDialog(mensaje);
			if (input.trim().isEmpty()) {
				input = JOptionPane.showInputDialog("No puede estar vacío, " + mensaje);
				flag = false;
			} else {
				for (int i = 0; i < input.length(); i++) {
					if (!Character.isDigit(input.charAt(i))) {
						JOptionPane.showMessageDialog(null, "Solo puedes ingresar números");
						flag = false;
						break;
					}
				}
			}

		} while (!flag);

		return input;
	}
//
//	private static String validarTexto(String mensaje) {
//		String input;
//		boolean flag;
//		do {
//			flag = true;
//			input = JOptionPane.showInputDialog(mensaje);
//			if (input.trim().isEmpty()) {
//				input = JOptionPane.showInputDialog("No puede estar vacío, " + mensaje);
//				flag = false;
//			} else {
//				for (int i = 0; i < input.length(); i++) {
//					if (Character.isDigit(input.charAt(i))) {
//						JOptionPane.showMessageDialog(null, "Solo puede ingresar un texto");
//						flag = false;
//						break;
//					}
//				}
//			}
//
//		} while (!flag);
//
//		return input;
//	}

}
