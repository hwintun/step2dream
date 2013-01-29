package com.step2dream.search;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.step2dream.product.Product;

public class ProductDAO implements Serializable {
	private static Connection connection;

	public ProductDAO() {
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
	
	public ArrayList<Product> getProductByCategory(String cat) throws Exception {
		ArrayList<Product> productList = new ArrayList<Product>();
		Statement statement = connection.createStatement();
		ResultSet results = statement.executeQuery("SELECT * FROM product WHERE productCategory='" + cat +"'");
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
}
