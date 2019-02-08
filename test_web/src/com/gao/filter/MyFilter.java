package com.gao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		//可以拿到在web.xml配置的数据
		System.out.println("过滤器的初始化");
		System.out.println("过滤器的名称：" + filterConfig.getFilterName());
		System.out.println("username：" + filterConfig.getInitParameter("username"));
		System.out.println("password：" + filterConfig.getInitParameter("password"));
		//获取ServletContext对象 。单例
		System.out.println("application：" + filterConfig.getServletContext());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("拦截请求");
		
		//放行请求 ，会调用下一个过滤器  。 修成一个链
		//请求的顺序 ， 就是在web.xml里面配置的顺序
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁");
	}

}
