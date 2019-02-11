package com.gao.service;

import javax.jws.WebService;

@WebService
public interface HelloInterface {

    public String sayHi(String name);
}
