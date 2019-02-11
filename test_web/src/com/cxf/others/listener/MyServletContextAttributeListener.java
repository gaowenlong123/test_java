package com.cxf.others.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 是ServletContext里属性值的监听
 *
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {

		System.out.println("ServletContext添加：" + event.getName() +"-" + event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {

		System.out.println("ServletContext移除：" + event.getName() +"-" + event.getValue());
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {

		System.out.println("ServletContext替换：" + event.getName() +"-" + event.getValue());
		
	}

	
	

}
