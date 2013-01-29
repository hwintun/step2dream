package com.step2dream.reports.purchase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.step2dream.login.user.User;
import com.step2dream.usr.UsrList;

public class Purchase extends ActionSupport implements ServletRequestAware {
	HttpServletRequest request;

	private int idsoldGoods;
	private String soldGoodsCode;
	private String soldGoodsBrand;
	private String soldGoodsCategory;
	private int soldGoodsQty;
	private Double soldGoodsPrize;
	private String soldGoodsColor;
	private int soldGoodsSize;
	private int soldGoodsUserId;
	private String regUsrFName;
	private String name;
	private String phone;
	private String deliveryaddress;
	private String township;


	private List<Purchase> li;
	private List<User> user;

	public Purchase() {
		super();
	}

	public List<Purchase> getLi() {
		return li;
	}

	public void setLi(List<Purchase> li) {
		this.li = li;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public int getIdsoldGoods() {
		return idsoldGoods;
	}

	public void setIdsoldGoods(int idsoldGoods) {
		this.idsoldGoods = idsoldGoods;
	}

	public String getSoldGoodsCode() {
		return soldGoodsCode;
	}

	public void setSoldGoodsCode(String soldGoodsCode) {
		this.soldGoodsCode = soldGoodsCode;
	}

	public String getSoldGoodsBrand() {
		return soldGoodsBrand;
	}

	public void setSoldGoodsBrand(String soldGoodsBrand) {
		this.soldGoodsBrand = soldGoodsBrand;
	}

	public String getSoldGoodsCategory() {
		return soldGoodsCategory;
	}

	public void setSoldGoodsCategory(String soldGoodsCategory) {
		this.soldGoodsCategory = soldGoodsCategory;
	}

	public int getSoldGoodsQty() {
		return soldGoodsQty;
	}

	public void setSoldGoodsQty(int soldGoodsQty) {
		this.soldGoodsQty = soldGoodsQty;
	}

	public Double getSoldGoodsPrize() {
		return soldGoodsPrize;
	}

	public void setSoldGoodsPrize(Double soldGoodsPrize) {
		this.soldGoodsPrize = soldGoodsPrize;
	}

	public String getSoldGoodsColor() {
		return soldGoodsColor;
	}

	public void setSoldGoodsColor(String soldGoodsColor) {
		this.soldGoodsColor = soldGoodsColor;
	}

	public int getSoldGoodsSize() {
		return soldGoodsSize;
	}

	public void setSoldGoodsSize(int soldGoodsSize) {
		this.soldGoodsSize = soldGoodsSize;
	}

	public int getSoldGoodsUserId() {
		return soldGoodsUserId;
	}

	public void setSoldGoodsUserId(int soldGoodsUserId) {
		this.soldGoodsUserId = soldGoodsUserId;
	}

	public String getRegUsrFName() {
		return regUsrFName;
	}

	public void setRegUsrFName(String regUsrFName) {
		this.regUsrFName = regUsrFName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}

	@Override
	public String execute() throws Exception {
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String userID = request.getParameter("user");
			String sql = "SELECT soldgoods.idsoldGoods, soldgoods.soldGoodsCode, "
					+ "soldgoods.soldGoodsBrand, soldgoods.soldGoodsCategory,soldgoods.soldGoodsQty,"
					+ "soldgoods.soldGoodsPrize,soldgoods.soldGoodsColor,soldgoods.soldGoodsSize,"
					+ "soldgoods.soldGoodsUserId,regusr.regUsrFName,soldgoods.name FROM step2dream.soldgoods "
					+ "LEFT OUTER JOIN regusr "
					+ "ON regusr.idRegUsr = soldgoods.soldGoodsUserId";
			Statement stat = connection.createStatement();
			rs = stat.executeQuery(sql);
			li = new ArrayList<Purchase>();
			Purchase p = null;
			while (rs.next()) {
				p = new Purchase();
				p.setIdsoldGoods(rs.getInt(1));
				p.setSoldGoodsCode(rs.getString(2));
				p.setSoldGoodsBrand(rs.getString(3));
				p.setSoldGoodsCategory(rs.getString(4));
				p.setSoldGoodsQty(rs.getInt(5));
				p.setSoldGoodsPrize(rs.getDouble(6));
				p.setSoldGoodsColor(rs.getString(7));
				p.setSoldGoodsSize(rs.getInt(8));
				p.setSoldGoodsUserId(rs.getInt(9));
				p.setRegUsrFName(rs.getString(10));
				p.setName(rs.getString(11));
				li.add(p);
			}

			userList();
			request.setAttribute("list", li);
			request.setAttribute("userlist", user);
			rs.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading driver: " + e);
		} catch (SQLException er) {
			System.err.println("Error connecting: " + er);
			this.addActionError(er.getMessage());
		}
		return SUCCESS;
	}

	private void userList() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "SELECT * FROM regusr ORDER BY idRegUsr";
			Statement stat = connection.createStatement();

			ResultSet rs = stat.executeQuery(sql);
			user = new ArrayList<User>();
			User u = null;
			while (rs.next()) {
				u = new User();
				u.setIdRegUsr(rs.getInt("idRegUsr"));
				u.setRegUsrFName(rs.getString("regUsrFName"));
				user.add(u);
			}

			rs.close();
			stat.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading driver: " + e);
		} catch (SQLException er) {
			System.err.println("Error connecting: " + er);
			this.addActionError(er.getMessage());
		}
	}

	public String view() throws Exception {
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "SELECT soldgoods.idsoldGoods, soldgoods.soldGoodsCode, "
					+ "soldgoods.soldGoodsBrand, soldgoods.soldGoodsCategory,soldgoods.soldGoodsQty,"
					+ "soldgoods.soldGoodsPrize,soldgoods.soldGoodsColor,soldgoods.soldGoodsSize,"
					+ "soldgoods.soldGoodsUserId,regusr.regUsrFName,soldgoods.name FROM step2dream.soldgoods "
					+ "LEFT OUTER JOIN regusr "
					+ "ON regusr.idRegUsr = soldgoods.soldGoodsUserId"
					+ " WHERE soldgoods.soldGoodsUserId=?";
			PreparedStatement stat = connection.prepareStatement(sql);
			stat.setInt(1, this.getSoldGoodsUserId());
			rs = stat.executeQuery();
			li = new ArrayList<Purchase>();
			Purchase p = null;
			while (rs.next()) {
				p = new Purchase();
				p.setIdsoldGoods(rs.getInt(1));
				p.setSoldGoodsCode(rs.getString(2));
				p.setSoldGoodsBrand(rs.getString(3));
				p.setSoldGoodsCategory(rs.getString(4));
				p.setSoldGoodsQty(rs.getInt(5));
				p.setSoldGoodsPrize(rs.getDouble(6));
				p.setSoldGoodsColor(rs.getString(7));
				p.setSoldGoodsSize(rs.getInt(8));
				p.setSoldGoodsUserId(rs.getInt(9));
				p.setRegUsrFName(rs.getString(10));
				p.setName(rs.getString(11));
				li.add(p);
			}
			request.setAttribute("list", li);
			request.setAttribute("userlist", user);
			rs.close();
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
