package com.cxf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//退出、注销功能
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1.把session注销
		request.getSession().invalidate();
		
		//2.回到登录页面
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
}
