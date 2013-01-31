package com.step2dream.login.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.step2dream.emp.EmpList;
import com.sun.org.apache.regexp.internal.recompile;

public class EmpLoginAction extends ActionSupport implements ServletRequestAware {

	private Employee emp;
	HttpServletRequest request;

	public EmpLoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String execute() throws Exception {
		if(checkLogin()) {
			return SUCCESS;
		} else 
			return INPUT;
	}

	private boolean checkLogin() {
		boolean flag = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "SELECT * FROM emp where empLoginName=? AND empPassword=?";
			PreparedStatement stat = connection.prepareStatement(sql);
			System.out.println("1" + stat.toString()+ emp.getEmpLoginName() + emp.getEmpPassword());
			stat.setString(1, emp.getEmpLoginName());
			stat.setString(2, emp.getEmpPassword());
			System.out.println(stat.toString());
			ResultSet rs = stat.executeQuery();
			int id;
			if (rs != null) {
				rs.beforeFirst();
				rs.next();
				id = rs.getInt("idEmp");
			} else {
				id = 0;
				return false;
			}
			
			Map session = ActionContext.getContext().getSession();
			session.put("login-status", id);
			rs.close();
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
	
	public HttpServletRequest getServletRequest() {
		return request;
	}
}
