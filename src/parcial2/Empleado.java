package parcial2;

import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Empleado extends Usuario {

	public Empleado(String nombre, String apellido, String username, String email, String contrasena, String dni) {
		super(nombre, apellido, username, email, contrasena, dni);
	}

	public void eliminarCliente(Usuario cliente) {
		for (int i = 0; i < Usuario.listaUsuarios.size(); i++) {
			if (Usuario.listaUsuarios.get(i) instanceof Cliente && getUsuarioPorDni(cliente.getDni()) != null) {
				Usuario.listaUsuarios.remove(i);
				break;
			}
		}
	}

	public Usuario getUsuarioPorDni(String dni) {
		Usuario usuario = Usuario.listaUsuarios.stream().filter(user -> user.getDni().equals(dni)).findFirst()
				.orElse(null);
		;

		return usuario;
	}
	
	public LinkedList<Usuario> getListaClientes(){
		return Usuario.listaUsuarios.stream().filter(cliente -> cliente instanceof Cliente)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	public void MostrarListaClientes() {
		
		LinkedList<Usuario> listaClientes = getListaClientes();
		
		String texto = "";

		for (Usuario usuario : listaClientes) {
			texto += usuario.MostrarDatos() + "\n";
		}

		JOptionPane.showMessageDialog(null,texto);
	}
}
