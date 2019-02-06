package com.gao.exception;

//自定义的异常类型  throw new UserException("用户名和密码不正确")    把这个值当做message，存到seesion中，然后页面输出
public class UserException extends Exception{

	public UserException(String message) {
		super(message);
	}
	
}
