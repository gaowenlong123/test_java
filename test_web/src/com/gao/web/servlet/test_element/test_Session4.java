package com.gao.web.servlet.test_element;

/**
 *       序列化失败？？？？？？
 * Created by Administrator on 2019/2/5 0005.
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gao.model.Book;

/**
 *  取数据
 */
@WebServlet("/test_Session4")
public class test_Session4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest requeset, HttpServletResponse response)
            throws ServletException, IOException {

        //取数据
        Book book = (Book) requeset.getSession().getAttribute("book");
        //............
        System.out.println(book);

    }
}
