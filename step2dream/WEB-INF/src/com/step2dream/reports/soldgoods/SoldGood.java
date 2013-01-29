package com.step2dream.reports.soldgoods;

public class SoldGood {
	private int idsoldGoods;
	private String soldGoodsCode;
	private String soldGoodsBrand;
	private String soldGoodsCategory;
	private int soldGoodsQty;
	private Double soldGoodsPrize;
	private String soldGoodsColor;
	private int soldGoodsSize;
	private String soldGoodsStatus;
	private int soldGoodsUserId;
	private String name;
	private String phone;
	private String deliveryaddress;
	private String township;

	public SoldGood() {
		super();
	}

	public SoldGood(int idsoldGoods, String soldGoodsCode,
			String soldGoodsBrand, String soldGoodsCategory, int soldGoodsQty,
			Double soldGoodsPrize, String soldGoodsColor, int soldGoodsSize,
			String soldGoodsStatus, int soldGoodsUserId, String name,
			String phone, String deliveryaddress, String township) {
		super();
		this.idsoldGoods = idsoldGoods;
		this.soldGoodsCode = soldGoodsCode;
		this.soldGoodsBrand = soldGoodsBrand;
		this.soldGoodsCategory = soldGoodsCategory;
		this.soldGoodsQty = soldGoodsQty;
		this.soldGoodsPrize = soldGoodsPrize;
		this.soldGoodsColor = soldGoodsColor;
		this.soldGoodsSize = soldGoodsSize;
		this.soldGoodsStatus = soldGoodsStatus;
		this.soldGoodsUserId = soldGoodsUserId;
		this.name = name;
		this.phone = phone;
		this.deliveryaddress = deliveryaddress;
		this.township = township;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public int getIdsoldGoods() {
		return idsoldGoods;
	}

	public void setIdsoldGoods(int idsoldGoods) {
		this.idsoldGoods = idsoldGoods;
	}

	public String getSoldGoodsCode() {
		return soldGoodsCode;
	}

	public void setSoldGoodsCode(String soldGoodsCode) {
		this.soldGoodsCode = soldGoodsCode;
	}

	public String getSoldGoodsBrand() {
		return soldGoodsBrand;
	}

	public void setSoldGoodsBrand(String soldGoodsBrand) {
		this.soldGoodsBrand = soldGoodsBrand;
	}

	public String getSoldGoodsCategory() {
		return soldGoodsCategory;
	}

	public void setSoldGoodsCategory(String soldGoodsCategory) {
		this.soldGoodsCategory = soldGoodsCategory;
	}

	public int getSoldGoodsQty() {
		return soldGoodsQty;
	}

	public void setSoldGoodsQty(int soldGoodsQty) {
		this.soldGoodsQty = soldGoodsQty;
	}

	public Double getSoldGoodsPrize() {
		return soldGoodsPrize;
	}

	public void setSoldGoodsPrize(Double soldGoodsPrize) {
		this.soldGoodsPrize = soldGoodsPrize;
	}

	public String getSoldGoodsColor() {
		return soldGoodsColor;
	}

	public void setSoldGoodsColor(String soldGoodsColor) {
		this.soldGoodsColor = soldGoodsColor;
	}

	public int getSoldGoodsSize() {
		return soldGoodsSize;
	}

	public void setSoldGoodsSize(int soldGoodsSize) {
		this.soldGoodsSize = soldGoodsSize;
	}

	public String getSoldGoodsStatus() {
		return soldGoodsStatus;
	}

	public void setSoldGoodsStatus(String soldGoodsStatus) {
		this.soldGoodsStatus = soldGoodsStatus;
	}

	public int getSoldGoodsUserId() {
		return soldGoodsUserId;
	}

	public void setSoldGoodsUserId(int soldGoodsUserId) {
		this.soldGoodsUserId = soldGoodsUserId;
	}

}
