package Negocio;

import java.util.List;

import dominio.Movimiento;

public interface MovimientoNegocio {
	public Boolean Insert(Movimiento movimiento);
	public Boolean Modify(Movimiento movimiento);
	public Boolean Delete(Movimiento movimiento);
	public List<Movimiento> ReadAll();
	public int contar(int dnicuenta);
	public Movimiento Search(String Cbu);
}
