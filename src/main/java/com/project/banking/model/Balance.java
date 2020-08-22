package com.project.banking.model;

import java.sql.Date;

public class Balance {

	private int id;
	private double deposit_amount;
	private double withdraw_amount;
	private int account_id;
	private Date transaction_date;
	private double balance_amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDeposit_amount() {
		return deposit_amount;
	}

	public void setDeposit_amount(double deposit_amount) {
		this.deposit_amount = deposit_amount;
	}

	public double getWithdraw_amount() {
		return withdraw_amount;
	}

	public void setWithdraw_amount(double withdraw_amount) {
		this.withdraw_amount = withdraw_amount;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public double getBalance_amount() {
		return balance_amount;
	}

	public void setBalance_amount(double balance_amount) {
		this.balance_amount = balance_amount;
	}

}
