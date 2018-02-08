package com.project.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.project.dao.BankDao;
import com.project.model.Account;
import com.project.service.BankService;


public class BankServiceImpl implements BankService{
	
	
	private BankDao bankDao;
	
	
	private TransactionTemplate transactionTemplate;
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
		
	}
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
	public BankDao getBankDao() {
		return bankDao;
	}
	
	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}
	
	
	@Override
	public void fundTransfer(final Account fromAccount, final Account toAccount,
			final double amount) {
		getTransactionTemplate().execute(new TransactionCallback<Void>() {

			@Override
			public Void doInTransaction(TransactionStatus paramTransactionStatus) {
				
					getBankDao().withdraw(fromAccount, toAccount, amount);
					getBankDao().deposit(fromAccount, toAccount, amount);
					
			
			
				return null;
			}
		});
		
	}

	
	
}
