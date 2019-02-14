package com.gao.backoffice.web.controller;


import com.gao.backoffice.model.User;
import com.gao.backoffice.model.UserExt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/2/13 0013.
 */

@Controller  //相当于 在spring中配置了一个<bean class="控制器路径">
@RequestMapping("/user") //自定义根路径
public class UserController  {

//    @RequestMapping("/list")   磨人 get post 都可以访问
//    @RequestMapping(value = "/list" , method = RequestMethod.GET) 只能get
//    @RequestMapping(value = "/list" , method = RequestMethod.POST) 只能post
    @RequestMapping("list")
    public String list(){

        //跳转到 views下  /user/userlist.jsp
        return "user/userlist";
    }



//    跳转到注册页面
    @RequestMapping("toRegister")
    public String toRegister(){

        return "user/register";
    }

  /*  接受注册页面的表单参数
      接收的参数也需要在jsp页面去控制*/

    //第一种方式 使用参数
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public String register(String username,String password, int age ,String gender,Date birthday,
                           String[] hobbyIds){

        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(birthday);                    //默认的日期格式 ：月/日/年   1/1/2018
        System.out.println(Arrays.toString(hobbyIds));
        return "user/info";
    }


    //第二种方式 使用模型注入
    @RequestMapping("/register2")
    public String register2(User model){       //自动根据参数模型注入
        System.out.println(model);

        return "user/info";   //当跳转到该页面，也可以使用上面的数据
    }


    // 模型里面有模型
    @RequestMapping("/register3")
    public String register3(UserExt model){       //自动根据参数模型注入
        System.out.println(model);

        return "user/info";   //当跳转到该页面，也可以使用上面的数据
    }

    // 接收集合类型参数
    @RequestMapping("/register4")
    public String register4(UserExt model){       //自动根据参数模型注入

        List<User> users = model.getUsers();
        System.out.println(users);

        return "user/info";   //当跳转到该页面，也可以使用上面的数据

    }

    // 表单使用Map来接收
    @RequestMapping("/register5")
    public String register5(UserExt model){       //自动根据参数模型注入
        System.out.println(model.getInfos());

        return "user/info";   //当跳转到该页面，也可以使用上面的数据
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
