package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dominio.Administrador;
import dao.AdministradorDao;

public class AdministradorDaoImpl implements AdministradorDao
{
	private static final String insert = "INSERT INTO administradores(dni, usuario, password, idtipousuario) VALUES(?, ?, ?, ?)";
	private static final String delete = "DELETE FROM administradores WHERE dni = ?";
	private static final String readall = "SELECT * FROM administradores";
	private static final String readByUser = "Select * from administradores where usuario = ? and password = ?";
	private static final String update = "UPDATE clientes SET dni = ?, usuario = ?, password = ?, idtipousuario = ?, where Dni = ?";
	private static final String Provincia = null;
	
	
	public boolean insert(Administrador administrador)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, administrador.getDNI());
			statement.setString(2, administrador.getUsuario());
			statement.setString(3, administrador.getPassword());
			statement.setInt(4, administrador.getTipoUsuario());
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
	
	public boolean delete(Administrador administrador_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, administrador_a_eliminar.getDNI());
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
	
	public boolean modify(Administrador administrador) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setInt(1, administrador.getDNI());
			statement.setString(2, administrador.getUsuario());
			statement.setString(3, administrador.getPassword());
			statement.setInt(4, administrador.getTipoUsuario());
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
	public Usuario getAdministradorPorUser(String emailWeb, String passWeb) {
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

	public List<Administrador> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Administrador> usuarios = new ArrayList<Administrador>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				usuarios.add(getAdministrador(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return usuarios;
	}
	
	private Usuario getAdministrador(ResultSet resultSet) throws SQLException
	{
		
		int Dni = resultSet.getInt("dni");
		String Usuario = resultSet.getString("usuario");
		String Password = resultSet.getString("password");
		int Estado = resultSet.getInt("estado");
		int TipoUsuario = resultSet.getInt("tipousuario");
		

		
		return new Administrador(Dni, Usuario, Password, Estado, TipoUsuario);

	}
}