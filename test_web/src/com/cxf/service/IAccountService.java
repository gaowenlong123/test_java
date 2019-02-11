package com.cxf.service;

public interface IAccountService {

	/**
	 * 转账操作
	 * @param from
	 * @param to
	 * @param amount
	 */
	public void transfer(String from, String to, double amount);
	
	public void transfer_Transaction(String from, String to, double amount);
}
