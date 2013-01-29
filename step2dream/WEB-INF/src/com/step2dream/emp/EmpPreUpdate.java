package com.step2dream.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class EmpPreUpdate extends ActionSupport implements ApplicationAware,
		ServletRequestAware {

	HttpServletRequest request;
	Map<String, Object> m;

	public Map<String, Object> getM() {
		return m;
	}

	public void setM(Map<String, Object> m) {
		this.m = m;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.m = arg0;
	}

	@Override
	public String execute() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			PreparedStatement pstat = null;
			ResultSet rs = null;

			String sql = "SELECT * FROM emp WHERE idEmp = ?";

			pstat = connection.prepareStatement(sql);

			String v = request.getParameter("v");
			int value = Integer.parseInt(v);
			pstat.setInt(1, value);
			rs = pstat.executeQuery();
			rs.beforeFirst();
			rs.next();

			m.put("a", rs.getInt(1));
			m.put("b", rs.getString(2));
			m.put("c", rs.getString(3));

			rs.close();
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
