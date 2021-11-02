package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryDAO {	
	private static Connection conn = null;
	public static Connection getConnection() throws SQLException{
		if (conn == null) {
			String url = "jdbc:postgresql://localhost:5432/fornecedores";
			String username = "postgres";
			String password = "admin123";		
	        try {
	        	Class.forName("org.postgresql.Driver");                      
	        	System.out.println("Connection established with the database!!");
	        	conn = DriverManager.getConnection(url, username, password);                         
	            return conn;
	       } catch (ClassNotFoundException | SQLException e) {    	              
	           throw new SQLException();
	       }     
		}else {			
			return conn;
		}
    } 	
}