package Negocio;

import java.util.List;

import dominio.Prestamo;

public interface PrestamoNegocio {
	public boolean insert(Prestamo prestamo);
	public boolean delete(Prestamo prestamo_a_eliminar);
	public boolean modify(Prestamo p);
	public List<Prestamo> readAll();

}