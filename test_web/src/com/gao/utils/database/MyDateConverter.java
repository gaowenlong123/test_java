package com.gao.utils.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

public class MyDateConverter implements Converter{

	//这是tomcat 自带的方法 ， value就是 在页面输入的 时间
	@Override
	public Object convert(Class type, Object value) {

		System.out.println("value:" + value);
		String str = (String) value;
		//把字符串转成Date类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {

			//转换成 data 类型
			return sdf.parse(str);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
