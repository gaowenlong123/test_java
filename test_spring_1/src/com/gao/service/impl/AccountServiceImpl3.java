package com.gao.service.impl;

import com.gao.dao.IAccountDao;
import com.gao.service.IAccountService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//例如注解进行配置 ，放在这里所有的方法都使用 。放在方法上 ，只针对该方法
@Transactional(propagation = Propagation.REQUIRED ,isolation = Isolation.DEFAULT ,noRollbackForClassName = "java.lang.ArithmeticException")
public class AccountServiceImpl3 implements IAccountService {

    private IAccountDao accountDao;//由spring注入

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED ,isolation = Isolation.DEFAULT ,noRollbackForClassName = "java.lang.ArithmeticException")
    public void transfer(String outer, String inner, Integer money) {
        //扣钱
        accountDao.out(outer,money);
        int i = 10 / 0;
        //进帐
        accountDao.in(inner,money);
    }
}
