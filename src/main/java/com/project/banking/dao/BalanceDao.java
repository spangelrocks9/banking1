package com.project.banking.dao;

import com.project.banking.model.Balance;

public interface BalanceDao {
	
	int depositAmount(Balance balance);

	int withdrawAmount(Balance balance);

	double getBalance(int account_id);

	boolean getAccount(int account_id);

}
