package com.cxf.web.servlet.bookCity.Session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 需要重新刷新   ， 因为请求后sessionID变化了
 */
@WebServlet("/LoginServlet2")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest requeset, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setHeader("content-type", "text/html;charset=utf-8");
		//1.获取请求参数
		String username = requeset.getParameter("username");
		String password = requeset.getParameter("password");
		String client_code = requeset.getParameter("code");
		
		//2.获取服务端的code  ,是一个浏览器 ，请求的时候会带上SessionID
		String server_code = (String) requeset.getSession().getAttribute("code");
		
		if(server_code == null){
			response.getWriter().write("请刷新上一个页面");
			return;
		}
		
		//3.验证码对比
		if(!server_code.equalsIgnoreCase(client_code)){
			response.getWriter().write("验证码不对");
		}else{
			
			if("gao".equals(username) && "123".equals(password)){
				response.getWriter().write("登录成功");
			}else{
				response.getWriter().write("登录失败");
			}
		}
		
		
		//4.把验证码从服务器删除
		//requeset.getSession().removeAttribute("code");  把session中code值移除
		requeset.getSession().invalidate();//让session的所有数据都删除
		System.out.println(requeset.getSession().getAttribute("code"));
		
		
	}
}
