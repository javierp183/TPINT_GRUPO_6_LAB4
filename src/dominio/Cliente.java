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
	private String Cuil;
	private int Dni;
	private String FechaNac;
	private String Localidad;
	private String Provincia;
	private String Direccion;
	private int TipoUsuario;
	private int Estado;
	
	
	public Cliente()
	{
		super();
		CorreoElectronico = "Sin correo";
		Password = "Sin Password";
		Estado = 1;
		TipoUsuario = 1;
	}


	public Cliente(String nombre, String apellido, String sexo, String nacionalidad, String correoElectronico,
			String telefono, String usuario, String password, String cuil, int dni, String fechaNac, String localidad,
			String provincia, String direccion, int tipoUsuario, int estado) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Sexo = sexo;
		Nacionalidad = nacionalidad;
		CorreoElectronico = correoElectronico;
		Telefono = telefono;
		Usuario = usuario;
		Password = password;
		Cuil = cuil;
		Dni = dni;
		FechaNac = fechaNac;
		Localidad = localidad;
		Provincia = provincia;
		Direccion = direccion;
		TipoUsuario = tipoUsuario;
		Estado = estado;
	}




	// Getters and Setters
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


	public String getCuil() {
		return Cuil;
	}


	public void setCuil(String cuil) {
		Cuil = cuil;
	}


	public int getDni() {
		return Dni;
	}


	public void setDni(int dni) {
		Dni = dni;
	}


	public String getFechaNac() {
		return FechaNac;
	}


	public void setFechaNac(String fechaNac) {
		FechaNac = fechaNac;
	}


	public String getLocalidad() {
		return Localidad;
	}


	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}


	public String getProvincia() {
		return Provincia;
	}


	public void setProvincia(String provincia) {
		Provincia = provincia;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
	public int getTipoUsuario() {
		return TipoUsuario;
	}


	public void setTipoUsuario(int tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}


	public int getEstado() {
		return Estado;
	}


	public void setEstado(int estado) {
		Estado = estado;
	}


	@Override
	public String toString() {
		return "Cliente [Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo=" + Sexo + ", Nacionalidad="
				+ Nacionalidad + ", CorreoElectronico=" + CorreoElectronico + ", Telefono=" + Telefono + ", Usuario="
				+ Usuario + ", Password=" + Password + ", Cuil=" + Cuil + ", Dni=" + Dni + ", FechaNac=" + FechaNac
				+ ", Localidad=" + Localidad + ", Provincia=" + Provincia + ", Direccion=" + Direccion
				+ ", TipoUsuario=" + TipoUsuario + ", Estado=" + Estado + "]";
	}
	

}
