package Negocio;

import java.util.List;

import dominio.Usuario;

public interface UsuarioNegocio {
	public boolean insert(Usuario usuario);
	public boolean delete(Usuario usuario_a_eliminar);
	public boolean modify(Usuario u);
	public List<Usuario> readAll();
	public Usuario search(Usuario usuario);
}