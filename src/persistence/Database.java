package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static String CONNECTION_STRING = "jdbc:hsqldb:hsql://localhost/hoteldb";
	private static String CONNECTION_USER = "SA";
	private static Connection con;
     
	public static Connection getConnection()
	{
		try {
			 //Registering the HSQLDB JDBC driver
	         Class.forName("org.hsqldb.jdbc.JDBCDriver");
			// create a connection to the database
			con = DriverManager.getConnection(CONNECTION_STRING, CONNECTION_USER, "");
			return con;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void closeConnection()
	{
		try {
			con.close(); //Cerramos la conexion
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
}
