package com.step2dream.product;

import java.io.Serializable;

public class Product implements Serializable {
	
	private int idProduct;
	private String productCode;
	private String productCategory;
	private String productBrand;	
	private Double productPrize;
	private int productQty;
	private String productColor;
	private int productSize;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	
	public Product() {
		super();
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public Double getProductPrize() {
		return productPrize;
	}

	public void setProductPrize(Double productPrize) {
		this.productPrize = productPrize;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public int getProductSize() {
		return productSize;
	}

	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}
}
