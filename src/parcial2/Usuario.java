package parcial2;

import java.util.LinkedList;

public class Usuario {
	
	protected static LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
	private String nombre;
	private String apellido;
	private String username;
	private String email;
	private String contrasena;
	private String dni;

	public Usuario() {

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
			if ((usernameOrEmail.equals(usuario.getUsername()) || usernameOrEmail.equals(usuario.getEmail())) && contrasena.equals(usuario.getContrasena())) {
				return usuario;
			}
		}
		
		return null;
	};
	
	
	
	public static void AgregarUsuario(Usuario usuario) {
		listaUsuarios.add(usuario);
	};
	
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

}
