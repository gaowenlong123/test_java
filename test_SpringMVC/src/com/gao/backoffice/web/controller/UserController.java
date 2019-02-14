package com.gao.backoffice.web.controller;


import com.gao.backoffice.model.User;
import com.gao.backoffice.model.UserExt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
//@RequestMapping(value = "list",method = RequestMethod.POST)
@RequestMapping("list")
public String list(Model model){   //Model 是spring实现的一个类 ，用于存储页面的数据

    //1.模拟数据库的数据
    List<User> userList = new ArrayList<User>();
    User user1 = new User("习总",60,"男",new Date());
    User user2 = new User("李总",50,"男",new Date());
    User user3 = new User("上官",18,"男",new Date());

    user1.setId(1);
    user2.setId(2);
    user3.setId(3);
    userList.add(user1);
    userList.add(user2);
    userList.add(user3);

    //2.把数据存在model
    model.addAttribute("userList",userList);

    return "user/userlist";  //web页面遍历数据需要导包 jstl
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
    public String register2(User user){       //自动根据参数模型注入
        System.out.println(user);

        return "user/info";   //当跳转到该页面，也可以使用上面的数据
    }


    // 模型里面有模型
    @RequestMapping("/register3")
    public String register3(UserExt user){       //自动根据参数模型注入
        System.out.println(user);

        return "user/info";   //当跳转到该页面，也可以使用上面的数据
    }

    // 接收集合类型参数
    @RequestMapping("/register4")
    public String register4(UserExt user){       //自动根据参数模型注入

        List<User> users = user.getUsers();
        System.out.println(users);

        return "user/info";   //当跳转到该页面，也可以使用上面的数据

    }

    // 表单使用Map来接收
    @RequestMapping("/register5")
    public String register5(UserExt user){       //自动根据参数模型注入
        System.out.println(user.getInfos());

        return "user/info";   //当跳转到该页面，也可以使用上面的数据
    }


    @RequestMapping("/edit")
    public String edit(int id,Model model){
        System.out.println("接收到修改的ID:" + id);

        //通过id,查询数据库，返回 一个User对象，把user对象存在model
        User user = new User("模拟从数据库查的",60,"男",new Date());//假设从数据查
        user.setId(1);
        model.addAttribute("user",user);

        return "user/useredit";
    }


    //url模板映射 （url的path当做值）
    @RequestMapping("/edit1/{id}")
    public String edit1(@PathVariable int id, Model model){
        System.out.println("接收到修改的ID:" + id);

        //通过id,查询数据库，返回 一个User对象，把user对象存在model
        User user = new User("模拟从数据库查的",60,"男",new Date());//假设从数据查
        user.setId(1);
        model.addAttribute("user",user);

        return "user/useredit";
    }

    //    转发
    @RequestMapping("testforward")
    public String testforward(){
        //同一个控制器转发
        return "forward:list.do";
    }

    @RequestMapping("/redirect")
                   //  这个可以避免空指针                  uid必填         如果没有默认30
    public String redirect(@RequestParam(value = "uid",required = true,defaultValue = "30") Integer uid) {
        System.out.println(uid);
        return "redirect:/user/list.do";
    }
    //http://localhost:8080/rest/user/redirect?uid=1


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
