package com.resource.datasource.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hsqldb.jdbc.jdbcDataSource;
import org.hsqldb.jdbc.jdbcDataSourceFactory;

public class DataSourceLocator
{	
	private static String urlConection = "jdbc:hsqldb:hsql://localhost/aula";	
	private static String user = "sa";
	private static String password = "";
	
	private static final String envName = "jdbc/resourcePool";
	private static Connection connection;
	
	public static Connection getConnection()
	{
		try 
		{
			if(connection != null || connection.isClosed())
			{
				InitialContext initialContext = new InitialContext();
				DataSource dataSource = (DataSource)initialContext.lookup("java:comp/env/"+envName);
				connection = dataSource.getConnection();
			}
			
		} catch (NamingException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return connection;
	}
	
	public static Connection getConnectionFake()
	{
		try 
		{
			if(connection == null || connection.isClosed())
			{				
				jdbcDataSource dataSource = new jdbcDataSource();
				dataSource.setDatabase(urlConection);				
				connection = dataSource.getConnection(user, password);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return connection;
	}
	
	public static boolean testConnection(){
		try {
			//PreparedStatement preparedStat = getConnectionFake().prepareStatement("SELECT * FROM CLIENTE");
			PreparedStatement preparedStat = getConnection().prepareStatement("SELECT * FROM CLIENTE");
			ResultSet rs = preparedStat.executeQuery();
			return rs.next();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		System.out.println(testConnection()); 
	}
}
