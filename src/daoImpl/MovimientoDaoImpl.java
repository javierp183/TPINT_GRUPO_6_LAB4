package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MovimientoDao;
import dao.PrestamoDao;
import dominio.Movimiento;
import dominio.Prestamo;

public class MovimientoDaoImpl implements MovimientoDao {
	private static final String insert = "INSERT INTO movimiento(dni, usuario, fechanac, tipomovimiento, descripcion) VALUES(?,?,?,?,?)";
	private static final String readbydni = "SELECT * from movimiento where dni = ?";
	private static Date FechaInsert = null;
	private static String Fechastring = null;
	private Date fecha1;

	@Override
	public boolean insert(Movimiento movimiento)
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
			statement.setInt(1, movimiento.getDni());
			statement.setString(2, movimiento.getUsuario());
			statement.setString(3, movimiento.getFechanac());
			statement.setString(4, movimiento.getTipoMovimiento());
			statement.setString(5, movimiento.getDescripcion());
			
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
	public Movimiento getMovimientoPorDni(int dni)
	{		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultSet; //Guarda el resultado de la query
		try {
			// Esta variable la inicialize para que no tire error, pero hay que ver.
			//String readByMail = null;
			
			statement = conexion.getSQLConexion().prepareStatement(readbydni);
			statement.setInt(1, dni);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {

				return getMovimiento(resultSet);
			}
			
		} catch (Exception e) {
			return new Movimiento();
		}
		
		return new Movimiento();
	}
	
	@Override
	public List<Movimiento> getMovimientoPorDnis(int dni)
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readbydni);
			statement.setInt(1, dni);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				movimientos.add(getMovimiento(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return movimientos;
	}


@Override
public Boolean modify(Movimiento movimiento) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Boolean delete(Movimiento movimiento) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Movimiento> readAll() {
	// TODO Auto-generated method stub
	return null;
}

private Movimiento getMovimiento(ResultSet resultSet) throws SQLException
{
	
	int Dni = Integer.parseInt(resultSet.getString("dni"));
	String Usuario = resultSet.getString("usuario");
	String Fecha = resultSet.getString("fechanac");
	String TipoMovimiento = resultSet.getString("tipomovimiento");
	String Descripcion = resultSet.getString("descripcion");
	
	return new Movimiento(Dni, Usuario, Fecha, TipoMovimiento, Descripcion);
}

@Override
public List<Movimiento> readAllbyDni() {
	// TODO Auto-generated method stub
	return null;
}
}