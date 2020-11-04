package dominio;

public class Cuenta {
	private int TipoCuenta;
	private float Saldo;
	private int idCliente;
	private String Fecha;
	private int NumCuenta;
	
	public Cuenta()
	{
		
	}
	
	public Cuenta(int tipoCuenta, float saldo, int idCliente, String fecha, int numCuenta) {
		super();
		TipoCuenta = tipoCuenta;
		Saldo = saldo;
		this.idCliente = idCliente;
		Fecha = fecha;
		NumCuenta = numCuenta;
	}

	public int getTipoCuenta() {
		return TipoCuenta;
	}
	public void setTipoCuenta(int tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}
	public float getSaldo() {
		return Saldo;
	}
	public void setSaldo(float saldo) {
		Saldo = saldo;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public int getNumCuenta() {
		return NumCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		NumCuenta = numCuenta;
	}
	
	@Override
	public String toString() {
		return "Cuenta [TipoCuenta=" + TipoCuenta + ", Saldo=" + Saldo + ", idCliente=" + idCliente + ", Fecha=" + Fecha
				+ ", NumCuenta=" + NumCuenta + "]";
	}
	
	
	
	

}
