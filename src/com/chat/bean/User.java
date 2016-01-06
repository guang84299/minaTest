package com.chat.bean;

public class User {
	private int id;
	private String name;
	private String psw;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", psw=" + psw + "]";
	}
	
	
}
