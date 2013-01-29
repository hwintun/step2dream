package com.step2dream.product;

import com.opensymphony.xwork2.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.*;
import javax.servlet.http.*;

public class ProductList extends ActionSupport implements ServletRequestAware {

	HttpServletRequest request;
	
	private Product p;
	private List<Product> li;

	public ProductList() {
		super();
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public List<Product> getLi() {
		return li;
	}

	public void setLi(List<Product> li) {
		this.li = li;
	}

	@Override
	public String execute() {		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");			
			String url="jdbc:mysql://localhost/step2dream";				
			Connection connection = DriverManager.getConnection(url,"root","root");					
			String sql="SELECT * FROM product";			
			Statement stat = connection.createStatement();			
					
			ResultSet rs = stat.executeQuery(sql);
			li = new ArrayList<Product>();
			Product p = null;
			while(rs.next())
			{
				p = new Product();
				p.setIdProduct(rs.getInt("idProduct"));
				p.setProductBrand(rs.getString("productBrand"));
				p.setProductCategory(rs.getString("productCategory"));
				p.setProductCode(rs.getString("productCode"));
				p.setProductColor(rs.getString("productColor"));
				p.setProductPrize(rs.getDouble("productPrize"));
				p.setProductSize(rs.getInt("productSize"));
				p.setProductQty(rs.getInt("productQty"));
				p.setImage1(rs.getString("image1"));
				p.setImage2(rs.getString("image2"));
				p.setImage3(rs.getString("image3"));
				p.setImage4(rs.getString("image4"));
				li.add(p);
			}
			
			request.setAttribute("list", li);
			
			rs.close();
			stat.close();
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
