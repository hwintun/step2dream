package com.step2dream.shoppingcart;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.step2dream.reports.soldgoods.SoldGood;

public class CheckOutAction extends ActionSupport implements
		ServletResponseAware, ServletRequestAware, ApplicationAware {
	private HttpServletRequest request;
	private HttpServletResponse response;
	Map m;

	@Override
	public String execute() throws SQLException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String dc = request.getParameter("deliveryCharge");
		SoldGood sg = new SoldGood();
		
		if(isInvalid(name)){
			this.addActionError(this.getText("name.requiredstring"));
			return INPUT;
		}
		if(isInvalid(phone)) {
			this.addActionError(this.getText("phone.requiredstring"));
			return INPUT;
		}
		if(isInvalid(address)) {
			this.addActionError(this.getText("address.requiredstring"));
			return INPUT;
		}
		if(dc.equals("-1")) {
			this.addActionError(this.getText("deliveryCharge.requiredstring"));
			return INPUT;
		}
		
		sg.setName(name);
		sg.setPhone(phone);
		sg.setDeliveryaddress(address);
		sg.setTownship(dc);
		
		System.out.println("delivery charge" + dc);
		
		// Get the cart
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		String usrId = session.getAttribute("usrlogin-status").toString();
		
		System.out.println("UserID" + usrId);
		
		try {
			cart.completeOrder(usrId, sg);
			// cart.refreshoriginaldata();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Double amount = cart.getTotalPrice();
		Double totalprice = amount + cart.getDeliveryCharge(sg.getTownship());
		System.out.println("hello world" + totalprice);
		session.removeAttribute("ShoppingCart");
		m.put("name", name);
		m.put("phone", phone);
		m.put("address", address);
		m.put("dc", cart.getDeliveryCharge(sg.getTownship()));
		m.put("amount", amount);
		m.put("totalprice", totalprice);
		
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.m = arg0;
	}

	public Map getM() {
		return m;
	}

	public void setM(Map m) {
		this.m = m;
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
}
