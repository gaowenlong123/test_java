package com.cxf.dao;

import java.sql.SQLException;

import com.cxf.model.myAccount;

public interface IAccountDao {

	/**
	 * 更新账户信息
	 * @param from 输出的帐号
	 * @param to 输入的帐号
	 * @param amount 转账的金额
	 */
	public void updateAccount(String from, String to, double amount)throws SQLException;

	
	/**
	 * 根据名字查找账号信息
	 * @param name
	 * @return
	 */
	public myAccount findAccount(String name)throws SQLException;

	//不能两个一起更新 ，那么就不能使用事务 。 所以要分块更新账户
	public void updateAccount(myAccount account)throws SQLException;
}
