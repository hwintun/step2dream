package com.step2dream.dc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;

public class DCPostUpdate extends ActionSupport {
	DCList dcl = new DCList();

	public DCList getDcl() {
		return dcl;
	}

	public void setDcl(DCList dcl) {
		this.dcl = dcl;
	}

	@Override
	public String execute() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "UPDATE deliverycharge SET deliveryTownship=?, deliveryCharge=? WHERE idDeliveryCharge=?";
			PreparedStatement pstat = connection.prepareStatement(sql);
			pstat.setString(1, dcl.getDeliveryTownship());
			pstat.setDouble(2, dcl.getDeliveryCharge());
			pstat.setInt(3, dcl.getIdDeliveryCharge());
			System.out.println(dcl.getDeliveryTownship()
					+ dcl.getDeliveryCharge() + dcl.getIdDeliveryCharge());
			pstat.executeUpdate();
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
