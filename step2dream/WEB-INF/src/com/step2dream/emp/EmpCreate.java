package com.step2dream.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.opensymphony.xwork2.*;

public class EmpCreate extends ActionSupport {

	private String empLoginName, empPassword;

	public EmpCreate() {
		super();
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

	public String create() throws Exception {
		return SUCCESS;
	}

	public String save() throws Exception {

		if (isInvalid(this.getEmpLoginName())) {
			this.addActionError(this.getText("empLName.requiredstring"));
			return INPUT;
		}

		if (isInvalid(this.getEmpPassword())) {
			this.addActionError(this.getText("empPwd.requiredstring"));
			return INPUT;
		}

		if (saveData()) {
			return SUCCESS;
		} else
			return INPUT;
	}

	private boolean saveData() {
		boolean flag = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "insert into emp(empLoginName, empPassword) values (?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, this.empLoginName);
			pstmt.setString(2, this.empPassword);
			pstmt.executeUpdate();
			connection.close();
		} catch (ClassNotFoundException e) {
			flag = false;
			System.err.println("Error loading driver: " + e);
		} catch (SQLException er) {
			System.err.println("Error connecting: " + er);
			this.addActionError(er.getMessage());
			flag = false;
		}
		return flag;
	}

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
}