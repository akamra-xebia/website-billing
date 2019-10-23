package com.demo.billing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.billing.dto.BillDetail;
import com.demo.billing.dto.ItemDetail;
import com.demo.billing.service.BillingService;
import com.demo.billing.util.DiscountCalculator;

@Service("billingService")
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	private DiscountCalculator discountCalculator;

	public BillDetail generateBill(BillDetail billDetail) {
		
		List<ItemDetail> shoppingList = billDetail.getItemDetailList();	
		
		/**
		 *  Get Customer based discount for each item
		 */
		(shoppingList).stream().filter(l -> l.isDiscountApplicable()).forEach(
				item -> item.setDiscountedPrice(discountCalculator.customerDiscountedAmount(
						item.getItemPrice(), billDetail.getCustomerType().getDiscount())));
		
		/**
		 *  Non discounted items such as grocery will have no discount
		 *  so discounted price is same as actual price
		 */
		(shoppingList).stream().filter(l -> !l.isDiscountApplicable()).forEach(
				item -> item.setDiscountedPrice(item.getItemPrice()));
		
		/**
		 *  Total amount without discount
		 */
		double actualAmount = shoppingList.stream().mapToDouble(f -> f.getItemPrice()).sum();
		billDetail.setActualAmount(actualAmount);
		
		/**
		 *  Total amount after percentage discount
		 */
		double discountedAmount = shoppingList.stream().mapToDouble(f -> f.getDiscountedPrice()).sum();
		billDetail.setDiscountedAmount(discountedAmount);
		
		/**
		 *  additional discount on each 100 spent
		 */
		double additionalDiscount = discountCalculator.calculateAdditonalDiscount(discountedAmount);
		billDetail.setAdditionalDiscount(additionalDiscount);
		
		/**
		 *  Final amount to be charged
		 */
		billDetail.setFinalAmount(discountedAmount-additionalDiscount);
		
		return billDetail;
	}
}
