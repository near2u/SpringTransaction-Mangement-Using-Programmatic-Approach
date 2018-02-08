package com.project.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.project.dao.BankDao;
import com.project.dao.mapper.BankRowMapper;
import com.project.model.Account;

@Repository
public class BankDaoImpl extends JdbcDaoSupport implements BankDao {

	
	

	

	@Override
	public void withdraw(Account fromAccount, Account toAccount, double amount)  {
		// TODO Auto-generated method stub
		
		Account account = getAccountInfo(fromAccount);
		Double rem = account.getAmount()- amount;
		String sql = "update icici_bank set account_balance=? where account_number=?";
		int update = getJdbcTemplate().update(sql, rem, account.getAccountNumber());
		
		if(update>0)	
			System.out.println("Amount "+amount+" withdrawed from account: "+account.getAccountNumber());
		
		
		

	}

	private Account getAccountInfo(Account fromAccount) {
		String sql = "select * from icici_bank where account_number=?";
		Account account= getJdbcTemplate().queryForObject(sql, new BankRowMapper(), fromAccount.getAccountNumber());
		return account;
	}

	@Override
	public void deposit(Account fromAccount, Account toAccount, double amount) {
		
		Account account = getAccountInfo(toAccount);
		Double balance = account.getAmount()+amount;
		String sql = "update icici_bank set account_balance=? where account_number=?";
		int update = getJdbcTemplate().update(sql, balance, account.getAccountNumber());
		
		if(update>0)	
			System.out.println("Amount "+amount+" deposited from account: "+account.getAccountNumber()+ "to account: "+toAccount.getAccountNumber());

		throw new RuntimeException();
	}

}
