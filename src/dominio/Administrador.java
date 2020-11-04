package dominio;

public class Administrador {
	private String Nombre;
	private String Apellido;
	private int DNI;
	private String Usuario;
	private String Password;
	
	public Administrador()
	{
		
	}
	
	public Administrador(String nombre, String apellido, int dNI, String usuario, String password) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		DNI = dNI;
		Usuario = usuario;
		Password = password;
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
		return "Administrador [Nombre=" + Nombre + ", Apellido=" + Apellido + ", DNI=" + DNI + ", Usuario=" + Usuario
				+ ", Password=" + Password + "]";
	}
	
	

}
