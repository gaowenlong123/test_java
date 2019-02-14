package com.gao.backoffice.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Administrator on 2019/2/14 0014.
 */

@XmlRootElement(name = "Student")
public class Student {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    private String username;
    private String sex;
}
