package com.gao.service.impl;

import com.gao.dao.IAccountDao;
import com.gao.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl2 implements IAccountService {

    private IAccountDao accountDao;//由spring注入

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //不使用模板 ，通过代理工厂来实现

    @Override
    public void transfer(String outer, String inner, Integer money) {
        //扣钱
        accountDao.out(outer,money);
        int i = 10 / 0;
        //进帐
        accountDao.in(inner,money);
    }
}
