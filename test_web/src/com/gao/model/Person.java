package com.gao.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener{

	private String firstName;
	private String lastName;
	public Person() {
		super();

	}
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {

		System.out.println("person对象绑定到session");
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {

		System.out.println("person对象从session中解绑");
		
	}
}
