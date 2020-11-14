package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dominio.Cuenta;
import dao.CuentaDao;



public class CuentaDaoImpl implements CuentaDao
{
	private static final String insert = "INSERT INTO Cuentas(idcuenta, saldo, fecha, cuentascol, cbu, estado, tipocuenta, usuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE Cuentas SET estado = ?, WHERE idcuenta = ?";
	private static final String readall = "SELECT * FROM Cuentas";
	private static final String update = "UPDATE Cuentas SET idcuenta = ?, saldo = ?, fecha = ?, cuentascol = ?, cbu = ?, estado = ?, tipocuenta = ?, usuario = ?, where idcuenta = ?";
	
	public boolean insert(Cuenta cuenta)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, cuenta.getIdcuenta());
			statement.setFloat(2, cuenta.getSaldo());
			statement.setString(3, cuenta.getFecha());
			statement.setString(4, cuenta.getCuentascol());
			statement.setString(5, cuenta.getCbu());
			statement.setInt(6, 1);
			statement.setInt(7, cuenta.getTipoCuenta());
			statement.setInt(8, cuenta.getUsuario());

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
	
	public boolean delete(Cuenta cuenta_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, cuenta_a_eliminar.getIdcuenta());
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
	

	
	/**
	 * @param Objeto cuenta a modificar
	 * @return Retorna true si modificó, sino, retorna false
	 */
	public boolean modify(Cuenta cuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setInt(1, cuenta.getIdcuenta());
			statement.setFloat(2, cuenta.getSaldo());
			statement.setString(3, cuenta.getFecha());
			statement.setString(4, cuenta.getCuentascol());
			statement.setString(5, cuenta.getCbu());
			statement.setInt(6, cuenta.getEstado());
			statement.setInt(7, cuenta.getTipoCuenta());
			statement.setInt(8, cuenta.getUsuario());
			
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

	public List<Cuenta> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
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

	/**
	 * @param Objeto resulSet que obtiene de la query.
	 *
	 * @return Retorna una nueva instancia de cuenta.
	 */
	private Cuenta getCuenta(ResultSet resultSet) throws SQLException
	{	
		int Idcuenta = resultSet.getInt("idcuenta");
		float Saldo = resultSet.getFloat("saldo");
		String Fecha = resultSet.getString("fecha");
		String Cuentascol = resultSet.getString("cuentascol");
		String Cbu = resultSet.getString("cbu");
		int Estado = resultSet.getInt("estado");
		int TipoCuenta = resultSet.getInt("tipocuenta");
		int Usuario = resultSet.getInt("usuario");
		
		return new Cuenta(Idcuenta, Saldo, Fecha, Cuentascol, Cbu, Estado, TipoCuenta, Usuario);
	}

}