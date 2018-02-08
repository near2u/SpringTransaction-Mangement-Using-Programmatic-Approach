package com.project.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.model.Account;
import com.project.service.BankService;
import com.project.service.impl.BankServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("resources/beans.xml");
		
		BankService bankService = context.getBean("bankService", BankServiceImpl.class);
		
		Account fromAccount = new Account();
		fromAccount.setAccountNumber(3206381433L);
		Account toAccount = new Account();
		toAccount.setAccountNumber(3206381003L);
		bankService.fundTransfer(fromAccount, toAccount, 1000);
		
		
	}
}
