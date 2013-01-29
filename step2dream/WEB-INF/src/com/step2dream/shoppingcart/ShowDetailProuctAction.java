package com.step2dream.shoppingcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class ShowDetailProuctAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ApplicationAware {
	
	HttpServletRequest request;
	HttpServletResponse response;
	Map m;

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	@Override
	public String execute() throws Exception {
		try{
			String v = request.getParameter("item");
			Class.forName("com.mysql.jdbc.Driver");			
			String url="jdbc:mysql://localhost/step2dream";				
			Connection connection = DriverManager.getConnection(url,"root","root");
			PreparedStatement pstat = null;
			ResultSet rs = null;
			
			String sql="SELECT * FROM product WHERE idProduct = ?";
			
			pstat = connection.prepareStatement(sql);
			
			//Statement s = connection.createStatement();
			
			System.out.println(v);			
			//int value = Integer.parseInt(v);
			pstat.setString(1, v);
			System.out.println(pstat);
			rs = pstat.executeQuery();
			rs.beforeFirst();
			rs.next();
			m.put("a", rs.getInt(1));
			m.put("b",rs.getString(2));
			m.put("c",rs.getString(3));
			m.put("d",rs.getString(4));
			m.put("e",rs.getDouble(5));
			m.put("f",rs.getInt(6));
			m.put("g",rs.getString(7));
			m.put("h",rs.getInt(8));
			m.put("i",rs.getString(9));
			m.put("j",rs.getString(10));
			m.put("k",rs.getString(11));
			m.put("l",rs.getString(12));
			rs.close();
			pstat.close();
			connection.close();
			//System.out.println("2" + rs.getInt(1) + rs.getString(2));
		}catch(ClassNotFoundException e) {
			System.err.println("Error loading driver: " + e);
		} catch(SQLException er) {
			System.err.println("Error connecting: " + er);
	er.printStackTrace();
			this.addActionError(er.getMessage());
		}
		return SUCCESS;
	}

	@Override
	public void setApplication(Map arg0) {
		// TODO Auto-generated method stub
		this.m = arg0;
	}

}
