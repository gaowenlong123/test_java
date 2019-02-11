package com.cxf.web.servlet.test_element;

import com.cxf.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 存数据
 *
 * 1: 重新启动服务器，session的数据都没有了  ，
 * 需要将session持久化 ，既让session会话中的对象的类  继承Serializable 。
 * 自动将对象存在硬盘中  ，然后在服务再次启动时自动加载到会话中。
 *
 */

@WebServlet("/test_Session3")
public class test_Session3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest requeset, HttpServletResponse response)
            throws ServletException, IOException {

        //存数据
        Book book = new Book(1, "Session入门", "gao", "16.88");
        requeset.getSession().setAttribute("book", book);


    }
}