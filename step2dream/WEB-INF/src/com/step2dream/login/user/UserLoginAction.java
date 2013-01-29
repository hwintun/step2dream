package com.step2dream.login.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport {
	private User u;

	public UserLoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}
	
	private boolean isInValid(String value) {
		return (value == null || value.length() == 0);
	}

	@Override
	public String execute() throws Exception {
		if(isInValid(u.getRegUsrLName())) {
			this.addActionError("Login Name Required");
			return INPUT;
		}
		
		if(isInValid(u.getRegUsrPassword())) {
			this.addActionError("Password Required");
			return INPUT;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "SELECT * FROM regusr where regUsrLName=? AND regUsrPassword=?";
			PreparedStatement stat = connection.prepareStatement(sql);
			System.out.println("1" + stat.toString()+ u.getRegUsrLName() + u.getRegUsrPassword());
			stat.setString(1, u.getRegUsrLName());
			stat.setString(2, u.getRegUsrPassword());
			System.out.println(stat.toString());
			ResultSet rs = stat.executeQuery();
			int id;
			if (rs != null) {
				rs.beforeFirst();
				rs.next();
				id = rs.getInt("idRegUsr");
			} else {
				id = 0;
				return INPUT;
			}
			
			Map session = ActionContext.getContext().getSession();
			session.put("usrlogin-status", id);
			rs.close();
			connection.close();
			String page = (String) session.get("previousPage");
			System.out.println("1--" + page);
			if(page != null) {
				if(page.equals("confirmAddress")) {
					session.remove("previousPage");
					return "confirmAddress";
				}
			}
			session.remove("previousPage");
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading driver: " + e);
		} catch (SQLException er) {
			System.err.println("Error connecting: " + er);
			this.addActionError(er.getMessage());
		}
		return SUCCESS;
	}
}
