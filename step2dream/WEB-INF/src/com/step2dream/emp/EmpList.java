package com.step2dream.emp;

import com.opensymphony.xwork2.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.interceptor.*;
import javax.servlet.http.*;

public class EmpList extends ActionSupport implements ServletRequestAware {

	HttpServletRequest request;
	private int idEmp;
	private String empLoginName, empPassword;
	private List<EmpList> li;

	public EmpList() {
		super();
	}

	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public String getEmpLoginName() {
		return empLoginName;
	}

	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public List<EmpList> getLi() {
		return li;
	}

	public void setLi(List<EmpList> li) {
		this.li = li;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	@Override
	public String execute() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "SELECT * FROM emp";
			Statement stat = connection.createStatement();

			ResultSet rs = stat.executeQuery(sql);
			li = new ArrayList<EmpList>();
			EmpList el = null;
			while (rs.next()) {
				el = new EmpList();
				el.setIdEmp(rs.getInt(1));
				el.setEmpLoginName(rs.getString(2));
				el.setEmpPassword(rs.getString(3));
				li.add(el);
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
