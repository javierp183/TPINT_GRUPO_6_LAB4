package dominio;

public class Usuario {
	private int Dni;
	private String Usuario;
	private String Password;
	private int estado;
	private int TipoUsuario;
	
	
	
	
	public Usuario()
	{
		super();
		TipoUsuario = 0;
	}




	public Usuario(int dni, String usuario, String password, int estado, int tipoUsuario) {
		super();
		Dni = dni;
		Usuario = usuario;
		Password = password;
		this.estado = estado;
		TipoUsuario = tipoUsuario;
	}


	public int getDni() {
		return Dni;
	}


	public void setDni(int dni) {
		Dni = dni;
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
		return "Usuario [Dni=" + Dni + ", Usuario=" + Usuario + ", Password=" + Password + ", estado=" + estado
				+ ", TipoUsuario=" + TipoUsuario + "]";
	}


}
