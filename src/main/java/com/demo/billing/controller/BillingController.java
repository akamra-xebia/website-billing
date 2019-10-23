package com.demo.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.billing.dto.BillDetail;
import com.demo.billing.service.BillingService;


@RestController
@RequestMapping("/billing")
public class BillingController {
	
	@Autowired
	private BillingService billingService;
	
	@RequestMapping(value = "/generate",  method = RequestMethod.POST)
    public BillDetail generateBill(@RequestBody BillDetail billDetail) {
        return billingService.generateBill(billDetail);
    }

}
