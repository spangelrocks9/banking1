package com.project.banking.controller;

import java.util.Scanner;

import com.project.banking.model.Account;
import com.project.banking.service.AccountService;
import com.project.banking.service.AccountServiceImpl;

public class AccountController {
	
	AccountService as = new AccountServiceImpl();

	public void createAccount(Scanner input) {
		Account account = new Account();

		System.out.println("Full Name : ");
		String account_name = input.next();

		System.out.println("Address : ");
		String address = input.next();

		System.out.println("Mobile Number : ");
		Long mobile_no = input.nextLong();

		System.out.println("Id Type : ");
		String id_type = input.next();

		System.out.println("Id Number : ");
		String id_number = input.next();

		account.setAccount_name(account_name);
		account.setAddress(address);
		account.setMobile_no(mobile_no);
		account.setId_type(id_type);
		account.setId_number(id_number);
		
		int saved = as.openAccount(account);
		if (saved >= 1) {
			System.out.println("account created successfully!");
		} else {
			System.out.println("error in db.");
		}

	}
}
