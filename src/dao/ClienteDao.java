package dao;

import java.util.List;

import dominio.Cliente;

public interface ClienteDao {
	public boolean insert(Cliente cliente);
	public boolean delete(Cliente cliente_a_eliminar);
	public boolean modify(Cliente c);
	public List<Cliente> readAll();
	public Cliente getClientePorMail(String emailWeb, String passWeb);
	Cliente getTipoUsuario(String usuario);
	List<Cliente> getClientesActivos();
}