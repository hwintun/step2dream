package com.step2dream.shoppingcart;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Vector;

import com.step2dream.product.Product;
import com.step2dream.reports.soldgoods.SoldGood;

public class ShoppingCart implements Serializable {

	   private Connection connection;
	   private Statement statement;
	   private double totalPrice;
	   protected Vector items;

	   public ShoppingCart() {
	      items = new Vector();
	   }

	   public Vector getItems() {
	      return (Vector) items.clone();
	   }

	   public void addItem(Product newItem) {
	      boolean flag = false;
	      System.out.println(newItem.getImage1());
	      System.out.println(items.size());
	      if (items.size() == 0) {
	    	   items.addElement(newItem);
	         return;
	      }      

	      items.addElement(newItem);
	   }

	   public void removeItem(int itemIndex) {
	        items.removeElementAt(itemIndex);
	   }

	   public void completeOrder(String id, SoldGood sg)
	          throws Exception {
	      Enumeration e = items.elements();
	      connection = ProductDataBean.getConnection();
	      statement = connection.createStatement();

	      while (e.hasMoreElements()) {
	         Product item = (Product) e.nextElement();
	         totalPrice = totalPrice + item.getProductPrize();
	         

	         String updateString = "INSERT INTO soldgoods (soldGoodsCode,soldGoodsBrand,soldGoodsCategory,soldGoodsQty,soldGoodsPrize,soldGoodsColor," +
	         		"soldGoodsSize,soldGoodsStatus,soldGoodsUserId,name,phone,shippingaddress,township) " +
	         		"VALUES ('"+ item.getProductCode() +"','"+ item.getProductBrand() +"','Slipper','"+ 
	         		item.getProductQty() +"','"+ item.getProductPrize() +"','"+
	         		item.getProductColor() +"','"+ item.getProductSize() +"','purchased','"+ id +"','"+
	         		sg.getName() +"','"+ sg.getPhone() +"','"+ sg.getDeliveryaddress() +"','"+ sg.getTownship()+"')";
	         statement.executeUpdate(updateString);
	         String updateProduct = "UPDATE product SET productQty=productQty-1 WHERE idProduct=" + item.getIdProduct();
	         statement.executeUpdate(updateProduct);
	      }
	   }
	   public double getTotalPrice() {
	    	return this.totalPrice;
	   }
	   
	   public double getDeliveryCharge(String township) throws SQLException {
		   return new ProductDataBean().getDeliveryChargeByTownship(township);
	   }
}
