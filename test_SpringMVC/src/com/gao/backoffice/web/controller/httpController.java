package com.gao.backoffice.web.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 这就回到最原始的 servlet 。所以了解即可  , 不用了
 *
 * Created by Administrator on 2019/2/13 0013.
 */
public class httpController implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //无返回值
        request.setAttribute("name" ,"gao-http");
        request.getRequestDispatcher("/WEB-INF/views/user/userlist.jsp").forward(request ,response);
    }
}
