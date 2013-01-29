package com.step2dream.shoppingcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.step2dream.dc.DCList;

public class ConfirmAddress extends ActionSupport implements ServletResponseAware, ServletRequestAware {

	HttpServletResponse response;
	HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	public ConfirmAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String execute() throws Exception {
		HttpSession session = request.getSession();
		Object usrtemp = session.getAttribute("usrlogin-status");
		int usrstatus = 0;
		if (usrtemp != null) {
			usrstatus = Integer.parseInt(usrtemp.toString()); 
			if (usrstatus < 0) {
				request.setAttribute("previousPage", "confirmAddress");
				return LOGIN;
			}
		} else {
			request.setAttribute("previousPage", "confirmAddress");
			return LOGIN;
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root", "root");
			String sql = "SELECT * FROM deliverycharge";
			Statement stat = connection.createStatement();

			ResultSet rs = stat.executeQuery(sql);
			ArrayList<DCList> li = new ArrayList<DCList>();
			DCList dcl = null;
			while (rs.next()) {
				dcl = new DCList();
				dcl.setIdDeliveryCharge(rs.getInt(1));
				dcl.setDeliveryTownship(rs.getString(2));
				dcl.setDeliveryCharge(rs.getDouble(3));
				li.add(dcl);
			}

			session.setAttribute("list", li);
			//request.setAttribute("list", li);

			rs.close();
			stat.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading driver: " + e);
		} catch (SQLException er) {
			System.err.println("Error connecting: " + er);
			this.addActionError(er.getMessage());
		}
		return SUCCESS;		
	}

}
