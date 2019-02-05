package com.gao.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * session  是存在服务器中的  ， 并且数据是不能被其他浏览器共享的
 *
 *seesion 实现 服务器实现一个session 为一个用户浏览器服务的  。 为每个session分配一个ID
 * 浏览器请求的时候带上swssionId ，服务器就会识别返回对应的值
 *如果浏览器清除缓存 ， 浏览器就无法 在request中带上SessionID ，那么就无法找到
 *
 * Created by Administrator on 2019/2/5 0005.
 */
@WebServlet("/test_Session")
public class test_Session extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取请求参数
        //http://localhost:8080/test/test_Session?name=mayun
        String name = request.getParameter("name");

        //通过request获取Session对象
        HttpSession session = request.getSession();

        //存数据到session
        session.setAttribute("name", name);

    }
}
