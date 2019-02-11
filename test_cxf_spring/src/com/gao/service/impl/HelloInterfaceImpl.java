package com.gao.service.impl;

import com.gao.service.HelloInterface;

public class HelloInterfaceImpl implements HelloInterface {

    public String sayHi(String name){
        return name + ":你好,nice meet you!";
    }
}
