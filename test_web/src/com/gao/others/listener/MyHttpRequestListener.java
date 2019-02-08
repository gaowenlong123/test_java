package com.gao.others.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyHttpRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {

		System.out.println("请求的销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("请求的创建");
	}

	
	

}
