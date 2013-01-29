package com.step2dream.shoppingcart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class RemoveItemAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
    private HttpServletRequest request;
	private HttpServletResponse response;   

	public String execute()
	{
   // Get the index of the item to remove
      int itemIndex = Integer.parseInt(request.getParameter("item"));
      HttpSession session = request.getSession();

   // Get the cart
      ShoppingCart cart = (ShoppingCart) session.getAttribute(   
                          "ShoppingCart");

      cart.removeItem(itemIndex);

   
	  return SUCCESS;
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

}
