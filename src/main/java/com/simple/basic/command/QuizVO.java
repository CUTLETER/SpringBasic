package com.simple.basic.command;

import java.util.ArrayList;

public class QuizVO {

	private String id;
	private String pw;
	private String name;
	private String email;
	private ArrayList<String> inter;
	
	public QuizVO() {
		// TODO Auto-generated constructor stub
	}

	public QuizVO(String id, String pw, String name, String email, ArrayList<String> inter) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.inter = inter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<String> getInter() {
		return inter;
	}

	public void setInter(ArrayList<String> inter) {
		this.inter = inter;
	}
	
	
}
