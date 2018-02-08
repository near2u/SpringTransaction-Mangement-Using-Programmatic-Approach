package com.project.dao;

import com.project.model.Account;

public interface BankDao {

	public void withdraw(Account fromAccount, Account toAccount, double amount);
	public void deposit(Account fromAccount, Account toAccount, double amount);
}
