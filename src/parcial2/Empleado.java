package parcial2;

public class Empleado extends Usuario {

	public void eliminarCliente(String dni) {
		for (int i = 0; i < Usuario.listaUsuarios.size(); i++) {
			if (Usuario.listaUsuarios.get(i) instanceof Cliente && Usuario.listaUsuarios.get(i).getDni().equals(dni)) {
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

}
