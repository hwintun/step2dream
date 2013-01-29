package com.step2dream.reports.changedeliverystatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.step2dream.reports.soldgoods.SoldGood;

public class ListAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	HttpServletRequest request;
	HttpServletResponse response;
	private SoldGood sg;
	private List<SoldGood> sglist;

	public SoldGood getSg() {
		return sg;
	}

	public void setSg(SoldGood sg) {
		this.sg = sg;
	}

	public List<SoldGood> getSglist() {
		return sglist;
	}

	public void setSglist(List<SoldGood> sglist) {
		this.sglist = sglist;
	}

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
	public String execute() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "SELECT * FROM soldgoods";
			Statement stat = connection.createStatement();

			ResultSet rs = stat.executeQuery(sql);
			sglist = new ArrayList<SoldGood>();
			SoldGood el = null;
			while (rs.next()) {
				el = new SoldGood();
				el.setIdsoldGoods(rs.getInt(1));
				el.setSoldGoodsCode(rs.getString(2));
				el.setSoldGoodsBrand(rs.getString(3));
				el.setSoldGoodsCategory(rs.getString(4));
				el.setSoldGoodsQty(rs.getInt(5));
				el.setSoldGoodsPrize(rs.getDouble(6));
				el.setSoldGoodsColor(rs.getString(7));
				el.setSoldGoodsSize(rs.getInt(8));
				el.setSoldGoodsStatus(rs.getString(9));
				el.setSoldGoodsUserId(rs.getInt(10));
				el.setName(rs.getString(11));
				el.setPhone(rs.getString(12));
				el.setDeliveryaddress(rs.getString(13));
				el.setTownship(rs.getString(14));
				sglist.add(el);
			}

			request.setAttribute("list", sglist);

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
