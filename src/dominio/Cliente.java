package dominio;

public class Cliente {
	private int Dni;
	private String Cuil;
	private String Nombre;
	private String Apellido;
	private String Sexo;
	private String Nacionalidad;
	private String FechaNac;
	private String Direccion;
	private String Localidad;
	private String Provincia;
	private String CorreoElectronico;
	private String Telefono;
	private String Usuario;
	private String Password;
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
	
	


	public Cliente(int dni, String cuil, String nombre, String apellido, String sexo, String nacionalidad,
			String fechaNac, String direccion, String localidad, String provincia, String correoElectronico,
			String telefono, String usuario, String password, int tipoUsuario, int estado) {
		super();
		Dni = dni;
		Cuil = cuil;
		Nombre = nombre;
		Apellido = apellido;
		Sexo = sexo;
		Nacionalidad = nacionalidad;
		FechaNac = fechaNac;
		Direccion = direccion;
		Localidad = localidad;
		Provincia = provincia;
		CorreoElectronico = correoElectronico;
		Telefono = telefono;
		Usuario = usuario;
		Password = password;
		TipoUsuario = tipoUsuario;
		Estado = estado;
	}




	public int getDni() {
		return Dni;
	}


	public void setDni(int dni) {
		Dni = dni;
	}


	public String getCuil() {
		return Cuil;
	}


	public void setCuil(String cuil) {
		Cuil = cuil;
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


	public String getFechaNac() {
		return FechaNac;
	}


	public void setFechaNac(String fechaNac) {
		FechaNac = fechaNac;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
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
		return "Cliente [Dni=" + Dni + ", Cuil=" + Cuil + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Sexo="
				+ Sexo + ", Nacionalidad=" + Nacionalidad + ", FechaNac=" + FechaNac + ", Direccion=" + Direccion
				+ ", Localidad=" + Localidad + ", Provincia=" + Provincia + ", CorreoElectronico=" + CorreoElectronico
				+ ", Telefono=" + Telefono + ", Usuario=" + Usuario + ", Password=" + Password + ", TipoUsuario="
				+ TipoUsuario + ", Estado=" + Estado + "]";
	}
	
	
	

}
