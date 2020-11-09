//package daoImpl;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import dominio.Cuenta;
//import dao.CuentaDao;
//
//
//public class CuentaDaoImpl implements CuentaDao
//{
//	private static final String insert = "INSERT INTO Cuentas(dni, nombre, apellido) VALUES(?, ?, ?)";
//	private static final String delete = "DELETE FROM Cuentas WHERE dni = ?";
//	private static final String readall = "SELECT * FROM Cuentas";
//	private static final String update = "UPDATE Cuentas SET dni = ?, nombre = ?, apellido = ? where Dni = ?";
//	
//	public boolean insert(Cuenta cuenta)
//	{
//		PreparedStatement statement;
//		Connection conexion = Conexion.getConexion().getSQLConexion();
//		boolean isInsertExitoso = false;
//		try
//		{
//			statement = conexion.prepareStatement(insert);
//			statement.setString(1, cuenta.getDni());
//			statement.setString(2, cuenta.getNombre());
//			statement.setString(3, cuenta.getApellido());
//			if(statement.executeUpdate() > 0)
//			{
//				conexion.commit();
//				isInsertExitoso = true;
//			}
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//			try {
//				conexion.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
//		
//		return isInsertExitoso;
//	}
//	
//	public boolean delete(Cuenta cuenta_a_eliminar)
//	{
//		PreparedStatement statement;
//		Connection conexion = Conexion.getConexion().getSQLConexion();
//		boolean isdeleteExitoso = false;
//		try 
//		{
//			statement = conexion.prepareStatement(delete);
//			statement.setString(1, cuenta_a_eliminar.getDni());
//			if(statement.executeUpdate() > 0)
//			{
//				conexion.commit();
//				isdeleteExitoso = true;
//			}
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		return isdeleteExitoso;
//	}
//	
//	public boolean modify(Cuenta p) {
//		PreparedStatement statement;
//		Connection conexion = Conexion.getConexion().getSQLConexion();
//		boolean isInsertExitoso = false;
//		try
//		{
//			statement = conexion.prepareStatement(update);
//			statement.setString(1, p.getDni());
//			statement.setString(2, p.getNombre());
//			statement.setString(3, p.getApellido());
//			statement.setString(4, p.getDni());
//			if(statement.executeUpdate() > 0)
//			{
//				conexion.commit();
//				isInsertExitoso = true;
//			}
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//			try {
//				conexion.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
//		
//		return isInsertExitoso;
//	}
//
//	public List<Cuenta> readAll()
//	{
//		PreparedStatement statement;
//		ResultSet resultSet; //Guarda el resultado de la query
//		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
//		Conexion conexion = Conexion.getConexion();
//		try 
//		{
//			statement = conexion.getSQLConexion().prepareStatement(readall);
//			resultSet = statement.executeQuery();
//			while(resultSet.next())
//			{
//				cuentas.add(getCuenta(resultSet));
//			}
//		} 
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//		return cuentas;
//	}
//
//
//	private Cuenta getCuenta(ResultSet resultSet) throws SQLException
//	{
//		String TipoCuenta = resultSet.getString("Dni");
//		int idCliente = Integer.parseInt(resultSet.getString("Nombre"));
//		float mInicial = Float.parseFloat(resultSet.getString("Apellido"));
//		//return new Cuenta(dni, nombre, apellido);
//		return new Cuenta(TipoCuenta, idCliente, mInicial);
//	}
//
//}