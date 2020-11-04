package dominio;

public class Prestamo {
	private int idCliente;
	private String Fecha;
	private float Importe;
	private int PlazoMeses;
	private float MontoMes;
	private int Cuotas;
	
	public Prestamo()
	{
		
	}
	
	public Prestamo(int idCliente, String fecha, float importe, int plazoMeses, float montoMes, int cuotas) {
		super();
		this.idCliente = idCliente;
		Fecha = fecha;
		Importe = importe;
		PlazoMeses = plazoMeses;
		MontoMes = montoMes;
		Cuotas = cuotas;
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
	public float getImporte() {
		return Importe;
	}
	public void setImporte(float importe) {
		Importe = importe;
	}
	public int getPlazoMeses() {
		return PlazoMeses;
	}
	public void setPlazoMeses(int plazoMeses) {
		PlazoMeses = plazoMeses;
	}
	public float getMontoMes() {
		return MontoMes;
	}
	public void setMontoMes(float montoMes) {
		MontoMes = montoMes;
	}
	public int getCuotas() {
		return Cuotas;
	}
	public void setCuotas(int cuotas) {
		Cuotas = cuotas;
	}
	
	
	@Override
	public String toString() {
		return "Prestamo [idCliente=" + idCliente + ", Fecha=" + Fecha + ", Importe=" + Importe + ", PlazoMeses="
				+ PlazoMeses + ", MontoMes=" + MontoMes + ", Cuotas=" + Cuotas + "]";
	}
	
	
	
	

}
