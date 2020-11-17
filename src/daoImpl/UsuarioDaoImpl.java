package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dominio.Usuario;
import dao.UsuarioDao;

public class UsuarioDaoImpl implements UsuarioDao
{
	private static final String insert = "INSERT INTO usuarios(dni, usuario, password, estado, idtipousuario) VALUES(?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM usuarios WHERE dni = ?";
	private static final String readall = "SELECT * FROM usuarios";
	private static final String readByUser = "Select * from usuarios where usuario = ? and password = ?";
	private static final String update = "UPDATE usuarios SET dni = ?, usuario = ?, password = ?, estado = ?, idtipousuario = ?, where Dni = ?";
	
	@Override
	public boolean insert(Usuario usuario)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, usuario.getDni());
			statement.setString(2, usuario.getUsuario());
			statement.setString(3, usuario.getPassword());
			statement.setInt(4, usuario.getEstado());
			statement.setInt(5, usuario.getTipoUsuario());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	@Override
	public boolean delete(Usuario usuario_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, usuario_a_eliminar.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	@Override
	public boolean modify(Usuario usuario) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setInt(1, usuario.getDni());
			statement.setString(2, usuario.getUsuario());
			statement.setString(3, usuario.getPassword());
			statement.setInt(4, usuario.getEstado());
			statement.setInt(5, usuario.getTipoUsuario());
			statement.setInt(6, usuario.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}

	///Busca el cliente por mail y contrase�a.
	///Si el cliente no existe, por constructor
	///Genera un cliente con "Sin Correo" y "Sin password"
	///Para utilizarlo en el login.
	@Override
	public Usuario getClientePorMail(String emailWeb, String passWeb) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultSet; //Guarda el resultado de la query
		try {
			// Esta variable la inicialize para que no tire error, pero hay que ver.
			//String readByMail = null;
			
			statement = conexion.getSQLConexion().prepareStatement(readByUser);
			statement.setString(1, emailWeb);
			statement.setString(2, passWeb);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {

				return getUsuario(resultSet);
			}
			
		} catch (Exception e) {
			return new Usuario();
		}
		
		return new Usuario();
			
	}

	public List<Usuario> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				usuarios.add(getUsuario(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return usuarios;
	}
	
	private Usuario getUsuario(ResultSet resultSet) throws SQLException
	{
		
		int Dni = resultSet.getInt("dni");
		String Usuario = resultSet.getString("usuario");
		String Password = resultSet.getString("password");
		int Estado = resultSet.getInt("estado");
		int TipoUsuario = resultSet.getInt("tipousuario");
		

		
		return new Usuario(Dni, Usuario, Password, Estado, TipoUsuario);

	}
}