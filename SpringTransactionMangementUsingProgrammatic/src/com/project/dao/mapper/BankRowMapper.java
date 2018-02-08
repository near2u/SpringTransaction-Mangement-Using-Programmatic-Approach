package com.project.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.model.Account;

public class BankRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int row) throws SQLException {
		// TODO Auto-generated method stub
		
		Account account = new Account();
		account.setAccountHolderName(rs.getString(2));
		account.setAccountNumber(rs.getLong(3));
		account.setAccountType(rs.getString(5));
		account.setAmount(rs.getDouble(4));
		return account;
	}

}
