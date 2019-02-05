package com.gao.web.servlet.bookCity;

import com.gao.model.Book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowAllBookServlet")
public class ShowAllBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		
		//1.准备一些书的数据
		/*List<Book> books = new ArrayList<Book>();
		books.add(new Book(1, "吉它弹奏入门", "lp", "168.88"));
		books.add(new Book(2, "锁呐弹奏入门", "hg", "168.88"));
		books.add(new Book(3, "带小孩的一些坑", "wf", "168.88"));
		books.add(new Book(4, "桌球小王子", "sgx", "168.88"));
		books.add(new Book(5, "美食-牛肉丸", "xd", "168.88"));*/
		
		//2.显示书的数据给浏览器
		PrintWriter writer = response.getWriter();
		writer.write("图书列表");
		/**
		 * <a href='/项目名/Servlet名'>书名</a>
		 * <a href='/day10-20180321/ViewBookServlet?id=1'>书名</a>
		 * Servlet返回给客户端的数据可以是html标签数据
		 */
		for(Entry<Integer, Book>  entry : DBUtils.getAllBooks().entrySet()){
			Book book = entry.getValue();
			String aStr = "<br><a href='http://localhost:8888" + request.getContextPath() + "/ViewBookServlet?id="+ book.getId() +"'>" + book.getName() + "</a>";
			writer.write(aStr);
		}
		
		
		
		
	}
}
