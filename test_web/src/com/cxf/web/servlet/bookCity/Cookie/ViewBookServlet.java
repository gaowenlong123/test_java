package com.cxf.web.servlet.bookCity.Cookie;

import com.cxf.model.Book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

		//4：把浏览的书的ID存在cookie中，也就是通过COOkie的形式返回给客户端
		Cookie[] cks = request.getCookies();
		if (cks == null){
			//未传过Cookie
			Cookie ck = new Cookie("historyBookIds",str_id);
			ck.setMaxAge(60*20);
			System.out.println("wuCookie");
			response.addCookie(ck);
		}else {
			//传过Cookie
			for(Cookie ck : cks){
				if (ck.getName().equals("historyBookIds")){
					String historyBookIds = ck.getValue();

					/*/判断当前的ID是否包含在里面
					historyBookIds = historyBookIds.replaceAll(str_id, "");
					historyBookIds = historyBookIds.replaceAll("--", "-");
					historyBookIds += "-" +str_id ;
					if(historyBookIds.startsWith("-")) {
						historyBookIds = historyBookIds.substring(1);
					}
					//拼接
					historyBookIds = historyBookIds.replaceAll("--", "-");*/

					if(historyBookIds.equals(str_id)) {
						ck.setMaxAge(60 * 60);
						response.addCookie(ck);
						return;
					}//如果第一个是5，不执行下面代码
					//1-5-4-5 这种要把前面 -5去除
					//5-4-5
					//5
					if(historyBookIds.startsWith(str_id)){
						historyBookIds = historyBookIds.replaceAll(str_id + "-", "");
					}else{
						historyBookIds = historyBookIds.replaceAll("-"+ str_id, "");
					}

					//拼接
					historyBookIds += "-" + str_id;
					System.out.println(historyBookIds);

					//重新响应客户端
					ck.setValue(historyBookIds);
					ck.setMaxAge(60*20);
					response.addCookie(ck);
				}
			}
		}
	}
}
