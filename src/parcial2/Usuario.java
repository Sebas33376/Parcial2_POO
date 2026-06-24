package parcial2;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Usuario {

	protected static LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
	private String nombre;
	private String apellido;
	private String username;
	private String email;
	private String contrasena;
	private String dni;

	public Usuario() {
		setNombre(validarTexto("Ingrese su nombre:"));
		setApellido(validarTexto("Ingrese su apellido:"));
		setUsername(validarTexto("Ingrese un nombre de usuario"));
		setEmail(validarEmail("Ingrese su email"));
		ValidarDni();
		setContrasena(ConfirmarContrasena());
	};

	public Usuario(String nombre, String apellido, String username, String email, String contrasena, String dni) {
		setNombre(nombre);
		setApellido(apellido);
		setUsername(username);
		setEmail(email);
		setContrasena(contrasena);
		setDni(dni);
	}

	public static Usuario Login(String usernameOrEmail, String contrasena) {
		for (Usuario usuario : listaUsuarios) {
			if ((usernameOrEmail.equals(usuario.getUsername()) || usernameOrEmail.equals(usuario.getEmail()))
					&& contrasena.equals(usuario.getContrasena())) {
				return usuario;
			}
		}
		return null;
	};

	public static void AgregarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
		JOptionPane.showInternalMessageDialog(null, "Te has registrado con éxito");
	};

	public String ConfirmarContrasena() {
		boolean flag = false;
		String contrasena1;
		String contrasena2;
		String contraValida = "";

		do {
			contrasena1 = validarContrasena("Crea una contraseña de un mínimo de 6 dígitos:");
			contrasena2 = validarContrasena("Ingresa la misma contraseña que creaste:");

			if (contrasena1.equals(contrasena2)) {
				contraValida = contrasena1;
				flag = true;
			} else {
				JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
			}

		} while (!flag);

		return contraValida;
	};

	private String validarContrasena(String mensaje) {
		String input;
		boolean flag;
		do {

			flag = true;
			input = JOptionPane.showInputDialog(mensaje);

			if (input.trim().isEmpty()) {

				input = JOptionPane.showInputDialog("No puede estar vacío, " + mensaje);
				flag = false;

			} else if (input.length() < 6) {

				JOptionPane.showMessageDialog(null, "La contraseña no puede ser menor a 6 digitos");
				flag = false;

			}

		} while (!flag);

		return input;
	}
	
	private void ValidarDni() {
		
		String dni ="";
		do {
			dni = validarNumero("Ingrese su DNI:");
			
			if (dni.length() > 8 || dni.length() < 8) {
				JOptionPane.showMessageDialog(null, "El DNI ingresado es invalido");
			}
			
		} while (dni.length() > 8 || dni.length() < 8);
		
		setDni(dni);
	};

	private String validarNumero(String mensaje) {
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

	private String validarTexto(String mensaje) {
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
					if (Character.isDigit(input.charAt(i))) {
						JOptionPane.showMessageDialog(null, "Solo puede ingresar un texto");
						flag = false;
						break;
					}
				}
			}

		} while (!flag);

		return input;
	}

	private String validarEmail(String mensaje) {
		String input;
		boolean flag;
		do {
			flag = true;
			input = JOptionPane.showInputDialog(mensaje);
			if (input.trim().isEmpty()) {
				input = JOptionPane.showInputDialog("No puede estar vacío, " + mensaje);
				flag = false;
			} else if (!input.contains("@")) {
			
					JOptionPane.showMessageDialog(null, "El email ingresado no es válido (debe contener '@').");
		            flag = false;
				
			}

		} while (!flag);

		return input;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	private void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	private void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", username=" + username + ", email=" + email
				+ ", contrasena=" + contrasena + ", dni=" + dni + "]";
	}
	


}
