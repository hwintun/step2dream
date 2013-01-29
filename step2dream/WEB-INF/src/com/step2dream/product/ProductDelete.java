package com.step2dream.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.*;
import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;

public class ProductDelete extends ActionSupport implements
		ServletRequestAware {

	HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}   

	@Override
	public String execute() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "DELETE FROM product WHERE idProduct = (?)";
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
