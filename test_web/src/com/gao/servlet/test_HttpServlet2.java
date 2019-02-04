package com.gao.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/4 0004.
 */

//                        项目  webservlet，虽然这个实现类没有建立映射
//http://www.gwl.com:8080/test/test_HttpServlet2
@WebServlet("/test_HttpServlet2")
public class test_HttpServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        //获取一个应用的上下文
        ServletContext context = this.getServletContext();
        System.out.println(context);
        resp.getWriter().write("aaaa/test_HttpServlet2");

        //取servlet上下文的数据
        String s =(String)context.getAttribute("name");
        System.out.print(s);
    }
}
