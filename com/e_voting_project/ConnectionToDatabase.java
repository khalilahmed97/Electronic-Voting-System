package com.e_voting_project;

import java.sql.*;
public class ConnectionToDatabase {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/e_voting_system";
	static final String username = "root";
	static final String password = "";
	public static Connection con = null;
    public static Connection registerUser() {
    	
    	 try{
           Class.forName("com.mysql.jdbc.Driver");
           con = (DriverManager.getConnection(DB_URL, username, password));
           System.out.println("Connection Successful"); 
    	 }
    
    	 catch(Exception e) {
    		 System.out.println(e);
    	 }
    	 return con;
    	 
   
    
    }	
}