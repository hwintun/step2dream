package com.step2dream.reports.delivered;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.step2dream.reports.soldgoods.SoldGood;

public class DeliveredGoodList extends ActionSupport implements
		ServletRequestAware {

	HttpServletRequest request;
	private SoldGood sg;
	private List<SoldGood> dlist;

	public SoldGood getSg() {
		return sg;
	}

	public void setSg(SoldGood sg) {
		this.sg = sg;
	}

	public List<SoldGood> getDlist() {
		return dlist;
	}

	public void setDlist(List<SoldGood> dlist) {
		this.dlist = dlist;
	}

	public DeliveredGoodList() {
		super();
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}

	@Override
	public String execute() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "SELECT * FROM soldgoods WHERE soldGoodsStatus = 'delivered'";
			Statement stat = connection.createStatement();

			ResultSet rs = stat.executeQuery(sql);
			dlist = new ArrayList<SoldGood>();
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
				dlist.add(el);
			}

			request.setAttribute("list", dlist);

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
