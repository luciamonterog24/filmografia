package servlet;

public class Usuario {
	
	private String nombre;
	private String contraseña;
	private String idUsuario;
	
	public Usuario(String nombre, String contraseña, String idUsuario) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.idUsuario = idUsuario;
	}
	
	public Usuario() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

}
