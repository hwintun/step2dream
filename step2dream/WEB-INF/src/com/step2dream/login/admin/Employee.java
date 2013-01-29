package com.step2dream.login.admin;

public class Employee {
	private int idEmp;
	private String empLoginName;
	private String empPassword;
	private String empLvl;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int idEmp, String empLoginName, String empPassword,
			String empLvl) {
		super();
		this.idEmp = idEmp;
		this.empLoginName = empLoginName;
		this.empPassword = empPassword;
		this.empLvl = empLvl;
	}
	
	public int getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}
	public String getEmpLoginName() {
		return empLoginName;
	}
	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpLvl() {
		return empLvl;
	}
	public void setEmpLvl(String empLvl) {
		this.empLvl = empLvl;
	}
	
	
}
