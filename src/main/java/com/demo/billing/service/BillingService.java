package com.demo.billing.service;

import com.demo.billing.dto.BillDetail;

public interface BillingService {

	BillDetail generateBill(BillDetail billDetail);
}
