package com.project.banking.service;

import com.project.banking.dao.AccountDao;
import com.project.banking.dao.AccountDaoImpl;
import com.project.banking.model.Account;

public class AccountServiceImpl implements AccountService {

	AccountDao ad = new AccountDaoImpl();

	@Override
	public int openAccount(Account account) {
		return ad.openAccount(account);
	}

}
