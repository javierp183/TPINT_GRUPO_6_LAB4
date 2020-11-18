package dominio;

import java.util.UUID;

public class Cuenta {
	private int Idcuenta;
	private float Saldo;
	private String Fecha;
	private String Cbu;
	private int estado;
	private int TipoCuenta;
	private int Dni;
	private String Usuario;
	private String uuid = UUID.randomUUID().toString();
	
	public Cuenta()
	{
		super();
		Saldo = 10000;
		estado = 1;
		//UUID asignado auto magicamente de CBU
		Cbu = uuid;
	}
	
	public Cuenta(float saldo, String fecha, String cbu, int estado, int tipoCuenta, int dni,
			String usuario) {
		super();
		Saldo = saldo;
		Fecha = fecha;
		Cbu = cbu;
		this.estado = estado;
		TipoCuenta = tipoCuenta;
		Dni = dni;
		Usuario = usuario;
	}
	
	
	
	public int getIdcuenta() {
		return Idcuenta;
	}
	public void setIdcuenta(int idcuenta) {
		Idcuenta = idcuenta;
	}
	public float getSaldo() {
		return Saldo;
	}
	public void setSaldo(float saldo) {
		Saldo = saldo;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public String getCbu() {
		return Cbu;
	}
	public void setCbu(String cbu) {
		Cbu = cbu;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getTipoCuenta() {
		return TipoCuenta;
	}
	public void setTipoCuenta(int tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public int getDni() {
		return Dni;
	}

	public void setDni(int dni) {
		Dni = dni;
	}

	@Override
	public String toString() {
		return "Cuenta [Saldo=" + Saldo + ", Fecha=" + Fecha + ", Cbu=" + Cbu + ", estado=" + estado + ", TipoCuenta="
				+ TipoCuenta + ", Dni=" + Dni + ", Usuario=" + Usuario + "]";
	}
	
	

	

}
