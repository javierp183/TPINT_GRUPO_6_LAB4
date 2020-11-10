package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dominio.Cliente;
import dao.ClienteDao;

public class ClienteDaoImpl implements ClienteDao
{
	private static final String insert = "INSERT INTO clientes(dni, usuario, cuil, nombre, apellido, sexo, nacionalidad, fechanac, direccion, localidad, provincia, correo, telefono, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM clientes WHERE dni = ?";
	private static final String readall = "SELECT * FROM clientes";
	private static final String update = "UPDATE clientes SET dni = ?, usuario = ?, cuil = ?, nombre = ?, apellido = ?, sexo = ?, nacionalidad = ?, fechanac = ?, direccion = ?, localidad = ?, provincia = ?, correo = ?, telefono = ?, password = ?, where Dni = ?";
	private static final String Provincia = null;

	
	public boolean insert(Cliente cliente)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, cliente.getDni());
			statement.setString(2, cliente.getUsuario());
			statement.setString(3, cliente.getCuil());
			statement.setString(4, cliente.getNombre());
			statement.setString(5, cliente.getApellido());
			statement.setString(6, cliente.getSexo());
			statement.setString(7, cliente.getNacionalidad());
			statement.setString(8, cliente.getFechaNac());
			statement.setString(9, cliente.getDireccion());
			statement.setString(10, cliente.getLocalidad());
			statement.setString(11, cliente.getProvincia());
			statement.setString(12, cliente.getCorreoElectronico());
			statement.setString(13, cliente.getTelefono());
			statement.setString(14, cliente.getPassword());
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
	
	public boolean delete(Cliente cliente_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, cliente_a_eliminar.getDni());
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
	
	public boolean modify(Cliente cliente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setInt(1, cliente.getDni());
			statement.setString(2, cliente.getUsuario());
			statement.setString(3, cliente.getCuil());
			statement.setString(4, cliente.getNombre());
			statement.setString(5, cliente.getApellido());
			statement.setString(6, cliente.getSexo());
			statement.setString(7, cliente.getNacionalidad());
			statement.setString(8, cliente.getFechaNac());
			statement.setString(9, cliente.getDireccion());
			statement.setString(10, cliente.getLocalidad());
			statement.setString(11, cliente.getProvincia());
			statement.setString(12, cliente.getCorreoElectronico());
			statement.setString(13, cliente.getTelefono());
			statement.setString(14, cliente.getPassword());
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
	public Cliente getClientePorMail(String emailWeb, String passWeb) {
		PreparedStatement statement = null;
		Connection connection = Conexion.getConexion().getSQLConexion();
		ResultSet resultSet; //Guarda el resultado de la query
		try {
			// Esta variable la inicialize para que no tire error, pero hay que ver.
			String readByMail = null;
			
			connection.prepareStatement(readByMail);
			statement.setString(1, emailWeb);
			statement.setString(2, passWeb);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				return getCliente(resultSet);
			}
			
		} catch (Exception e) {
			return new Cliente();
		}
		
		return new Cliente();
			
	}

	public List<Cliente> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				clientes.add(getCliente(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return clientes;
	}
	
	private Cliente getCliente(ResultSet resultSet) throws SQLException
	{
		
		String Nombre = resultSet.getString("Nombre");
		String Apellido = resultSet.getString("Apellido");
		String Sexo = resultSet.getString("Sexo");
		String Nacionalidad = resultSet.getString("Nacionalidad");
		String CorreoElectronico = resultSet.getString("CorreoElectronico");
		String Telefono = resultSet.getString("Telefono");
		String Usuario = resultSet.getString("Usuario");
		String Password = resultSet.getString("Password");
		String Cuil = resultSet.getString("Cuil");
		int Dni = Integer.parseInt(resultSet.getString("dni"));
		String FechaNac = resultSet.getString("FechaNac");
		String Localidad = resultSet.getString("Localidad");
		String Provincia = resultSet.getString("Provincia");
		String Direccion = resultSet.getString("Direccion");
		
		return new Cliente(Nombre, Apellido, Sexo, Nacionalidad, CorreoElectronico, Telefono, Usuario, Password, Cuil, Dni, FechaNac, Localidad, Provincia, Direccion);
		
	}

}