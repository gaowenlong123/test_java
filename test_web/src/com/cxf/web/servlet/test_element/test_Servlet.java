package com.cxf.web.servlet.test_element;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/3 0003.
 */
public class test_Servlet implements Servlet {

    public test_Servlet() {
        System.out.println("实例化");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        //往客户端写数据
        servletResponse.getWriter().write("hellow servlet");
        System.out.println("服务中");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
