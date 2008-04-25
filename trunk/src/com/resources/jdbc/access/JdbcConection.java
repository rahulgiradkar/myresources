package com.resources.jdbc.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConection
{
	private String urlConection;
	private String user;
	private String password;
	private String driverClass;
	private Connection connections;
	
	
 	public JdbcConection( String urlConection, String user, String password, String driverClass )
	{
 		// Loads the driver class
		try {
			Class.forName(driverClass);
			
		} catch (ClassNotFoundException e) {				
			e.printStackTrace();
		}
		
		// Connect to the data base
		try {
			connections = DriverManager.getConnection(urlConection, user, password);
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
	}
 	
 	
 	public boolean testConnection()
	{
 		try {
			PreparedStatement preparedStat = connections.prepareStatement("SELECT * FROM CLIENTE");			
			ResultSet rs = preparedStat.executeQuery();
			return rs.next();
 		} catch (SQLException e) {			
			e.printStackTrace();
		}
 		
		return false;
	}
	
	public static void main(String[] args)
	{
		String urlConection = "jdbc:hsqldb:hsql://localhost/aula"; 
		String driverClass = "org.hsqldb.jdbcDriver";
		String user = "sa";
		String password = "";
		
		JdbcConection conection = new JdbcConection(urlConection, user, password, driverClass);
		System.out.println( "Conexão: " + conection.testConnection() ); 
	}

}
