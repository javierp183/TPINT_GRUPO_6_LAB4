package dominio;

import java.time.LocalDateTime;

public class Movimiento {
	private int Dni;
	private String Usuario;
	private String Fechanac;
	private String TipoMovimiento;
	private String Descripcion;
	private LocalDateTime Fecha;
	
	public Movimiento()
	{
		super();
		Fechanac = Fecha.toString();
	}
	
	public Movimiento(int dni, String usuario, String fechanac, String tipoMovimiento, String descripcion) {
		super();
		Dni = dni;
		Usuario = usuario;
		Fechanac = fechanac;
		TipoMovimiento = tipoMovimiento;
		Descripcion = descripcion;
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
		return "Movimiento [Dni=" + Dni + ", Usuario=" + Usuario + ", Fechanac=" + Fechanac + ", TipoMovimiento="
				+ TipoMovimiento + ", Descripcion=" + Descripcion + "]";
	}
	
	
	
	

}
