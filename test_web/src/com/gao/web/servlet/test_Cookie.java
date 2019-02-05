package com.gao.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1： 数据存在浏览器
 * 2：在服务器端设置Cookie，浏览器接到到后，就会存在本地，下次请求的时候就会带过去
 *
 * Created by Administrator on 2019/2/5 0005.
 */

@WebServlet("/test_Cookie")
public class test_Cookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cookie应用场景 :记录上次访问时间
        //设置响应时乱码问题
        response.setHeader("content-type", "text/html;charset=utf-8");

        //获取请求头的Cookie
        Cookie[] cks = request.getCookies();
        if(cks != null){
            for(Cookie c : cks){
                System.out.println(c.getName() + ":" + c.getValue());
                if(c.getName().equals("lastAccessTime") ) {
                    response.getWriter().write("上次访问的时间:" + c.getValue());

//                    c.setMaxAge(0);//在服务器中告诉浏览器 删除cookie
//                    response.addCookie(c); 把删除Cookie的信息传给浏览器
                }
            }
        }



		//1.创建一个Cookie对象
		Cookie ck = new Cookie("lastAccessTime", System.currentTimeMillis()+"");

		//2.设置cookie的存活时间【单位是秒】
		ck.setMaxAge(60*30);

		//3.把Cookie返回给客户端【通过响应头传给客户端】
		response.addCookie(ck);
    }
}
