package dominio;

import java.time.LocalDateTime;

public class Movimiento {
	private int Id;
	private String Cbu;
	private int Dni;
	private String Usuario;
	private String Fechanac;
	private String TipoMovimiento;
	private String Descripcion;
	private LocalDateTime Fecha;
	
	public Movimiento()
	{
		super();
		Fechanac = Fecha.now().toString();
	}
	
	public Movimiento(int id, String cbu, int dni, String usuario, String fechanac, String tipoMovimiento, String descripcion) {
		super();
		Id = id;
		Cbu = cbu;
		Dni = dni;
		Usuario = usuario;
		Fechanac = fechanac;
		TipoMovimiento = tipoMovimiento;
		Descripcion = descripcion;
	}
	
	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCbu() {
		return Cbu;
	}

	public void setCbu(String cbu) {
		Cbu = cbu;
	}

	public LocalDateTime getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		Fecha = fecha;
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
	public String getFechanac() {
		return Fechanac;
	}
	public void setFechanac(String fechanac) {
		Fechanac = fechanac;
	}
	public String getTipoMovimiento() {
		return TipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		TipoMovimiento = tipoMovimiento;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Movimiento [Id=" + Id + ", Cbu=" + Cbu + ", Dni=" + Dni + ", Usuario=" + Usuario + ", Fechanac="
				+ Fechanac + ", TipoMovimiento=" + TipoMovimiento + ", Descripcion=" + Descripcion + ", Fecha=" + Fecha
				+ "]";
	}
	
	
	

}
