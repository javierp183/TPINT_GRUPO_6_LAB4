package dominio;

public class Usuario {
	private int Dni;
	private String Nombre;
	private String Apellido;
	private String Usuario;
	private String Password;
	private int estado;
	private int TipoUsuario;
	
	
	public Usuario(int dni, String nombre, String apellido, String usuario, String password, int estado,
			int tipoUsuario) {
		super();
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
		Usuario = usuario;
		Password = password;
		this.estado = estado;
		TipoUsuario = tipoUsuario;
	}
	
	
	public Usuario() {
		super();
	}


	public int getDni() {
		return Dni;
	}
	public void setDni(int dni) {
		Dni = dni;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [Dni=" + Dni + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Usuario=" + Usuario
				+ ", Password=" + Password + ", estado=" + estado + ", TipoUsuario=" + TipoUsuario + "]";
	}
	
	


}
