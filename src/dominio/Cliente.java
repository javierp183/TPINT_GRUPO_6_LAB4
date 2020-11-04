package dominio;

public class Cliente {
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private String Nacionalidad;
	private String CorreoElectronico;
	private String Telefono;
	private String Usuario;
	private String Password;
	
	public Cliente()
	{
		
	}
	
	public Cliente(String nombre, String apellido, String sexo, String nacionalidad, String correoElectronico,
			String telefono, String usuario, String password) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Sexo = sexo;
		Nacionalidad = nacionalidad;
		CorreoElectronico = correoElectronico;
		Telefono = telefono;
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
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public String getCorreoElectronico() {
		return CorreoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
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
		return "Cliente [Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo=" + Sexo + ", Nacionalidad="
				+ Nacionalidad + ", CorreoElectronico=" + CorreoElectronico + ", Telefono=" + Telefono + ", Usuario="
				+ Usuario + ", Password=" + Password + "]";
	}
	
	
	

}
