package com.cxf.model;

public class Address {
	private String country;//国家
	private String city;//城市
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String country, String city) {
		super();
		this.country = country;
		this.city = city;
	}
	
	
}
