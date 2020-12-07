package NegocioImpl;


import java.util.List;

import dominio.Prestamo;
import dao.PrestamoDao;
import daoImpl.PrestamoDaoImpl;


public class PrestamoNegocioImpl implements PrestamoDao
{	
	private PrestamoDao pdao = new PrestamoDaoImpl();

	@Override
	public Boolean modify(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return pdao.modify(prestamo);
	}

	@Override
	public Boolean delete(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return pdao.delete(prestamo);
	}

	@Override
	public boolean insert(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return pdao.insert(prestamo);
	}

	@Override
	public Prestamo getPrestamoPorID(int idprestamo) {
		// TODO Auto-generated method stub
		return pdao.getPrestamoPorID(idprestamo);
	}

	@Override
	public List<Prestamo> readAll() {
		// TODO Auto-generated method stub
		return pdao.readAll();
	}

	@Override
	public List<Prestamo> readAllUnapproved() {
		// TODO Auto-generated method stub
		return pdao.readAllUnapproved();
	}

	@Override
	public Prestamo getPrestamoID(int idprestamo) {
		// TODO Auto-generated method stub
		return pdao.getPrestamoID(idprestamo);
	}

	@Override
	public List<Prestamo> readAllbyDNI(int dni) {
		// TODO Auto-generated method stub
		return pdao.readAllbyDNI(dni);
	}

}