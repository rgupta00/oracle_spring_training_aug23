package com.bankapp.web;

import java.sql.*;

public class FundTransfer {
	
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
			
			
			//it is done by u or done by some framework ?
			//it would be cool if it is done by some framework?
			//Spring tx mgt -> give u declartive way to manage the transaction
			
			connection.setAutoCommit(false);

			PreparedStatement	pstmt2=connection
					.prepareStatement("update account2 set balance =balance-10 where id=1");
		
			pstmt2.executeUpdate();
			
			PreparedStatement	pstmt=connection
					.prepareStatement("updat account2 set balance =10+balance where id=2");
		
			pstmt.executeUpdate();
			
			connection.commit();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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





