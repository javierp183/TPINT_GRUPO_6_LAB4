package daoImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dominio.Cuenta;
import dao.CuentaDao;



public class CuentaDaoImpl implements CuentaDao
{
	private static final String insert = "INSERT INTO cuentas(idcuenta, saldo, fecha, cbu, estado, tipocuenta, dnicliente) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE cuentas SET estado = ? WHERE cbu = ?";
	private static final String readall = "SELECT * FROM cuentas";
	private static final String update = "UPDATE cuentas SET idcuenta = ?, saldo = ?, fecha = ?, cbu = ?, estado = ?, tipocuenta = ?, dnicliente = ? where cbu = ?";
	private static final String contar = "SELECT COUNT(*) AS contar FROM cuentas WHERE dnicliente = ?";
	private static final String search = "SELECT * FROM cuentas WHERE cbu = ?";
	private static final String searchcuentaInactiva = "SELECT * FROM cuentas WHERE cbu = ? and dnicliente = 0";
	private static final String readallunassigned = "SELECT * from cuentas WHERE dnicliente = 0";
	private static final String listbyDNI = "SELECT * from cuentas WHERE dnicliente = ?";
	
	private static Date FechaInsert = null;
	
	
	@Override
	public Boolean Insert(Cuenta cuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			//FechaInsert = FechaInsert.valueOf(cuenta.getFecha().toLocalDate());
			
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, cuenta.getIdcuenta());
			statement.setFloat(2, cuenta.getSaldo());
			statement.setString(3, cuenta.getFecha());
			statement.setString(4, cuenta.getCbu());
			statement.setInt(5, cuenta.getEstado());
			statement.setInt(6, cuenta.getTipoCuenta());
			statement.setInt(7, cuenta.getDni());

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

	/**
	 * @param Objeto cuenta a modificar
	 * @return Retorna true si modific�, sino, retorna false
	 */
	@Override
	public Boolean Modify(Cuenta cuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			//FechaInsert = FechaInsert.valueOf(cuenta.getFecha().toLocalDate());
			statement = conexion.prepareStatement(update);
			statement.setFloat(1, cuenta.getIdcuenta());
			statement.setFloat(2, cuenta.getSaldo());
			statement.setString(3, cuenta.getFecha());
			statement.setString(4, cuenta.getCbu());
			statement.setInt(5, cuenta.getEstado());
			statement.setInt(6, cuenta.getTipoCuenta());
			statement.setInt(7, cuenta.getDni());
			statement.setString(8, cuenta.getCbu());
			
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
	public Boolean Delete(Cuenta cuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			cuenta.setEstado(0);
			statement.setInt(1, cuenta.getEstado());
			statement.setString(2, cuenta.getCbu());
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
	public List<Cuenta> ReadAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				cuentas.add(getCuenta(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cuentas;
	}

	@Override
	public List<Cuenta> Readallunassigned() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readallunassigned);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				cuentas.add(getCuenta(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cuentas;
	}

	
	@Override
	public List<Cuenta> ListarCuentasPorDNI(int dni) {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(listbyDNI);
			statement.setInt(1, dni);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				cuentas.add(getCuenta(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cuentas;
	}



	
	
	@Override
	public Cuenta Search(String Cbu)
	{	
		
		PreparedStatement statement;
		Cuenta cuenta = new Cuenta();
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(search);
			statement.setString(1, Cbu);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				cuenta = getCuenta(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cuenta;
	}
	
	@Override
	public Cuenta SearchCuentaNoAsignada(String Cbu)
	{	
		
		PreparedStatement statement;
		Cuenta cuenta = new Cuenta();
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(searchcuentaInactiva);
			statement.setString(1, Cbu);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				cuenta = getCuenta(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cuenta;
	}

	@Override
	public int contarCuenta(int dnicuenta) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(contar);
			statement.setInt(1, dnicuenta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				return resultSet.getInt("contar");
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * @param Objeto resulSet que obtiene de la query.
	 *
	 * @return Retorna una nueva instancia de cuenta.
	 */
	private Cuenta getCuenta(ResultSet resultSet) throws SQLException
	{	
		Cuenta c = new Cuenta();
		c.setIdcuenta(resultSet.getInt("idcuenta"));
		c.setSaldo(resultSet.getFloat("saldo"));
		c.setFecha(resultSet.getString("fecha"));
		c.setCbu(resultSet.getString("cbu"));
		c.setEstado(resultSet.getInt("estado"));
		c.setTipoCuenta(resultSet.getInt("tipocuenta"));
		c.setDni(resultSet.getInt("dnicliente"));
		
		return c;
	}
	
	
}