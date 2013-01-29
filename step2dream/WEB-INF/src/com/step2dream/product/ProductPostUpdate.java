package com.step2dream.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.step2dream.dc.*;

import com.opensymphony.xwork2.ActionSupport;

public class ProductPostUpdate extends ActionSupport {

	Product p = new Product();

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	@Override
	public String execute() {
		try{
			Class.forName("com.mysql.jdbc.Driver");			
			String url="jdbc:mysql://localhost/step2dream";				
			Connection connection = DriverManager.getConnection(url,"root","root");					
			String sql="UPDATE product SET productCode =?,productCategory = ?,productBrand = ?,productPrize = ?," +
					"productQty = ?,productColor = ?,productSize = ? WHERE idProduct =?";			
			PreparedStatement pstat = connection.prepareStatement(sql);
			pstat.setString(1, p.getProductCode());
			pstat.setString(2, p.getProductCategory());
			pstat.setString(3, p.getProductBrand());
			pstat.setDouble(4, p.getProductPrize());
			pstat.setInt(5, p.getProductQty());
			pstat.setString(6, p.getProductColor());
			pstat.setInt(7, p.getProductSize());
			pstat.setInt(8, p.getIdProduct());
			pstat.executeUpdate();
			pstat.close();
			connection.close();			
		}catch(ClassNotFoundException e) {
			System.err.println("Error loading driver: " + e);
		} catch(SQLException er) {
			System.err.println("Error connecting: " + er);
			this.addActionError(er.getMessage());
		}

		return SUCCESS;
	}
}
