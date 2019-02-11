package com.cxf.web.servlet.test_element;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2019/2/4 0004.
 */

//取名
@WebServlet("/test_HttpServlet")
public class test_HttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        //解决乱码问题  : 乱码是服务端没有告诉浏览器的编码格式
        resp.setContentType("text/html"); //设置相应类型
        resp.setCharacterEncoding("UTF-8");//设置编码信息
        //设置相应头
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        //获取一个应用的上下文
        ServletContext context = this.getServletContext();
        System.out.println(context);


//        resp.getWriter().write("aaaaaaa");
        //上面是写字符  ，这个写字节
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buf = {97 ,98,99};
        sos.write(buf);

        //往上下文存数据
        context.setAttribute("name" , "gao-haha");

        //获取全局配置信息
        String s2 = (String) this.getServletContext().getInitParameter("encoding");
        System.out.println(s2);


        //获取资源路径
        //1:根据资源名称得到资源的绝对路径   2 ： 可以得到当前项目任何位置的任何资源

        //在web项目中，查找文件时，需要从类路径找 。 所以需要根据文件名，然后使用tomcat的方法，拼接出路径
        String path = this.getServletContext().getRealPath("WEB-INF\\classes\\com\\gao\\servlet\\info.properties");
        System.out.println(path);
        //运行中 D:\JavaProjects\test_java\out\artifacts\test_web_war_exploded\WEB-INF\classes\com\gao\servlet\info.properties
        //计算出 D:\JavaProjects\test_java\out\artifacts\test_web_war_exploded\src\com.gao.servlet\info.properties

        Properties pro = new Properties();
        pro.load(new FileInputStream(path));
        System.out.print(pro.getProperty("username"));


        //请求转发
        //获取请求转发当的对象
      /*  RequestDispatcher rd = req.getRequestDispatcher("/test_HttpServlet2");
        rd.forward(req , resp );*/

        //http
        System.out.println(req);
        System.out.println(resp);


        //设置状态码
        resp.setStatus(201);


    }
}
