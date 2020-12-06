package dao;

import java.util.List;

import dominio.Prestamo;


public interface PrestamoDao {
	public Boolean modify(Prestamo prestamo);
	public Boolean delete(Prestamo prestamo);
	boolean insert(Prestamo prestamo);
	Prestamo getPrestamoPorID(int idprestamo);
	public List<Prestamo> readAll();
	public List<Prestamo> readAllUnapproved();
}