package com.cxf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Browse_WEB_INF")
public class Browse_WEB_INF extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//访问WEB-INF的jsp文件
		request.getRequestDispatcher("/WEB-INF/Browse_WEB-INF.jsp").forward(request, response);
	}

	
}