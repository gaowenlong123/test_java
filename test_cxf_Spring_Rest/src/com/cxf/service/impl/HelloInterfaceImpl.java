package com.cxf.service.impl;

import com.cxf.service.HelloInterface;

public class HelloInterfaceImpl implements HelloInterface {

    public String sayHi(String name){
        return name + ":你好,nice meet you!";
    }
}
