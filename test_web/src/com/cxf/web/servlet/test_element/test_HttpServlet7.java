package com.cxf.web.servlet.test_element;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 1： 重定向   以前的request中存放的变量全部失效 ， 并进入一个新的request作用域
 *              （因为发了两次请求 ）
 *
 * 2:  转发      以前的request中存放的变量不会失效 ， 就像把两个页面拼到一起
 *
 * Created by Administrator on 2019/2/4 0004.
 */
@WebServlet("/test_HttpServlet7")
public class test_HttpServlet7 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //转发    路径没有跳转
//        req.getRequestDispatcher("/form_get.html").forward(req,resp);
//        req.getRequestDispatcher("/index.jsp").forward(req,resp);


        //重定向 ，需要添加项目路径
       /* String path =req.getContextPath();
        resp.sendRedirect(path + "/index.jsp");*/

        // 这两个实现类的值，都可以输出到页面
        req.getRequestDispatcher("/test_HttpServlet2").include(req ,resp);
        resp.getWriter().write("test_HttpServlet7aaaaa");
    }
}