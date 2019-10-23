package com.demo.billing.dto;

public class ItemDetail {
	
	private double itemPrice;
	private String itemName;
	private boolean discountApplicable;
	private double discountedPrice;
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public boolean isDiscountApplicable() {
		return discountApplicable;
	}
	public void setDiscountApplicable(boolean discountApplicable) {
		this.discountApplicable = discountApplicable;
	}
	public double getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}	
}
