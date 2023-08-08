package com.bankapp.web;

import java.sql.*;

public class AddAccount {
	
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
			connection=DriverManager
					.getConnection("jdbc:mysql://localhost:3306/orabatch1?useSSL=false","root","root");
			
			//executeQuery(get) vs executeUpdate (add/del/update)
			//Statement vs PreparedStatement(better)
			
			PreparedStatement	pstmt=connection
					.prepareStatement("insert into account2(name,balance) values(?,?)");
			pstmt.setString(1, "neha");
			pstmt.setDouble(2, 1200);
			pstmt.executeUpdate();
			
			
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





