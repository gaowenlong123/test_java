package com.gao.web.servlet.bookCity.Cookie;

import com.gao.model.Book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowAllBookServlet")
public class ShowAllBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		
		//1.准备一些书的数据   DBUtils.getAllBooks()


		//2.显示书的数据给浏览器
		PrintWriter writer = response.getWriter();
		writer.write("图书列表");
		/**
		 * <a href='/项目名/Servlet名'>书名</a>
		 * <a href='http://localhost:8080/test/ViewBookServlet?id=1'>书名</a>
		 * Servlet返回给客户端的数据可以是html标签数据
		 */
		for(Entry<Integer, Book>  entry : DBUtils.getAllBooks().entrySet()){
			Book book = entry.getValue();
			String aStr = "<br><a href='http://localhost:8080" + request.getContextPath() + "/ViewBookServlet?id="+ book.getId() +"'>" + book.getName() + "</a>";
			writer.write(aStr);
		}

		//显示历史的浏览记录
		Cookie[] cks = request.getCookies();
		writer.write("<br><br><br>历史浏览的书:<br>");
		if(cks != null){
			for(Cookie ck : cks){

				if(ck.getName().equals("historyBookIds")){
					//1-5-4
					String historyBookIds = ck.getValue();
					String[] ids = historyBookIds.split("-");

					//通过id找到书
					for(String id : ids){
						Book book = DBUtils.findBookById(Integer.parseInt(id));
						writer.write("<br>" + book.getName());
					}
				}
			}
		}
	}
}
