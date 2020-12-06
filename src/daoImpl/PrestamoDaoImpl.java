package daoImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import dominio.Prestamo;
import dao.PrestamoDao;

public class PrestamoDaoImpl implements PrestamoDao
{
	private static final String insert = "INSERT INTO prestamos(idprestamo, dnicliente, montototal, cbu, fecha, estado, pagoxmes, montopormes, numcuotas, montorestante, nombre, apellido) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String delete = "UPDATE clientes SET estado = ? where Dni = ?";
	private static final String readall = "SELECT * FROM clientes";
	private static final String readallunaproved = "SELECT * FROM prestamos where estado = 0";
	private static final String readByMail = "Select * from clientes where correo = ? and password = ?";
	private static final String update = "UPDATE clientes SET dni = ?, cuil = ?, nombre = ?, apellido = ?, sexo = ?, nacionalidad = ?, fechanac = ?, direccion = ?, localidad = ?, provincia = ?, correo = ?, telefono = ?, usuario = ?, password = ?, tipousuario = ?, estado = ? where Dni = ?";
	private static final String Provincia = null;
	private static final String TipoUsuarioCliente = "SELECT * from clientes where usuario = ?";
	private static Date FechaInsert = null;
	private static String Fechastring = null;
	
	private Date fecha;

	@Override
	public boolean insert(Prestamo prestamo)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		//FechaInsert = FechaInsert.valueOf(prestamo.getFecha().toLocalDate());
		//FechaInsert = Date.valueOf(prestamo.getFecha().toLocalDate());
		
		boolean isInsertExitoso = false;
		try
		{
			System.out.println("seteo de variable al objeto de la base");
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, prestamo.getIdPrestamo());
			statement.setInt(2, prestamo.getDniCliente());
			statement.setFloat(3, prestamo.getMontoTotal());
			statement.setString(4, prestamo.getCbu());
			statement.setString(5, prestamo.getFecha());
			statement.setInt(6, prestamo.getEstado());
			statement.setFloat(7, prestamo.getPagoxmes());
			statement.setFloat(8, prestamo.getPagoxmes());
			statement.setInt(9, prestamo.getNumCuotas());
			statement.setFloat(10, prestamo.getMontoRestante());
			statement.setString(11, prestamo.getNombre());
			statement.setString(12, prestamo.getApellido());
			
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
	public Boolean delete(Prestamo prestamo)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			prestamo.setEstado(0);
			//statement.setInt(1, cliente.getEstado());
			//statement.setInt(2, cliente.getDni());
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
	public Boolean modify(Prestamo prestamo) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setInt(1, prestamo.getIdPrestamo());
			statement.setInt(2, prestamo.getDniCliente());
			statement.setFloat(3, prestamo.getMontoTotal());
			statement.setString(4, prestamo.getCbu());
			statement.setDate(4, FechaInsert);
			statement.setInt(5, prestamo.getEstado());
			statement.setFloat(6, prestamo.getPagoxmes());
			statement.setInt(7, prestamo.getNumCuotas());
			statement.setFloat(8, prestamo.getMontoRestante());
			
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
	public Prestamo getPrestamoPorID(int idprestamo)
	{		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultSet; //Guarda el resultado de la query
		try {
			// Esta variable la inicialize para que no tire error, pero hay que ver.
			//String readByMail = null;
			
			statement = conexion.getSQLConexion().prepareStatement(TipoUsuarioCliente);
			//statement.setString(1, usuario);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {

				return getPrestamo(resultSet);
			}
			
		} catch (Exception e) {
			return new Prestamo();
		}
		
		return new Prestamo();
	}
	

	@Override
	public List<Prestamo> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Prestamo> clientes = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				clientes.add(getPrestamo(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public List<Prestamo> readAllUnapproved()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Prestamo> clientes = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readallunaproved);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				clientes.add(getPrestamo(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return clientes;
	}
	
    public static LocalDateTime asLocalDateTime(java.util.Date date) {
        return asLocalDateTime(date);
    }
	
	private Prestamo getPrestamo(ResultSet resultSet) throws SQLException
	{
		int IdPrestamo = Integer.parseInt(resultSet.getString("idprestamo"));
		int DniCliente = Integer.parseInt(resultSet.getString("dnicliente"));
		Float MontoTotal = Float.parseFloat(resultSet.getString("montototal"));
		String Cbu = resultSet.getString("cbu");
		String Fecha = resultSet.getString("fecha");
		int Estado = resultSet.getInt("estado");
		float Pagoxmes = resultSet.getFloat("pagoxmes");
		float Montopormes = resultSet.getFloat("montopormes");
		int NumCuotas = resultSet.getInt("numcuotas");
		float MontoRestante = resultSet.getFloat("montorestante");
		String Nombre = resultSet.getString("nombre");
		String Apellido = resultSet.getString("apellido");
		
		return new Prestamo(IdPrestamo, DniCliente, MontoTotal, Cbu, Fecha, Estado, Pagoxmes, Montopormes, NumCuotas, MontoRestante, Nombre, Apellido);
	}


	
	

}