package dao;

import java.util.List;

import dominio.Movimiento;
import dominio.Prestamo;

public interface MovimientoDao {
	public Boolean modify(Movimiento movimiento);
	public Boolean delete(Movimiento movimiento);
	boolean insert(Movimiento movimiento);
	public List<Movimiento> readAll();
	public List<Movimiento> readAllbyDni();
	Movimiento getMovimientoPorDni(int dni);
	List<Movimiento> getMovimientoPorDnis(int dni);

}
