package com.cxf.web.servlet.bookCity.Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dsna.util.images.ValidateCode;

/**
 * 验证码的Servlet
 */
@WebServlet("/ValidateCodeServlet2")
public class ValidateCodeServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.生成验证
		ValidateCode vc = new ValidateCode(100, 30, 4, 6);
		System.out.println("生成的验证码:"  + vc.getCode());
		
		//如果客户端传来sessionid,但是服务端面没有对应id的session对象，这个方法没有返回值
		//If create is false and the request has no valid HttpSession, this method returns null. 
		/**
		 * request.getSession(false);
		 * 文档是，请求中没有一个合法的sessionid，这个方法就返回null
		 * 情况：浏览器传了sessionid,但是服务器已经没有这个sessionid对应的session对象，但是不是返回一个session对象
		 *       浏览器没传sessionid,服务器返回null
		 * 演示结果：
		 */
		HttpSession session = request.getSession();
		System.out.println(session);
		

		//2.把验证码存在session
		session.setAttribute("code", vc.getCode());
		
		//3.取session的ID
		System.out.println("SessionID:" + session.getId());
		
		//设置session的存活时间
		//request.getSession().setMaxInactiveInterval(30);

		vc.write(response.getOutputStream());
	}

	

}
