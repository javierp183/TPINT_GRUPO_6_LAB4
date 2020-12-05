package dao;

import java.util.List;

import dominio.Cuenta;

public interface CuentaDao {
	public Boolean Insert(Cuenta cuenta);
	public Boolean Modify(Cuenta cuenta);
	public Boolean Delete(Cuenta cuenta);
	public List<Cuenta> ReadAll();
	public int contarCuenta(int dnicuenta);
	public Cuenta Search(String Cbu);
	List<Cuenta> Readallunassigned();
	List<Cuenta> ListarCuentasPorDNI(int dni);
}
