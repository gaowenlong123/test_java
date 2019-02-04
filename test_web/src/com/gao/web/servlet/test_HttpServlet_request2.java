package com.gao.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;

/**
 *
 *
 * 1： 表单 post请求
 *
 *
 * Created by Administrator on 2019/2/4 0004.
 */
@WebServlet("/test_HttpServlet_request2")
public class test_HttpServlet_request2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                                            // 表单中的name属性
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String remark = request.getParameter("remark");
        String [] hobbies = request.getParameterValues("hobby");

        System.out.println(username);
        System.out.println(password);
        System.out.println(gender);
        System.out.println(remark);
        System.out.println(Arrays.toString(hobbies));
    }



    /**
     * 1.post请求时，中文会乱码,解决方法setCharacterEncoding,只针对post请求有效

     * 2.getInputStream 【获取不到参数】-针对post请求效
     *   使用inputStream读取数据时，发送中文变成%号形式
     *   username=gyf&password=qwer&gender=male&hobby=%E8%B5%9A%E9%92%B1&hobby=%E6%B8%B8%E6%88%8F&remark=werwerw
     *   post请求会对中文进行URL编码， 需要进行解码
     *  URL编码解决乱码问题
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //post请求时，中文会乱码,解决方法setCharacterEncoding,只针对post请求有效
        request.setCharacterEncoding("UTF-8");


        System.out.println(".....");
        ServletInputStream is = request.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = is.read(buf)) != -1){
            //把buf转成字符串
            //String s = new String(buf, 0, len);
            String s1 = new String(buf, 0, len,"gbk");//字节转成字符串是时，要以utf-8编码表
            System.out.println("s1:" + s1);
            //URL解码
            String s2 = URLDecoder.decode(s1, "utf-8");
            System.out.println("s2:" + s2);
        }
    }
}