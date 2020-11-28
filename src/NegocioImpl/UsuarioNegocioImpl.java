package NegocioImpl;

import java.util.List;
import dominio.Usuario;
import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;

public class UsuarioNegocioImpl implements UsuarioDao
{
	private UsuarioDao udao = new UsuarioDaoImpl();
	
	public UsuarioNegocioImpl() {
		this.udao = new UsuarioDaoImpl();
	}

	@Override
	public boolean insert(Usuario usuario) {
		return udao.insert(usuario);
	}

	@Override
	public boolean delete(Usuario usuario_a_eliminar) {
		return udao.delete(usuario_a_eliminar);
	}

	@Override
	public boolean modify(Usuario u) {
		return udao.modify(u);
	}

	@Override
	public List<Usuario> readAll() {
		return (List<Usuario>)udao.readAll();
	}

	@Override
	public Usuario getClientePorMail(String emailWeb, String passWeb) {
		return udao.getClientePorMail(emailWeb, passWeb);
	}

	@Override
	public Usuario getTipoUsuario(String usuario) {
		return udao.getTipoUsuario(usuario);
	}
	
	
	
}