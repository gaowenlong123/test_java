package com.cxf.service.impl;

import com.cxf.dao.IAccountDao;
import com.cxf.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;//由spring注入

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //Spring配置事务模版【由spring注入】
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public void transfer(String outer, String inner, Integer money) {

        //事务模板管理 报错进行事务回滚
        this.transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //扣钱
                accountDao.out(outer,money);
                int i = 10 / 0;
                //进帐
                accountDao.in(inner,money);
            }
        });

    }
}
