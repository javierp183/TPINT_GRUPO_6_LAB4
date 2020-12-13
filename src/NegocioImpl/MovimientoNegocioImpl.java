package NegocioImpl;
import java.util.List;
import dominio.Movimiento;
import dominio.Prestamo;
import dao.CuentaDao;
import dao.MovimientoDao;
import daoImpl.CuentaDaoImpl;
import daoImpl.MovimientoDaoImpl;


public class MovimientoNegocioImpl implements MovimientoDao {
	private MovimientoDaoImpl mdao = new MovimientoDaoImpl();
	
	public MovimientoNegocioImpl() {
		this.mdao = new MovimientoDaoImpl();
	}

	@Override
	public Boolean modify(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return mdao.insert(movimiento);
	}

	@Override
	public List<Movimiento> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimiento> readAllbyDni() {
		// TODO Auto-generated method stub
		return mdao.readAllbyDni();
	}

	@Override
	public Movimiento getMovimientoPorDni(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimiento> getMovimientoPorDnis(int dni) {
		// TODO Auto-generated method stub
		return mdao.getMovimientoPorDnis(dni);
	}

	@Override
	public Movimiento getMovimientoPorCuenta(String cbu) {
		// TODO Auto-generated method stub
		return mdao.getMovimientoPorCuenta(cbu);
	}

	@Override
	public List<Movimiento> getMovimientoPorCuentas(String cbu) {
		// TODO Auto-generated method stub
		return mdao.getMovimientoPorCuentas(cbu);
	}

}