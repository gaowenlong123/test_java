package com.cxf.service.impl;

import com.cxf.dao.IAccountDao;
import com.cxf.service.IAccountService;

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
