package com.gao.model;

import java.util.Arrays;

public class account {

	private String username;
	private String password;
	private String gender;
	private Address address;//用户所在地址

	private String[] hobby;
	private String remark;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "account [username=" + username + ", password=" + password + ", gender=" + gender + ", hobby="
				+ Arrays.toString(hobby) + ", remark=" + remark + "]";
	}


	public account(String username, String password, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
	}
	public account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}


/*	private boolean aa;
	public boolean id() {
		return aa;
	}
	public void setAa(boolean aa) {
		this.aa = aa;
	}*/


}
