package com.project.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.banking.model.Account;
import com.project.banking.util.DBUtil;

public class AccountDaoImpl implements AccountDao {

	public static final String SQL = "insert into account_info_tbl(account_name, address, mobile_no, id_type, id_number) values(?,?,?,?,?)";

	@Override
	public int openAccount(Account account) {
		int saved = 0;
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, account.getAccount_name());
			ps.setString(2, account.getAddress());
			ps.setLong(3, account.getMobile_no());
			ps.setString(4, account.getId_type());
			ps.setString(5, account.getId_number());
			saved = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return saved;
	}

}
