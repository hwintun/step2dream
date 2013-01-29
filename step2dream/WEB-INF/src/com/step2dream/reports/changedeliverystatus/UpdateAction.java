package com.step2dream.reports.changedeliverystatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	HttpServletRequest request;
	HttpServletResponse response;

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
	public String execute() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "UPDATE soldgoods SET soldGoodsStatus='delivered' WHERE idsoldGoods=?";
			PreparedStatement pstat = connection.prepareStatement(sql);

			String[] dlist = request.getParameterValues("rdel");

			for (int i = 0; i < dlist.length; i++) {
				int value = Integer.parseInt(dlist[i]);
				System.out.println(value);
				pstat.setInt(1, value);
				pstat.executeUpdate();
			}
			pstat.close();
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
