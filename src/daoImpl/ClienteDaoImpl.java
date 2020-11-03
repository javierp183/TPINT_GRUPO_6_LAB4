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
	private static final String insert = "INSERT INTO Clientes(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM Clientes WHERE dni = ?";
	private static final String readall = "SELECT * FROM Clientes";
	private static final String update = "UPDATE Clientes SET dni = ?, nombre = ?, apellido = ? where Dni = ?";
	
	public boolean insert(Cliente cliente)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, cliente.getDni());
			statement.setString(2, cliente.getNombre());
			statement.setString(3, cliente.getApellido());
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
			statement.setString(1, cliente_a_eliminar.getDni());
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
	
	public boolean modify(Cliente p) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, p.getDni());
			statement.setString(2, p.getNombre());
			statement.setString(3, p.getApellido());
			statement.setString(4, p.getDni());
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
		String dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Cliente(dni, nombre, apellido);
	}

}