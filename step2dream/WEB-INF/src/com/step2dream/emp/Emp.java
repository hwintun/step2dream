package com.step2dream.emp;

public class Emp {
	private int idEmp;
	private String empLoginName;
	private String empPassword;

	public Emp() {
		super();
	}

	public Emp(int idEmp, String empLoginName, String empPassword, String empLvl) {
		super();
		this.idEmp = idEmp;
		this.empLoginName = empLoginName;
		this.empPassword = empPassword;
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
}
