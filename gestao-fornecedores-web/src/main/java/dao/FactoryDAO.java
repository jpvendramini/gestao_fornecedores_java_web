package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryDAO {	
	public static Connection getConnection() throws SQLException{		
		String url = "jdbc:postgresql://localhost:5432/fornecedores";
		String username = "postgres";
		String password = "admin123";
        try {
        	Class.forName("org.postgresql.Driver");                      
        	System.out.println("Connection established with the database!!");
            return DriverManager.getConnection(url, username, password);                         
       } catch (ClassNotFoundException | SQLException e) {    	              
           throw new SQLException();
       }     
    } 	
}