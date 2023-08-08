package com.bankapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
@Primary
//@Profile("test")
public class AccountDaoImplJdbc implements AccountDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDaoImplJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> getAll() {
		//in spring jdbc template we have to write something called rowmapper
		//rowmapper it tell spring jdbc how to convert rs to the object
		
		return jdbcTemplate.query("select * from account2", new AccountRowMapper());
	}

	@Override
	public Account getById(int id) {
		return jdbcTemplate.queryForObject("select * from account2 where id=?", 
				new AccountRowMapper(),id);
	}

	@Override
	public void updateAccount(Account account) {
	
	 jdbcTemplate.update("update account2 set balance =? where id=?", 
			 new Object[] {account.getBalance(), account.getId()});
	}
	
	
	@Override
	public void addAccount(Account account) {
		
		//add/del/update -> update
		jdbcTemplate.update("insert into account2(name, balance) values(?,?)"
				,new Object[] {account.getName(), account.getBalance()});	
	}

	@Override
	public void deleteAccount(int id) {
		jdbcTemplate.update("delete from account2 where id=?",id);
	}
}
