package dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Prestamo {
	private int IdPrestamo;
	private int DniCliente;
	private float MontoTotal;
	private String Cbu;
	private String Fecha;
	private LocalDate FechaAhora;
	private int Estado;
	private float Pagoxmes;
	private float Montopormes;
	private int NumCuotas;
	private float MontoRestante;
	private String Nombre;
	private String Apellido;
	
	public Prestamo()
	{
		super();
		Fecha = FechaAhora.now().toString();
	}
	
	

	public Prestamo(int idPrestamo, int dniCliente, float montoTotal, String cbu, String fecha, int estado,
			float pagoxmes, float montopormes, int numCuotas, float montoRestante, String nombre, String apellido) {
		super();
		IdPrestamo = idPrestamo;
		DniCliente = dniCliente;
		MontoTotal = montoTotal;
		Cbu = cbu;
		Fecha = fecha;
		Estado = estado;
		Pagoxmes = pagoxmes;
		Montopormes = montopormes;
		NumCuotas = numCuotas;
		MontoRestante = montoRestante;
		Nombre = nombre;
		Apellido = apellido;
	}



	public int getIdPrestamo() {
		return IdPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		IdPrestamo = idPrestamo;
	}

	public int getDniCliente() {
		return DniCliente;
	}

	public void setDniCliente(int dniCliente) {
		DniCliente = dniCliente;
	}

	public float getMontoTotal() {
		return MontoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		MontoTotal = montoTotal;
	}

	public String getCbu() {
		return Cbu;
	}

	public void setCbu(String cbu) {
		Cbu = cbu;
	}


	public String getFecha() {
		return Fecha;
	}



	public void setFecha(String fecha) {
		Fecha = fecha;
	}



	public LocalDate getFechaAhora() {
		return FechaAhora;
	}



	public void setFechaAhora(LocalDate fechaAhora) {
		FechaAhora = fechaAhora;
	}



	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	public float getPagoxmes() {
		return Pagoxmes;
	}

	public void setPagoxmes(float pagoxmes) {
		Pagoxmes = pagoxmes;
	}
	
	

	public float getMontopormes() {
		return Montopormes;
	}



	public void setMontopormes(float montopormes) {
		Montopormes = montopormes;
	}



	public int getNumCuotas() {
		return NumCuotas;
	}

	public void setNumCuotas(int numCuotas) {
		NumCuotas = numCuotas;
	}

	public float getMontoRestante() {
		return MontoRestante;
	}

	public void setMontoRestante(float montoRestante) {
		MontoRestante = montoRestante;
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



	@Override
	public String toString() {
		return "Prestamo [IdPrestamo=" + IdPrestamo + ", DniCliente=" + DniCliente + ", MontoTotal=" + MontoTotal
				+ ", Cbu=" + Cbu + ", Fecha=" + Fecha + ", FechaAhora=" + FechaAhora + ", Estado=" + Estado
				+ ", Pagoxmes=" + Pagoxmes + ", Montopormes=" + Montopormes + ", NumCuotas=" + NumCuotas
				+ ", MontoRestante=" + MontoRestante + ", Nombre=" + Nombre + ", Apellido=" + Apellido + "]";
	}










}
