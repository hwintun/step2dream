package com.step2dream.usr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.*;

public class UsrCreate extends ActionSupport implements ServletRequestAware{

	private String regUsrFName, regUsrLName, regUsrPassword, regUsrAddress,
			regUsrPhone, regUsrEmail;
	HttpServletRequest request;

	public UsrCreate() {
		super();
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

	public String create() throws Exception {
		return SUCCESS;
	}

	public String save() throws Exception {
		HttpSession session = request.getSession();
		if (saveData()) {
			String page = (String) session.getAttribute("previousPage");
			System.out.println("1--" + page);
			if(page != null) {
				if(page.equals("viewShoppingCart")) {
					session.removeAttribute("previousPage");
					return "viewShoppingCart";
				}
			}
			session.removeAttribute("previousPage");
			return SUCCESS;
		} else
			return INPUT;
	}

	private boolean saveData() {
		boolean flag = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root","root");
			String sql = "insert into regusr(regUsrFName, regUsrLName, regUsrPassword, regUsrAddress, regUsrPhone, regUsrEmail) " +
					"values (?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, this.regUsrFName);
			pstmt.setString(2, this.regUsrLName);
			pstmt.setString(3, this.regUsrPassword);
			pstmt.setString(4, this.regUsrAddress);
			pstmt.setString(5, this.regUsrPhone);
			pstmt.setString(6, this.regUsrEmail);
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

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

}