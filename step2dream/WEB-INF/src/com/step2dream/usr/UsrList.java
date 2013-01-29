package com.step2dream.usr;

import com.opensymphony.xwork2.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.*;
import javax.servlet.http.*;

public class UsrList extends ActionSupport implements ServletRequestAware {

	HttpServletRequest request;
	private int idRegUsr;
	private String 	regUsrFName, regUsrLName, regUsrPassword, regUsrAddress, regUsrPhone, regUsrEmail;
	private List<UsrList> li;
		
	
	public UsrList() {
		super();
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
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
	
	public List<UsrList> getLi() {
		return li;
	}

	public void setLi(List<UsrList> li) {
		this.li = li;
	}

	@Override
	public String execute() {
		try{
			Class.forName("com.mysql.jdbc.Driver");			
			String url="jdbc:mysql://localhost/step2dream";				
			Connection connection = DriverManager.getConnection(url,"root","root");					
			String sql="SELECT * FROM regusr";			
			Statement stat = connection.createStatement();			
					
			ResultSet rs = stat.executeQuery(sql);
			li = new ArrayList<UsrList>();
			UsrList ul = null;
			while(rs.next())
			{
				ul = new UsrList();
				ul.setIdRegUsr(rs.getInt(1));
				ul.setRegUsrFName(rs.getString(2));
				ul.setRegUsrLName(rs.getString(3));
				ul.setRegUsrPassword(rs.getString(4));
				ul.setRegUsrAddress(rs.getString(5));
				ul.setRegUsrPhone(rs.getString(6));
				ul.setRegUsrEmail(rs.getString(7));
				li.add(ul);
			}
			
			request.setAttribute("list", li);
			
			rs.close();
			stat.close();
			connection.close();			
		}catch(ClassNotFoundException e) {
			System.err.println("Error loading driver: " + e);
		} catch(SQLException er) {
			System.err.println("Error connecting: " + er);
			this.addActionError(er.getMessage());
		}
		return SUCCESS;
	}
	
	
}
