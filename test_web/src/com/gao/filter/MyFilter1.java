package com.gao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter1 implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("MyFilter1过滤器的初始化");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter1拦截请求");
		
		//放行请求
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter1过滤器销毁");
	}

}
