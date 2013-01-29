package com.step2dream.dc;

import com.opensymphony.xwork2.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.interceptor.*;
import javax.servlet.http.*;

public class DCList extends ActionSupport implements ServletRequestAware {

	HttpServletRequest request;

	private int idDeliveryCharge;
	private String deliveryTownship;
	private Double deliveryCharge;
	private List<DCList> li;

	public DCList() {
		super();
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}

	public int getIdDeliveryCharge() {
		return idDeliveryCharge;
	}

	public List<DCList> getLi() {
		return li;
	}

	public void setLi(List<DCList> li) {
		this.li = li;
	}

	public void setIdDeliveryCharge(int idDeliveryCharge) {
		this.idDeliveryCharge = idDeliveryCharge;
	}

	public String getDeliveryTownship() {
		return deliveryTownship;
	}

	public void setDeliveryTownship(String deliveryTownship) {
		this.deliveryTownship = deliveryTownship;
	}

	public Double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(Double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	@Override
	public String execute() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root", "root");
			String sql = "SELECT * FROM deliverycharge";
			Statement stat = connection.createStatement();

			ResultSet rs = stat.executeQuery(sql);
			li = new ArrayList<DCList>();
			DCList dcl = null;
			while (rs.next()) {
				dcl = new DCList();
				dcl.setIdDeliveryCharge(rs.getInt(1));
				dcl.setDeliveryTownship(rs.getString(2));
				dcl.setDeliveryCharge(rs.getDouble(3));
				li.add(dcl);
			}

			request.setAttribute("list", li);

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
