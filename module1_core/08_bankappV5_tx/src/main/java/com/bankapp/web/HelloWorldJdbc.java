package com.bankapp.web;

import java.sql.*;

public class HelloWorldJdbc {
	
	public static void main(String[] args) {
		//Step 1: load the driver 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver is loaded");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//Step 2: create the connection object
		Connection connection=null;
		try{
			//DriverManager.getConnection vs DataSource (better perforamance)
			//u need to open the connection, close the connection : done automatically with the 
			//help of spring framework : jdbcTemplate is reduce your code
			
			//template design pattern
			
			connection=DriverManager
					.getConnection("jdbc:mysql://localhost:3306/orabatch1?useSSL=false","root","root");
			
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from account2");//used to executeQuery fetch the records : readonly
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+": "+rs.getString(2)+": "+ rs.getDouble(3));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}





