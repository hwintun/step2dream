package com.step2dream.usr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;
import javax.servlet.http.*;

public class UsrPreUpdate extends ActionSupport implements ApplicationAware,ServletRequestAware {
	
	HttpServletRequest request;
	Map m;

	public Map getM() {
		return m;
	}

	public void setM(Map m) {
		this.m = m;
	}
	
	public void setApplication(Map m) {
		this.m = m;
	}
	
	@Override
	public String execute() {		
		try{
			Class.forName("com.mysql.jdbc.Driver");			
			String url="jdbc:mysql://localhost/step2dream";				
			Connection connection = DriverManager.getConnection(url,"root","root");
			PreparedStatement pstat = null;
			ResultSet rs = null;
			
			String sql="SELECT * FROM regusr WHERE idRegUsr = ?";
			
			pstat = connection.prepareStatement(sql);
			
			String v = request.getParameter("v");
			System.out.println(v);			
			int value = Integer.parseInt(v);
			pstat.setInt(1, value);
			System.out.println(pstat);
			rs = pstat.executeQuery();
			rs.beforeFirst();
			rs.next();
			m.put("a", rs.getInt(1));
			m.put("b", rs.getString(2));
			m.put("c", rs.getString(3));
			m.put("d", rs.getString(4));
			m.put("e", rs.getString(5));
			m.put("f", rs.getString(6));
			m.put("g", rs.getString(7));
			
			rs.close();
			pstat.close();
			connection.close();
		}catch(ClassNotFoundException e) {
			System.err.println("Error loading driver: " + e);
		} catch(SQLException er) {
			System.err.println("Error connecting: " + er);
			this.addActionError(er.getMessage());
		}
		
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
}
