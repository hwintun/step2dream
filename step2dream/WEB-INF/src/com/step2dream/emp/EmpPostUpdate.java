package com.step2dream.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;

public class EmpPostUpdate extends ActionSupport {

	private Emp e;

	public EmpPostUpdate() {
		super();
	}

	public Emp getE() {
		return e;
	}

	public void setE(Emp e) {
		this.e = e;
	}

	@Override
	public String execute() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "UPDATE emp SET empLoginName=?, empPassword=? WHERE idEmp=?";
			PreparedStatement pstat = connection.prepareStatement(sql);
			pstat.setString(1, e.getEmpLoginName());
			pstat.setString(2, e.getEmpPassword());
			pstat.setInt(3, e.getIdEmp());
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
