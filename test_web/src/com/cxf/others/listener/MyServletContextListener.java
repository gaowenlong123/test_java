package com.cxf.others.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		/**
		 * ServletContext它是一个单例  。 当程序结束才会死去
		 */
		System.out.println("ServletContext对象的创建初始化");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

		System.out.println("ServletContext对象的销毁");
		
		//当程序退出的时候，做一些事情
	}

	

}
