package dominio;

public class Administrador {
	private int DNI;
	private String Usuario;
	private String Password;
	private int TipoUsuario;
	
	public Administrador()
	{
		super();
	}
	

	public Administrador(int dNI, String usuario, String password, int tipoUsuario) {
		super();
		DNI = dNI;
		Usuario = usuario;
		Password = password;
		TipoUsuario = tipoUsuario;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
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

	public int getTipoUsuario() {
		return TipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Administrador [DNI=" + DNI + ", Usuario=" + Usuario + ", Password=" + Password + ", TipoUsuario="
				+ TipoUsuario + "]";
	}


}
