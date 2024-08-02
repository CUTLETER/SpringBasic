package com.simple.basic.command;

import java.util.ArrayList;

public class MemberVO { // value object (=DTO랑 비슷한 개념)
	
	private String id;
	private String pw;
	private ArrayList<String> inter;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberVO(String id, String pw, String name, String email, ArrayList<String> inter) {
		super();
		this.id = id;
		this.pw = pw;
		this.inter = inter;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", inter=" + inter + "]";
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

	public ArrayList<String> getInter() {
		return inter;
	}

	public void setInter(ArrayList<String> inter) {
		this.inter = inter;
	}
	
	

}
