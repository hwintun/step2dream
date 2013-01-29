package com.step2dream.shoppingcart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.step2dream.product.Product;

public class AddToShoppingCartAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public String execute() {
		String productID = request.getParameter("productID");
		String productCode = request.getParameter("productCode");
		String productName = request.getParameter("productName");
		String productPrize = request.getParameter("productPrize");
		String productColor = request.getParameter("productColor");
		String productImage = request.getParameter("productImage");
		String productSize = request.getParameter("productSize");
		System.out.println(productID +"" + productPrize);
		int productid = Integer.parseInt(productID);
		double prize = Double.parseDouble(productPrize);
		int size = Integer.parseInt(productSize);

		Product productItem = new Product();
		productItem.setIdProduct(productid);
		productItem.setProductCode(productCode);
		productItem.setProductBrand(productName);
		productItem.setProductPrize(prize);
		productItem.setProductColor(productColor);
		productItem.setImage1(productImage);
		productItem.setProductSize(size);
		productItem.setProductQty(1);
		
		HttpSession session = request.getSession();

		// Get the cart
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if(cart == null) {
			cart = new ShoppingCart();
			cart.addItem(productItem);
		}else {
			cart.addItem(productItem);
		}
		
		/**
		 * String url="ShowProductCatalog.jsp"; ServletContext sc =
		 * getServletContext(); RequestDispatcher rd =
		 * sc.getRequestDispatcher(url); rd.forward(request, response);
		 **/
		session.setAttribute("ShoppingCart", cart);
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
