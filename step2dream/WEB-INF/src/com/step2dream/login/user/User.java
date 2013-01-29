package com.step2dream.login.user;

public class User {
	private int idRegUsr;
	private String regUsrFName;
	private String regUsrLName;
	private String regUsrPassword;
	private String regUsrAddress;
	private String regUsrPhone;
	private String regUsrEmail;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int idRegUsr, String regUsrFName, String regUsrLName,
			String regUsrPassword, String regUsrAddress, String regUsrPhone,
			String regUsrEmail) {
		super();
		this.idRegUsr = idRegUsr;
		this.regUsrFName = regUsrFName;
		this.regUsrLName = regUsrLName;
		this.regUsrPassword = regUsrPassword;
		this.regUsrAddress = regUsrAddress;
		this.regUsrPhone = regUsrPhone;
		this.regUsrEmail = regUsrEmail;
	}

	public int getIdRegUsr() {
		return idRegUsr;
	}

	public void setIdRegUsr(int idRegUsr) {
		this.idRegUsr = idRegUsr;
	}

	public String getRegUsrFName() {
		return regUsrFName;
	}
	public void setRegUsrFName(String regUsrFName) {
		this.regUsrFName = regUsrFName;
	}
	public String getRegUsrLName() {
		return regUsrLName;
	}
	public void setRegUsrLName(String regUsrLName) {
		this.regUsrLName = regUsrLName;
	}
	public String getRegUsrPassword() {
		return regUsrPassword;
	}
	public void setRegUsrPassword(String regUsrPassword) {
		this.regUsrPassword = regUsrPassword;
	}
	public String getRegUsrAddress() {
		return regUsrAddress;
	}
	public void setRegUsrAddress(String regUsrAddress) {
		this.regUsrAddress = regUsrAddress;
	}
	public String getRegUsrPhone() {
		return regUsrPhone;
	}
	public void setRegUsrPhone(String regUsrPhone) {
		this.regUsrPhone = regUsrPhone;
	}
	public String getRegUsrEmail() {
		return regUsrEmail;
	}
	public void setRegUsrEmail(String regUsrEmail) {
		this.regUsrEmail = regUsrEmail;
	}
	
	
}
