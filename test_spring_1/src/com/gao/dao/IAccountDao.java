package com.gao.dao;

public interface IAccountDao {

    //扣钱
    public void out(String outer, Integer money);

    //进帐
    public void in(String inner, Integer money);
}
