package com.gao.service;

public interface IAccountService {

    /**
     * 转账
     * @param outer 转出帐号
     * @param inner 转入帐号
     * @param money 转入金额
     */
    public void transfer(String outer, String inner, Integer money);
}
