package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


@Repository
@Primary
//@Profile("test")
public class AccountDaoImplJdbc implements AccountDao {

	private DataSource dataSource;
	
	@Autowired
	public AccountDaoImplJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Account> getAll() {
		List<Account> accounts=new ArrayList<Account>();
		Connection connection=null;
		try {
			 connection=dataSource.getConnection();
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from account2");//used to executeQuery fetch the records : readonly
			
			while(rs.next()) {
				accounts.add(new Account(rs.getInt(1),rs.getString(2),rs.getDouble(3) ));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
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
		
		return accounts;
	}

	@Override
	public Account getById(int id) {
		Account account=null;
		Connection connection=null;
		try {
			 connection=dataSource.getConnection();
			PreparedStatement stmt=connection.prepareStatement("select * from account2 where id=?");
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				account=new Account(rs.getInt(1),rs.getString(2),rs.getDouble(3) );
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
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
		return account;
		
	}

	@Override
	public void updateAccount(Account account) {	
	}

	@Override
	public void addAccount(Account account) {
		Connection connection=null;
		try {
			 connection=dataSource.getConnection();
			 PreparedStatement	pstmt=connection
						.prepareStatement("insert into account2(name,balance) values(?,?)");
			pstmt.setString(1, account.getName());
				pstmt.setDouble(2, account.getBalance());
				pstmt.executeUpdate();
				
		}catch(SQLException ex) {
			ex.printStackTrace();
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

	@Override
	public void deleteAccount(int id) {
		
	}
	
	

}
