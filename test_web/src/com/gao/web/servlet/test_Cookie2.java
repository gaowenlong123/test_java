package com.gao.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/5 0005.
 */
@WebServlet("/test_Cookie2")
public class test_Cookie2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setHeader("content-type", "text/html;charset=utf-8");

        //1.获取表单请求参数
        String username =  request.getParameter("username");
        String password =  request.getParameter("password");
        String remember =  request.getParameter("remember");

        //2.简单判断是否登录成功
        boolean success = "gao".equals(username) && "123".equals(password);

        if(success){
            response.getWriter().write("登录成功");
        }else{
            response.getWriter().write("登录失败");
        }

        //3.把remember和username存在cookie中
        if("true".equals(remember) && success == true){

            Cookie ck1 = new Cookie("remember", remember);
            ck1.setMaxAge(60 * 60);//存活1个小时
            response.addCookie(ck1);

            Cookie ck2 = new Cookie("username", username);
            ck2.setMaxAge(60 * 60);//存活1个小时
            response.addCookie(ck2);
        }else{
            //消除cookie
            Cookie[] cks = request.getCookies();
            if(cks != null){
                for(Cookie c : cks){
                    c.setMaxAge(0);//删除cookie
                    response.addCookie(c);
                }
            }

        }

    }
}
