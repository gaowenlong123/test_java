package com.cxf.service.impl;

import java.sql.SQLException;

import com.cxf.dao.IAccountDao;
import com.cxf.dao.impl.AccountDaoImpl;
import com.cxf.model.myAccount;
import com.cxf.service.IAccountService;
import com.cxf.utils.ManagerThreadLocal;

public class AccountServiceImpl implements IAccountService{
	@Override
	public void transfer(String from, String to, double amount) {
		//调用dao
		IAccountDao accountDao = new AccountDaoImpl();
		try {
			accountDao.updateAccount(from, to, amount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	//使用事务
	@Override
	public void transfer_Transaction(String from, String to, double amount) {
		try {
			//开启事务
			ManagerThreadLocal.beginTransaction();
			IAccountDao accountDao = new AccountDaoImpl();
			
			//1.获取from的账号信息
			myAccount fromAccount = accountDao.findAccount(from);
			
			//2.获取to的账号信息
			myAccount toAccount = accountDao.findAccount(to);
			
			System.out.println("转账前....");
			System.out.println("from:" + fromAccount);
			System.out.println("to:" + toAccount);
			
			//3.修改Model的money金额
			System.out.println("转账后....");
			fromAccount.setMoney(fromAccount.getMoney() - amount);  //传的是一个对象 ，修改对象的值就像
			toAccount.setMoney(toAccount.getMoney() + amount);
			System.out.println("from:" + fromAccount);
			System.out.println("to:" + toAccount);
			
			//4.操作数据库【把数据保存到数据库】
			accountDao.updateAccount(fromAccount);
			//int i = 10/0;
			accountDao.updateAccount(toAccount);
			
			//5.提交事务
			ManagerThreadLocal.commitTransaction();

		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			ManagerThreadLocal.rollbackTransaction();
		}finally {
			ManagerThreadLocal.close();
		}
	}



	/*@Override  这个封装到方法里面
	public void transfer_Transaction(String from, String to, double amount) {

		Connection conn = null;
		try {
			//自己从数据源拿连接
			conn = C3P0Utils.getConnection();
			IAccountDao accountDao = new AccountDaoImpl(conn);
			
			//开启事务
			conn.setAutoCommit(false);
			
			//1.获取from的账号信息
			Account fromAccount = accountDao.findAccount(from);
			
			//2.获取to的账号信息
			Account toAccount = accountDao.findAccount(to);
			
			System.out.println("转账前....");
			System.out.println("from:" + fromAccount);
			System.out.println("to:" + toAccount);
			
			//3.修改Model的money金额
			System.out.println("转账后....");
			fromAccount.setMoney(fromAccount.getMoney() - amount);
			toAccount.setMoney(toAccount.getMoney() + amount);
			System.out.println("from:" + fromAccount);
			System.out.println("to:" + toAccount);
			
			//4.操作数据库【把数据保存到数据库】
			accountDao.updateAccount(fromAccount);
			//int i = 10/0;
			accountDao.updateAccount(toAccount);
			
			//5.提交事务
			conn.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();//回到连接池
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/

}
