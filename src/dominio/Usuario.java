package dominio;

public class Usuario {
	private String Nombre;
	private String Apellido;
	private int DNI;
	private String Usuario;
	private String Password;
	
	
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
	
	
	@Override
	public String toString() {
		return "Usuario [Nombre=" + Nombre + ", Apellido=" + Apellido + ", DNI=" + DNI + ", Usuario=" + Usuario
				+ ", Password=" + Password + "]";
	}
	
	
	
	

}
