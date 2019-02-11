package com.cxf.web.action;

import com.cxf.model.User;
import com.cxf.service.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("myAction")
@Scope("prototype")  //默认是单例 ，现在是多例
public class UserAction{

/*    @Autowired//spring自动注入userService赋值
    @Qualifier("myUserService")//根据指定的id注入属性*/
    @Resource(name = "myUserService")   //这行等于上面两行
    private IUserService userService;

    public void save(User user){
        System.out.println("action save方法 : " + user);
        userService.add(user);
    }

    //    用注解无需get set方法
//    public void setUserService(IUserService userService) {
//        this.userService = userService;
//    }
}
