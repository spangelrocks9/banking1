package com.project.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.project.banking.model.Balance;
import com.project.banking.util.DBUtil;

public class BalanceDaoImpl implements BalanceDao {

	public static final String SQL1 = "insert into account_balance_tbl(deposit_amount, withdraw_amount, account_id, transaction_date) values(?,?,?,?)";
	public static final String SQL2 = "insert into account_balance_tbl(deposit_amount, withdraw_amount, account_id, transaction_date) values(?,?,?,?)";
	public static final String GET_BALANCE_SQL = "select IFNULL(SUM(deposit_amount),0) from account_balance_tbl where account_id=?";
	public static final String GET_ACCOUNT_SQL = "select * from account_info_tbl where account_id=?";

	@Override
	public int depositAmount(Balance balance) {
		return performTransaction(balance);
	}

	@Override
	public int withdrawAmount(Balance balance) {
		return performTransaction(balance);
	}
	
	public int performTransaction(Balance balance) {
		int saved = 0;

		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(SQL1);

			ps.setDouble(1, balance.getDeposit_amount());
			ps.setDouble(2, balance.getWithdraw_amount());
			ps.setInt(3, balance.getAccount_id());

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();

			ps.setString(4, dtf.format(now));

			saved = ps.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return saved;
	}

	@Override
	public double getBalance(int account_id) {
		double balance_amount = 0.00;

		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(GET_BALANCE_SQL);
			ps.setInt(1, account_id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				balance_amount = Double.parseDouble(rs.getString(1));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return balance_amount;
	}

	@Override
	public boolean getAccount(int account_id) {
		boolean has_account = false;
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(GET_ACCOUNT_SQL);
			ps.setInt(1, account_id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				has_account = true;
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return has_account;
	}

}
