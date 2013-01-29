package com.step2dream.dc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.opensymphony.xwork2.*;

public class DCEntry extends ActionSupport {

	private String township;
	private float prize;

	public DCEntry() {
		super();
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public float getPrize() {
		return prize;
	}

	public void setPrize(float prize) {
		this.prize = prize;
	}

	public String create() throws Exception {
		return SUCCESS;

	}

	public String save() throws Exception {

		if (isInvalid(this.getTownship())) {
			this.addActionError(this.getText("tspName.requiredstring"));
			return INPUT;
		}

		if (this.getPrize() <= 0.0f) {
			this.addActionError(this.getText("tspCharge.lessthanZero"));
			return INPUT;
		}

		if (isInvalid(String.valueOf(this.getPrize()))) {
			this.addActionError(this.getText("tspCharge.requiredstring"));
			return INPUT;
		}

		if (saveData()) {
			return SUCCESS;
		} else
			return INPUT;
	}

	private boolean saveData() {
		boolean flag = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "insert into deliveryCharge (deliveryTownship, deliveryCharge) values (?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, this.township);
			pstmt.setFloat(2, this.prize);
			pstmt.executeUpdate();
			connection.close();
		} catch (ClassNotFoundException e) {
			flag = false;
			System.err.println("Error loading driver: " + e);
		} catch (SQLException er) {
			System.err.println("Error connecting: " + er);
			this.addActionError(er.getMessage());
			flag = false;
		}
		return flag;
	}

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
}