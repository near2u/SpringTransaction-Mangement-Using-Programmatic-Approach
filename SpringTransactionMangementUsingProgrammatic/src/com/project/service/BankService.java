package com.project.service;

import com.project.model.Account;

public interface BankService {
	
	
	public void fundTransfer(Account fromAccount, Account toAccount, double amount);
	

}
