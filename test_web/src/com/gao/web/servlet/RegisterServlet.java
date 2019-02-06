package com.gao.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gao.form.UserForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.gao.model.User;
import com.gao.service.IUserService;
import com.gao.service.impl.UserServiceImpl;
import com.gao.utils.MyDateConverter;
/**
 * 注意点：
 * 表单提交的时间是字符串
 * 使用Beanutis工具时候，需要注册一个转换器,把字符串转成Date对象
 *
 */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//把请求参数封装成表单校验对象
		UserForm uf = new UserForm();
		try {

			BeanUtils.populate(uf, request.getParameterMap());

			//进行检验
			if(!uf.validate()){//不合法
				System.out.println(uf.getErr());
				//回到注册页面
				request.setAttribute("uf",uf);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}

		} catch (IllegalAccessException | InvocationTargetException e1) {
			e1.printStackTrace();
		}



		//1.把请求参数封装成模型
		User user = new User();
		try {
			//Beanutis工具类中 ， 注册转换时间的转换器 ，然后就读取数据有匹配模板的没 ，如果就返回null
			ConvertUtils.register(new Converter() {

				//只能识别 1990-10-2 这种格式
				@Override
				public Object convert(Class type, Object value) {
					System.out.println("传入的value:" + value);

					String str = (String) value;

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					try {
						//把字符串转成Date类型
						return sdf.parse(str);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return null;
				}

			}, Date.class);



			//这个是上面拿出去的
//			ConvertUtils.register(new MyDateConverter(), Date.class);


			//将请求的数据装进javaBean
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println("请求参数:" + user);
			
			
			//2.调用service
			IUserService userService = new UserServiceImpl();
			userService.register(user);
			
			//3.响应客户端
			response.setHeader("content-type", "text/html;charset=utf-8");
			response.getWriter().write("注册成功，3秒后进入登录页面");
			
			//重定向sendRedirect方法的时候，要加项目名称+request.getContextPath()
			//response.addHeader("Refresh", "3;url=login.jsp");
			response.addHeader("Refresh", "3;url="+request.getContextPath()+"/login.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		} 
	
	}

}
