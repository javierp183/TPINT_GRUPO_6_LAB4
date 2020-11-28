package dominio;

import java.sql.Date;
import java.time.LocalDateTime;

public class Prestamo {
	private int IdPrestamo;
	private int DniCliente;
	private float MontoTotal;
	private String Cbu;
	private LocalDateTime Fecha;
	private int Estado;
	private float Pagoxmes;
	private int NumCuotas;
	private float MontoRestante;
	
	public Prestamo()
	{
		super();
		
	}
	
	

	public Prestamo(int idPrestamo, int dniCliente, float montoTotal, String cbu, LocalDateTime fecha, int estado,
			float pagoxmes, int numCuotas, float montoRestante) {
		super();
		IdPrestamo = idPrestamo;
		DniCliente = dniCliente;
		MontoTotal = montoTotal;
		Cbu = cbu;
		Fecha = fecha;
		Estado = estado;
		Pagoxmes = pagoxmes;
		NumCuotas = numCuotas;
		MontoRestante = montoRestante;
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

	public LocalDateTime getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		Fecha = fecha;
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



	@Override
	public String toString() {
		return "Prestamo [IdPrestamo=" + IdPrestamo + ", DniCliente=" + DniCliente + ", MontoTotal=" + MontoTotal
				+ ", Cbu=" + Cbu + ", Fecha=" + Fecha + ", Estado=" + Estado + ", Pagoxmes=" + Pagoxmes + ", NumCuotas="
				+ NumCuotas + ", MontoRestante=" + MontoRestante + "]";
	}



}
