package com.gao.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.gao.dao.IAccountDao;
import com.gao.model.myAccount;
import com.gao.utils.C3P0Utils;
import com.gao.utils.ManagerThreadLocal;

public class AccountDaoImpl implements IAccountDao{

	@Override
	public void updateAccount(String from, String to, double amount) throws SQLException {

		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//执行2条sql语句
		qr.update("update account set money=money-? where name = ?", amount,from);
		
		//int i = 10/0;
		
		qr.update("update account set money=money+? where name = ?", amount,to);
		
	}


	//=================使用本地线程的连接查询方式
	//在数据库请求之前，先创建数据库连接对象 。 返回一个account 对象
	@Override
	public myAccount findAccount(String name) throws SQLException {
		
		QueryRunner qr = new QueryRunner();
		String sql = "select * from account where name = ?";
		myAccount account = qr.query(ManagerThreadLocal.getConnection(),sql, new BeanHandler<myAccount>(myAccount.class),name);
		return account;
	}

	@Override
	public void updateAccount(myAccount account) throws SQLException {
		QueryRunner qr = new QueryRunner();
		
		qr.update(ManagerThreadLocal.getConnection(),"update account set money = ? where id = ?",account.getMoney(),account.getId());
	}





	//===================使用连接查询方式
	/*@Override
	public Account findAccount(String name) throws SQLException {
		
		QueryRunner qr = new QueryRunner();
		String sql = "select * from account where name = ?";
		Account account = qr.query(conn,sql, new BeanHandler<Account>(Account.class),name);
		return account;
	}

	@Override
	public void updateAccount(Account account) throws SQLException {
		QueryRunner qr = new QueryRunner();
		
		qr.update(conn,"update account set money = ? where id = ?",account.getMoney(),account.getId());
	}*/
	
	//=========================使用数据源执行方式
	/*@Override
	public Account findAccount(String name) throws SQLException {
		
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from account where name = ?";
		Account account = qr.query(sql, new BeanHandler<Account>(Account.class),name);
		return account;
	}

	@Override
	public void updateAccount(Account account) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		qr.update("update account set money = ? where id = ?",account.getMoney(),account.getId());
	}*/

}
