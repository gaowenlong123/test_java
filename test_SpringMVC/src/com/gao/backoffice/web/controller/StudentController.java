package com.gao.backoffice.web.controller;

import com.gao.backoffice.model.Student;
import com.gao.backoffice.model.User;
import com.gao.backoffice.model.UserExt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// 测试不同控制器的跳转

@Controller
@RequestMapping("/stu")
public class StudentController {

    @RequestMapping("/test1")
    public String test1() {
        //不同控制器  转发
        return "forward:/user/list.do";
    }

    @RequestMapping("/test2")
    public String test2() {

        //不同控制器 重定向 ，url也跳转
        return "redirect:/user/list.do";
    }

    @RequestMapping("/save")
    public String save(Student student){

        System.out.println(student);

        return "redirect:stu/test2.do";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){

        return "stu/register";
    }


}