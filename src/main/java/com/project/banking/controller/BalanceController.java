package com.project.banking.controller;

import java.util.Scanner;

import com.project.banking.model.Balance;
import com.project.banking.service.BalanceService;
import com.project.banking.service.BalanceServiceImpl;

public class BalanceController {
	
	BalanceService bs = new BalanceServiceImpl();

	public void depositAmount(Scanner input) {

		String transaction_type = "deposit";
		performTransaction(input, transaction_type);

	}

	public void withdrawAmount(Scanner input) {
		String transaction_type = "withdraw";
		performTransaction(input, transaction_type);
	}

	public void performTransaction(Scanner input, String transaction_type) {
		String msg = "error in db!";

		Double deposit_amount = 0.00;
		Double withdraw_amount = 0.00;
		Balance balance = new Balance();

		System.out.println("Enter Account No : ");
		int account_id = input.nextInt();
		
		if (isValidAccount(account_id)) {
			
			if (transaction_type.equals("deposit")) {
				System.out.println("Enter Deposit Amount : ");
				deposit_amount = input.nextDouble();
			} else {
				System.out.println("Enter Withdrawl Amount : ");
				withdraw_amount = input.nextDouble();
			}
	
			balance.setAccount_id(account_id);
			if (transaction_type.equals("deposit")) {
				balance.setDeposit_amount(deposit_amount);
				;
				bs.depositAmount(balance);
				msg = "Your account has been credited by Rs " + deposit_amount;
			} else {
				if (hasBalance(account_id, withdraw_amount)) {
					balance.setWithdraw_amount(withdraw_amount);
					bs.withdrawAmount(balance);
					msg = "Your account has been debited by Rs " + withdraw_amount;
				} else {
					msg = "You do not have sufficeint balance!";
				}
			}
		}else {
			msg = "Invalid account number";
		}

		System.out.println(msg);
	}
	
	public boolean isValidAccount(int account_id) {
		return bs.getAccount(account_id);
	}

	public boolean hasBalance(int account_id, double amount) {
		return getBalanceAmount(account_id) >= amount;
	}

	public double getBalanceAmount(int account_id) {
		return bs.getBalance(account_id);
	}
	
	public void getBalance(Scanner input) {
		System.out.println("Enter Account Number : ");
		int account_id = input.nextInt();

		System.out.println("Your balance is : Rs" + bs.getBalance(account_id));
	}

}
