package Negocio;

import java.util.List;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import dominio.Cliente;

public interface ClienteNegocio {
	public boolean insert(Cliente cliente);
	public boolean delete(Cliente cliente_a_eliminar);
	public boolean modify(Cliente c);
	public List<Cliente> readAll();
	public Cliente getClientePorMail(String emailWeb, String passWeb);
	public Cliente getClientePorDNI(String usuario);
	public Cliente getClientePorUsuario(int dni);
}