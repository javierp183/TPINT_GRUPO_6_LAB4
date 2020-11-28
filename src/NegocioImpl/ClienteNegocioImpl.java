package NegocioImpl;
import java.util.List;

import dominio.Cliente;
import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;

public class ClienteNegocioImpl implements ClienteDao
{

	private ClienteDao cdao = new ClienteDaoImpl();
	
	public ClienteNegocioImpl() {
		this.cdao = new ClienteDaoImpl();
	}

	
	
	@Override
	public boolean insert(Cliente cliente) {
		return cdao.insert(cliente);
	}

	@Override
	public boolean delete(Cliente cliente_a_eliminar) {
		return cdao.delete(cliente_a_eliminar);
	}


	@Override
	public boolean modify(Cliente c) {
		return cdao.modify(c);
	}


	@Override
	public List<Cliente> readAll() {
		return (List<Cliente>)cdao.readAll();
	}


	@Override
	public Cliente getClientePorMail(String emailWeb, String passWeb) {
		return cdao.getClientePorMail(emailWeb, passWeb);
	}



	@Override
	public Cliente getTipoUsuario(String usuario) {
		return cdao.getTipoUsuario(usuario);
	}


}