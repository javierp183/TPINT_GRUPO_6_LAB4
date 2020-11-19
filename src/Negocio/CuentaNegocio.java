package Negocio;

import java.util.List;

import dominio.Cuenta;

public interface CuentaNegocio {
	public Boolean Insert(Cuenta cuenta);
	public Boolean Modify(Cuenta cuenta, int IdCuenta);
	public Boolean Delete(Cuenta cuenta);
	public List<Cuenta> ReadAll();
	public int contar(int dnicuenta);
}
