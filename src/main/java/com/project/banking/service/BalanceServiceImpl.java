package com.project.banking.service;

import com.project.banking.dao.BalanceDao;
import com.project.banking.dao.BalanceDaoImpl;
import com.project.banking.model.Balance;

public class BalanceServiceImpl implements BalanceService {

	BalanceDao bd = new BalanceDaoImpl();

	@Override
	public int depositAmount(Balance balance) {
		return bd.depositAmount(balance);
	}

	@Override
	public int withdrawAmount(Balance balance) {
		return bd.withdrawAmount(balance);
	}

	@Override
	public double getBalance(int account_id) {
		return bd.getBalance(account_id);
	}

	@Override
	public boolean getAccount(int account_id) {
		return bd.getAccount(account_id);
	}

}
