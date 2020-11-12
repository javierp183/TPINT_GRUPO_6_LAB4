package dominio;

public class Cuenta {
	private int Idcuenta;
	private float Saldo;
	private String Fecha;
	private String Cuentascol;
	private String Cbu;
	private int estado;
	private int TipoCuenta;
	private int Usuario;
	
	public Cuenta()
	{
		super();
		Saldo = 10000;
	}
	
	public Cuenta(int idcuenta, float saldo, String fecha, String cuentascol, String cbu, int estado, int tipoCuenta,
			int usuario) {
		super();
		Idcuenta = idcuenta;
		Saldo = saldo;
		Fecha = fecha;
		Cuentascol = cuentascol;
		Cbu = cbu;
		this.estado = estado;
		TipoCuenta = tipoCuenta;
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
	public String getCuentascol() {
		return Cuentascol;
	}
	public void setCuentascol(String cuentascol) {
		Cuentascol = cuentascol;
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
	public int getUsuario() {
		return Usuario;
	}
	public void setUsuario(int usuario) {
		Usuario = usuario;
	}

	@Override
	public String toString() {
		return "Cuenta [Idcuenta=" + Idcuenta + ", Saldo=" + Saldo + ", Fecha=" + Fecha + ", Cuentascol=" + Cuentascol
				+ ", Cbu=" + Cbu + ", estado=" + estado + ", TipoCuenta=" + TipoCuenta + ", Usuario=" + Usuario + "]";
	}

	

}
