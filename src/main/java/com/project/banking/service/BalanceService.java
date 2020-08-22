package com.project.banking.service;

import com.project.banking.model.Balance;

public interface BalanceService {
	
	int depositAmount(Balance balance);

	int withdrawAmount(Balance balance);

	double getBalance(int account_id);

	boolean getAccount(int account_id);

}
