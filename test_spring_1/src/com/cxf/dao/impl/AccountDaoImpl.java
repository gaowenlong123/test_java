package com.cxf.dao.impl;

import com.cxf.dao.IAccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

//spring-jdbc
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao{

    @Override
    public void out(String outer, Integer money) {

        getJdbcTemplate().update("update account set money = money - ? where name = ?",money,outer);
    }

    @Override
    public void in(String inner, Integer money) {
        getJdbcTemplate().update("update account set money = money + ? where name = ?",money,inner);

    }
}
