package com.step2dream.usr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class UsrPostUpdate extends ActionSupport {
	
	public UsrPostUpdate() {
	}

	UsrList ul = new UsrList();

	public UsrList getUl() {
		return ul;
	}

	public void setUl(UsrList ul) {
		this.ul = ul;
	}
		
	@Override
	public String execute() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");			
			String url="jdbc:mysql://localhost/step2dream";				
			Connection connection = DriverManager.getConnection(url,"root","root");					
			String sql="UPDATE regusr SET regUsrFName=?, regUsrLName=?, regUsrPassword=?, regUsrAddress=?, regUsrPhone=?, regUsrEmail=? WHERE idRegUsr=?";			
			PreparedStatement pstat = connection.prepareStatement(sql);
			pstat.setString(1, ul.getRegUsrFName());
			pstat.setString(2, ul.getRegUsrLName());
			pstat.setString(3, ul.getRegUsrPassword());
			pstat.setString(4, ul.getRegUsrAddress());
			pstat.setString(5, ul.getRegUsrPhone());
			pstat.setString(6, ul.getRegUsrEmail());
			pstat.setInt(7, ul.getIdRegUsr());
			pstat.executeUpdate();
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
}
