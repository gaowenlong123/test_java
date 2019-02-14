package com.gao.backoffice.web.controller;

import com.gao.backoffice.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 *
 * 1：ResponseBody  ：把后台pojo转换json对象 ，返回到页面
 *    RequestBody  ： 接收前台json数据 ， 把json数据自动封装 JavaBean
 *
 * 2：导包  jackson-core-asl-1.9.13.jar   jackson-mapper-asl-1.9.13.jar
 *    配置文件
 *
 *
 *
 */

/*
*           教程的配置已经过时 ！！！！！！！！！。 用maven的带一下把  。  GG
* */

@Controller
@RequestMapping("/json")
public class jsonController {

    //application/x-www-from-urlencoded 【name=gao&sex=nale】 这是表单提交的原始数据
    //application//json   需要告诉Spring 需要json数据


/*    @RequestMapping("save")
    //默认写String找写路径
//    public String save(@RequestBody Student student){
    public @ResponseBody Student save(@RequestBody Student student){
        System.out.println("aa"+student);

        return student;
    }*/


    //普通表单请求，响应的是json
/*    @RequestMapping("save2")
    public @ResponseBody Student save2( Student student){
        System.out.println("bb"+student);
        return student;
    }*/



    //多视图 配置失败
    @RequestMapping("getStu")
    public Student getStu(){
        Student student = new Student();
        student.setSex("1");
        student.setUsername("gao");
        return student;

        //http://localhost:8080/rest/json/getStu.xml  xml还要设置根标签
       // http://localhost:8080/rest/json/getStu.json
    }


}
