package com.gao.backoffice.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/2/13 0013.
 */

@Controller
@RequestMapping("/user")
public class UserController  {

    @RequestMapping("/list")
    public String list(){

        //跳转到 views下  /user/userlist.jsp
        return "user/userlist";
    }

    @RequestMapping("/save")
    public String save(){

        return "user/userlist";
    }

}


/*   干掉 !!!!
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UserController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        //在资源中已经配置前后缀，只需拼接即可
        ModelAndView mav = new ModelAndView("user/userlist");
        mav.addObject("name" , "gao");
        return mav;
    }
}*/
