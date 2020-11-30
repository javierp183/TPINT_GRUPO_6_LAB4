package NegocioImpl;
import java.util.List;
import dominio.Cuenta;
import dao.CuentaDao;
import daoImpl.CuentaDaoImpl;


public class CuentaNegocioImpl implements CuentaDao
{
	private CuentaDao cdao = new CuentaDaoImpl();
	
	public CuentaNegocioImpl() {
		this.cdao = new CuentaDaoImpl();
	}

	@Override
	public Boolean Insert(Cuenta cuenta) {
		return cdao.Insert(cuenta);
	}

	@Override
	public Boolean Modify(Cuenta cuenta) {
		return cdao.Modify(cuenta);
	}

	@Override
	public Boolean Delete(Cuenta cuenta) {
		return cdao.Delete(cuenta);
	}

	@Override
	public List<Cuenta> ReadAll() {
		return (List<Cuenta>)cdao.ReadAll();
	}

	@Override
	public int contarCuenta(int dnicuenta) {
		return cdao.contarCuenta(dnicuenta);
	}

	@Override
	public Cuenta Search(String Cbu) {
		return cdao.Search(Cbu);
	}

	@Override
	public List<Cuenta> Readallunassigned() {
		// TODO Auto-generated method stub
		return cdao.Readallunassigned();
	}

}