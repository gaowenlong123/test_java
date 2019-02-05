package com.gao.web.servlet;

/**
 * Created by Administrator on 2019/2/5 0005.
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test_Session2")
public class test_Session2 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("content-type", "text/html;charset=utf-8");

        //1.通过request获取Session对象
        HttpSession session = request.getSession();

        //2.获取sessoin的值
        String name = (String) session.getAttribute("name");

        //3.响应客户端
        if(name == null){
            response.getWriter().write("当前的浏览器对应的Session对象没有存name的值");
        }else{
            response.getWriter().write(name);
        }



    }
}

