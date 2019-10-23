package com.demo.billing.dto;

import java.util.List;

import com.demo.billing.enums.CustomerTypeEnum;

public class BillDetail {
	
	private String customerName;
	private CustomerTypeEnum customerType;
	private List<ItemDetail> itemDetailList;
	private double actualAmount;
	private double discountedAmount;
	private double additionalDiscount;
	private double finalAmount;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public CustomerTypeEnum getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerTypeEnum customerType) {
		this.customerType = customerType;
	}
	public List<ItemDetail> getItemDetailList() {
		return itemDetailList;
	}
	public void setItemDetailList(List<ItemDetail> itemDetailList) {
		this.itemDetailList = itemDetailList;
	}
	public double getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(double actualAmount) {
		this.actualAmount = actualAmount;
	}
	public double getDiscountedAmount() {
		return discountedAmount;
	}
	public void setDiscountedAmount(double discountedAmount) {
		this.discountedAmount = discountedAmount;
	}
	public double getAdditionalDiscount() {
		return additionalDiscount;
	}
	public void setAdditionalDiscount(double additionalDiscount) {
		this.additionalDiscount = additionalDiscount;
	}
	public double getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

}
