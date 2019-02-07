package com.gao.web.servlet;

import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *  之前的表单提交会让 URL路径也改变 ，然后刷新页面 。 现在不希望这样做
 * Created by Administrator on 2019/2/7 0007.
 */

@WebServlet("/LoginServlet_ajax")
public class LoginServlet_ajax extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setHeader("content-type", "text/json;charset=utf-8");
        //1.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //自动url解码了？？？
        System.out.println(username);
        System.out.println(password);

        //2.判断是否登录成功
        Map<String,Object> map = new HashMap<String,Object>();
        if("gao".equals(username) && "123".equals(password)){
            map.put("success", 1);//登录成功的状态
            map.put("errMsg", "");//错误消息
        }else{
            map.put("success", 0);//登录成功的状态
            map.put("errMsg", "用户名或者密码不正确");//错误消息
        }

        //3.创建json的mapper对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        //将json字符串输出到ajax中
        response.getWriter().write(json);
    }

    protected void doGet1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        if("gao".equals(username) && "123".equals(password)){
            response.getWriter().write("success");
        }else{
            response.getWriter().write("failure");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //转发请求给get1
        doGet(request, response);


    }
}
