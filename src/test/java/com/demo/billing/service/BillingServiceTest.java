package com.demo.billing.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.demo.billing.dto.BillDetail;
import com.demo.billing.dto.ItemDetail;
import com.demo.billing.enums.CustomerTypeEnum;
import com.demo.billing.service.impl.BillingServiceImpl;
import com.demo.billing.util.DiscountCalculator;

@RunWith(MockitoJUnitRunner.class)
public class BillingServiceTest {
	
	@InjectMocks
	BillingServiceImpl billingService;
	
	@Mock
	DiscountCalculator discountCalculator;
	
	@Test
	public void generateEmployeeBill(){
		
		BillDetail billDetail = new BillDetail();
		billDetail.setCustomerName("Ankur Kamra");
		billDetail.setCustomerType(CustomerTypeEnum.Employee);
		
		List<ItemDetail> itemDetailList = new ArrayList<>();
		
		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setItemName("Apple");
		itemDetail.setItemPrice(30.56);
		itemDetail.setDiscountApplicable(false);
		itemDetailList.add(itemDetail);
		
		ItemDetail itemDetail2 = new ItemDetail();
		itemDetail2.setItemName("Table");
		itemDetail2.setItemPrice(390.45);
		itemDetail2.setDiscountApplicable(true);
		itemDetailList.add(itemDetail2);
		
		billDetail.setItemDetailList(itemDetailList);
		
		Mockito.when(discountCalculator.calculateAdditonalDiscount(Mockito.anyDouble())).thenCallRealMethod();
		Mockito.when(discountCalculator.customerDiscountedAmount(Mockito.anyDouble(),Mockito.anyInt())).thenCallRealMethod();
		BillDetail finalBill = billingService.generateBill(billDetail);
		assertEquals(421.01,finalBill.getActualAmount(),.001);
		assertEquals(303.87,finalBill.getDiscountedAmount(),.001);
		assertEquals(15,finalBill.getAdditionalDiscount(),.001);
		assertEquals(288.87,finalBill.getFinalAmount(),.001);
	}

	@Test
	public void generateRegularBill(){
		
		BillDetail billDetail = new BillDetail();
		billDetail.setCustomerName("Ankur Kamra");
		billDetail.setCustomerType(CustomerTypeEnum.Regular);
		
		List<ItemDetail> itemDetailList = new ArrayList<>();
		
		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setItemName("Apple");
		itemDetail.setItemPrice(30.56);
		itemDetail.setDiscountApplicable(false);
		itemDetailList.add(itemDetail);
		
		ItemDetail itemDetail2 = new ItemDetail();
		itemDetail2.setItemName("Table");
		itemDetail2.setItemPrice(390.45);
		itemDetail2.setDiscountApplicable(true);
		itemDetailList.add(itemDetail2);
		
		billDetail.setItemDetailList(itemDetailList);
		
		Mockito.when(discountCalculator.calculateAdditonalDiscount(Mockito.anyDouble())).thenCallRealMethod();
		Mockito.when(discountCalculator.customerDiscountedAmount(Mockito.anyDouble(),Mockito.anyInt())).thenCallRealMethod();
		BillDetail finalBill = billingService.generateBill(billDetail);
		assertEquals(421.01,finalBill.getActualAmount(),.001);
		assertEquals(401.49,finalBill.getDiscountedAmount(),.001);
		assertEquals(20,finalBill.getAdditionalDiscount(),.001);
		assertEquals(381.49,finalBill.getFinalAmount(),.001);
	}
	
	@Test
	public void generateAffiliateBill(){
		
		BillDetail billDetail = new BillDetail();
		billDetail.setCustomerName("Ankur Kamra");
		billDetail.setCustomerType(CustomerTypeEnum.Affiliate);
		
		List<ItemDetail> itemDetailList = new ArrayList<>();
		
		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setItemName("Apple");
		itemDetail.setItemPrice(30.56);
		itemDetail.setDiscountApplicable(false);
		itemDetailList.add(itemDetail);
		
		ItemDetail itemDetail2 = new ItemDetail();
		itemDetail2.setItemName("Table");
		itemDetail2.setItemPrice(390.45);
		itemDetail2.setDiscountApplicable(true);
		itemDetailList.add(itemDetail2);
		
		billDetail.setItemDetailList(itemDetailList);
		
		Mockito.when(discountCalculator.calculateAdditonalDiscount(Mockito.anyDouble())).thenCallRealMethod();
		Mockito.when(discountCalculator.customerDiscountedAmount(Mockito.anyDouble(),Mockito.anyInt())).thenCallRealMethod();
		BillDetail finalBill = billingService.generateBill(billDetail);
		assertEquals(421.01,finalBill.getActualAmount(),.001);
		assertEquals(381.96,finalBill.getDiscountedAmount(),.001);
		assertEquals(15,finalBill.getAdditionalDiscount(),.001);
		assertEquals(366.96,finalBill.getFinalAmount(),.001);
	}
	
	@Test
	public void generateGeneralBill(){
		
		BillDetail billDetail = new BillDetail();
		billDetail.setCustomerName("Ankur Kamra");
		billDetail.setCustomerType(CustomerTypeEnum.General);
		
		List<ItemDetail> itemDetailList = new ArrayList<>();
		
		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setItemName("Apple");
		itemDetail.setItemPrice(30.56);
		itemDetail.setDiscountApplicable(false);
		itemDetailList.add(itemDetail);
		
		ItemDetail itemDetail2 = new ItemDetail();
		itemDetail2.setItemName("Table");
		itemDetail2.setItemPrice(390.45);
		itemDetail2.setDiscountApplicable(true);
		itemDetailList.add(itemDetail2);
		
		billDetail.setItemDetailList(itemDetailList);
		
		Mockito.when(discountCalculator.calculateAdditonalDiscount(Mockito.anyDouble())).thenCallRealMethod();
		Mockito.when(discountCalculator.customerDiscountedAmount(Mockito.anyDouble(),Mockito.anyInt())).thenCallRealMethod();
		BillDetail finalBill = billingService.generateBill(billDetail);
		assertEquals(421.01,finalBill.getActualAmount(),.001);
		assertEquals(421.01,finalBill.getDiscountedAmount(),.001);
		assertEquals(20,finalBill.getAdditionalDiscount(),.001);
		assertEquals(401.01,finalBill.getFinalAmount(),.001);
	}
	
}
