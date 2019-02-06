package com.gao.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

import org.apache.commons.beanutils.BeanUtils;


import com.gao.exception.UserException;
import com.gao.model.User;
import com.gao.service.IUserService;
import com.gao.service.impl.UserServiceImpl;

/**
 * 自定义异常：
 * 	掌握可以在一个业务方法抛出异常UserException
 *  掌握在一个jsp页面，如何获取失败信息
 *  	思路：往request对象存数据，然后转发到一个jsp页面，jsp页面通过el表达式取出作用域的数据
 * @author gyf
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	//	private static final long serialVersionUID = 1L;
   
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		//1.获取请求参数
		User formUser = new User();
		try {
			BeanUtils.populate(formUser, request.getParameterMap());
			//formUser User [id=0, username=gao, password=123, email=null, birthday=null]
			
			//2.调用业务方法(login)
			IUserService userService = new UserServiceImpl();
			
			try {
				//数据库查到的user
				User dbUser = userService.login(formUser);
				
				//登录用户存储到session
				request.getSession().setAttribute("user", dbUser);
				
				//进入后台页面
				response.sendRedirect(request.getContextPath() + "/main.jsp");
			} catch (UserException e) {
			//	e.printStackTrace();

				System.out.println(e.getMessage());
				//往request存数据
				request.setAttribute("message", e.getMessage());
				
				//登录失败,回到登录页面【转发】 ，路径不改变，只是转发请求
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	
	}

}
