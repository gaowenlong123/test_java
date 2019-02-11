package com.cxf.web.servlet.test_element;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/4 0004.
 */
@WebServlet("/test_HttpServlet_request")
public class test_HttpServlet_request extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {


        //获得客户端请求参数(客户端get提交的数据)
//		1.getParameter(name)方法
        //http://localhost:8080/test/test_HttpServlet_request?username=gao&passowrd=123&gender=girl
//		String username = request.getParameter("username");
//		String password = request.getParameter("passowrd");
//		String gender = request.getParameter("gender");
//		System.out.println("客户端浏览器发送来的请求参数：");
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(gender);


//		2.getParameterValues（String name）方法 【获取一个参数的多个值】
        //http://localhost:8080/test/test_HttpServlet_request?hobby=studing&hobby=money
//		String[] hobbies = request.getParameterValues("hobby");//爱好
//		System.out.println(Arrays.toString(hobbies));



//		3.getParameterNames方法 【获取所有参数的名字】
        //http://localhost:8080/test/test_HttpServlet_request?username=gyf&passowrd=123
        /**Enumeration当成集合来用*/
//		Enumeration<String> names = request.getParameterNames();
//		//遍历
//		while(names.hasMoreElements()){
//			System.out.println(names.nextElement());
//		}


//		4.getParameterMap方法   【把所有请求参数存在一个map中】//做框架用，非常实用
        //http://localhost:8080/test/test_HttpServlet_request?username=gyf&passowrd=123&hobby=studing&hobby=money
        /**
         * key			value
         * username		{"gyf"};
         * password     {"123"};
         * hobby		{"studying","money"}
         */
		Map<String, String[]> map = request.getParameterMap();
		for(Map.Entry<String, String[]> entry : map.entrySet()){
			System.out.print("参数名字:" + entry.getKey());

			System.out.print("参数的值:");
			for(String value : entry.getValue()){
				System.out.print(value);
			}
			System.out.println("");
		}

    }
}