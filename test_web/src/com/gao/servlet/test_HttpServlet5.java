package com.gao.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/4 0004.
 */
@WebServlet("/test_HttpServlet5")
public class test_HttpServlet5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        //自动刷新的功能
  /*      resp.setHeader("Refresh","1"); //每隔一秒刷新一次
        resp.setHeader("Refresh","5;URL=index.jsp");//五秒后进入另一个页面
        resp.getWriter().write("登录成功，5秒后进入index.jsp页面");*/


        //重定向  1：地址栏会改变  2： 请求两次，增大服务器的压力
//        resp.sendRedirect(req.getContextPath()+"/test_HttpServlet2");




    }
}