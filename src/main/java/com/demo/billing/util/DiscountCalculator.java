package com.demo.billing.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.springframework.stereotype.Component;

@Component
public class DiscountCalculator {

	/**
	 *  For every 100 spent additional discount of 5
	 */
	public double calculateAdditonalDiscount(double discountedAmount) {
		return ((long)(discountedAmount/100))*5;
	}
	
	/**
	 *  Calculate Customer based discount
	 */
	public double customerDiscountedAmount(double amount, int discountPercent) {
		NumberFormat format = new DecimalFormat("#.##");
		double discount = (amount/100)*discountPercent;
		double dicountedAmount = amount - discount;
		return Double.parseDouble(format.format(dicountedAmount));
	}
	
}
