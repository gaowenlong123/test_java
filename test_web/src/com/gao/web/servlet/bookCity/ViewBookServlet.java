package com.gao.web.servlet.bookCity;

import com.gao.model.Book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ViewBookServlet")
public class ViewBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 常识：从浏览器/客户端获取的所有数据都是字符串类型
		 */
		
		response.setHeader("content-type", "text/html;charset=utf-8");
		
		
		//1.获取书的id
		String str_id = request.getParameter("id");
		
		//2.把字符串转成id
		int id = Integer.parseInt(str_id);
		
		PrintWriter writer = response.getWriter();
		writer.write("查看书的ID:" + id);
		
		//3.取出对应的书:
		Book book = DBUtils.findBookById(id);
		writer.write("<br>" + book.toString());
	}
}
