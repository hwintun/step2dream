package com.step2dream.search;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.step2dream.product.Product;

public class ShowAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	Product p;
	List<String> catList;
	List<Product> pList;
	HttpServletRequest request;
	HttpServletResponse response;

	public ShowAction() {
		catList = new ArrayList<String>();
		catList.add("Slipper");
		catList.add("Shoe");
		catList.add("High Knee");
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public List<String> getCatList() {
		return catList;
	}

	public void setCatList(List<String> catList) {
		this.catList = catList;
	}
	
	public String create() {
		return SUCCESS;
	}
	
	public String show() throws Exception {
		if(p.getProductCategory().equals("-1")) {
			this.addActionError("Please Choose Category");
			return INPUT;
		}
		
		pList = new ProductDAO().getProductByCategory(p.getProductCategory());
		request.setAttribute("pList", pList);
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
}
