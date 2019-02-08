package com.gao.web.servlet.test_element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.gao.model.Person;

@WebServlet("/PersonListServlet")
public class PersonListServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//返回json数据:使用框架jackson
		//1.设置响应头
		response.setHeader("content-type", "text/json;charset=utf-8");

	
		//2.封装数据
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("进平", "习"));
		list.add(new Person("克强", "李"));
		list.add(new Person("洋", "汪"));
		
		//3.把对象转成json字符串
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(list);
		
		//4.响应给客户端
		response.getWriter().write(jsonStr);
	}

	
}