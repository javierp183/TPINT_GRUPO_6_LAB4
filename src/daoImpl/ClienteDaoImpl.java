package daoImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import dominio.Cliente;
import dominio.Cuenta;
import dao.ClienteDao;

public class ClienteDaoImpl implements ClienteDao
{
	private static final String insert = "INSERT INTO clientes(dni, cuil, nombre, apellido, sexo, nacionalidad, fechanac, direccion, localidad, provincia, correo, telefono, usuario, password,  tipousuario, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE clientes SET estado = ? where Dni = ?";
	private static final String readall = "SELECT * FROM clientes";
	private static final String readByMail = "Select * from clientes where correo = ? and password = ?";
	private static final String update = "UPDATE clientes SET dni = ?, cuil = ?, nombre = ?, apellido = ?, sexo = ?, nacionalidad = ?, fechanac = ?, direccion = ?, localidad = ?, provincia = ?, correo = ?, telefono = ?, usuario = ?, password = ?, tipousuario = ?, estado = ? where Dni = ?";
	private static final String Provincia = null;
	private static final String TipoUsuarioCliente = "SELECT * from clientes where usuario = ?";
	private static final String UsuariosClienteActivo = "SELECT * from clientes where estado = 1 and tipousuario = 0";
	private static final String obtenerDni = "SELECT * from clientes where usuario = ?";
	private static final String obtenerUsuario = "SELECT * from clientes where dni = ?";
	
	private Date fecha;

	@Override
	public boolean insert(Cliente cliente)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		System.out.println("la coneccion");
		System.out.println(conexion);
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, cliente.getDni());
			statement.setString(2, cliente.getCuil());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellido());
			statement.setString(5, cliente.getSexo());
			statement.setString(6, cliente.getNacionalidad());
			statement.setString(7, cliente.getFechaNac());
			statement.setString(8, cliente.getDireccion());
			statement.setString(9, cliente.getLocalidad());
			statement.setString(10, cliente.getProvincia());
			statement.setString(11, cliente.getCorreoElectronico());
			statement.setString(12, cliente.getTelefono());
			statement.setString(13, cliente.getUsuario());
			statement.setString(14, cliente.getPassword());
			statement.setInt(15,cliente.getTipoUsuario());
			statement.setInt(16,cliente.getEstado());
			
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
	public boolean delete(Cliente cliente)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			cliente.setEstado(0);
			statement.setInt(1, cliente.getEstado());
			statement.setInt(2, cliente.getDni());
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
	public boolean modify(Cliente cliente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setInt(1, cliente.getDni());
			statement.setString(2, cliente.getCuil());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellido());
			statement.setString(5, cliente.getSexo());
			statement.setString(6, cliente.getNacionalidad());
			statement.setString(7, cliente.getFechaNac());
			statement.setString(8, cliente.getDireccion());
			statement.setString(9, cliente.getLocalidad());
			statement.setString(10, cliente.getProvincia());
			statement.setString(11, cliente.getCorreoElectronico());
			statement.setString(12, cliente.getTelefono());
			statement.setString(13, cliente.getUsuario());
			statement.setString(14, cliente.getPassword());
			statement.setInt(15, cliente.getTipoUsuario()); 
			statement.setInt(16, cliente.getEstado());
			statement.setInt(17, cliente.getDni());
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
	public Cliente getClientePorMail(String emailWeb, String passWeb) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultSet; //Guarda el resultado de la query
		try {
			// Esta variable la inicialize para que no tire error, pero hay que ver.
			//String readByMail = null;
			
			statement = conexion.getSQLConexion().prepareStatement(TipoUsuarioCliente);
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
	
	@Override
	public Cliente getTipoUsuario(String usuario)
	{		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultSet; //Guarda el resultado de la query
		try {
			// Esta variable la inicialize para que no tire error, pero hay que ver.
			//String readByMail = null;
			
			statement = conexion.getSQLConexion().prepareStatement(TipoUsuarioCliente);
			statement.setString(1, usuario);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {

				return getCliente(resultSet);
			}
			
		} catch (Exception e) {
			return new Cliente();
		}
		
		return new Cliente();
	}
	

	@Override
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
	

	@Override
	public List<Cliente> getClientesActivos()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(UsuariosClienteActivo);
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
	
	@Override
	public Cliente getClientePorDNI(String usuario)
	{		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultSet; //Guarda el resultado de la query
		try {
			// Esta variable la inicialize para que no tire error, pero hay que ver.
			//String readByMail = null;
			
			statement = conexion.getSQLConexion().prepareStatement(obtenerDni);
			statement.setString(1, usuario);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {

				return getCliente(resultSet);
			}
			
		} catch (Exception e) {
			return new Cliente();
		}
		
		return new Cliente();
	}
	
	@Override
	public Cliente getClientePorUsuario(int dni)
	{		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultSet; //Guarda el resultado de la query
		try {
			// Esta variable la inicialize para que no tire error, pero hay que ver.
			//String readByMail = null;
			
			statement = conexion.getSQLConexion().prepareStatement(obtenerUsuario);
			statement.setInt(1, dni);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {

				return getCliente(resultSet);
			}
			
		} catch (Exception e) {
			return new Cliente();
		}
		
		return new Cliente();
	}
	
	
	private Cliente getCliente(ResultSet resultSet) throws SQLException
	{
		
		int Dni = Integer.parseInt(resultSet.getString("dni"));
		String Cuil = resultSet.getString("cuil");
		String Nombre = resultSet.getString("nombre");
		String Apellido = resultSet.getString("apellido");
		String Sexo = resultSet.getString("sexo");
		String Nacionalidad = resultSet.getString("nacionalidad");
		String FechaNac = resultSet.getString("fechanac");
		String Direccion = resultSet.getString("direccion");
		String Localidad = resultSet.getString("localidad");
		String Provincia = resultSet.getString("provincia");
		String CorreoElectronico = resultSet.getString("correo");
		String Telefono = resultSet.getString("telefono");
		String Usuario = resultSet.getString("usuario");
		String Password = resultSet.getString("password");
		int TipoUsuario = resultSet.getInt("tipousuario");
		int Estado = resultSet.getInt("estado");

		return new Cliente(Dni, Cuil, Nombre, Apellido, Sexo, Nacionalidad, FechaNac, Direccion, Localidad, Provincia, CorreoElectronico, Telefono, Usuario, Password, TipoUsuario, Estado);
		
	}
	
	

}