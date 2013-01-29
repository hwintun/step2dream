package com.step2dream.shoppingcart;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.step2dream.dc.DCList;
import com.step2dream.product.Product;
import com.step2dream.usr.UsrList;

public class ProductDataBean implements Serializable {
	private static Connection connection;
	
	public ProductDataBean() {
		try{
			Class.forName("com.mysql.jdbc.Driver");			
			String url="jdbc:mysql://localhost/step2dream";				
			connection = DriverManager.getConnection(url,"root","root");	
		}catch(ClassNotFoundException e) {
			System.err.println("Error loading driver: " + e);
		} catch(SQLException er) {
			System.err.println("Error connecting: " + er);
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public ArrayList getProductList() throws SQLException {
		ArrayList productList = new ArrayList();
		Statement statement = connection.createStatement();
		ResultSet results = statement.executeQuery("SELECT * FROM product");
		while (results.next()) {
			Product product = new Product();
			product.setIdProduct(results.getInt(1));
			product.setProductCode(results.getString(2));
			product.setProductCategory(results.getString(3));
			product.setProductBrand(results.getString(4));
			product.setProductPrize(results.getDouble(5));
			product.setProductQty(results.getInt(6));
			product.setProductColor(results.getString(7));
			product.setProductSize(results.getInt(8));
			product.setImage1(results.getString(9));
			product.setImage2(results.getString(10));
			product.setImage3(results.getString(11));
			product.setImage4(results.getString(12));
			productList.add(product);
		}
		return productList;
	}
	
	public ArrayList getDeliveryChargeList() throws SQLException {
		ArrayList dcl = new ArrayList();
		String sql = "SELECT * FROM deliverycharge";
		Statement stat = connection.createStatement();

		ResultSet rs = stat.executeQuery(sql);
		DCList dc = null;
		while (rs.next()) {
			dc = new DCList();
			dc.setIdDeliveryCharge(rs.getInt(1));
			dc.setDeliveryTownship(rs.getString(2));
			dc.setDeliveryCharge(rs.getDouble(3));
			dcl.add(dc);
		}
		return dcl;
	}
	
	public double getDeliveryChargeByTownship(String township) throws SQLException {
		double amount = 0.0;
		String sql = "SELECT * FROM deliverycharge WHERE deliveryTownship='" + township + "'";
		Statement stat = connection.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		rs.beforeFirst();
		rs.next();
		amount = rs.getDouble("deliveryPrize");
		return amount;
	}

}
