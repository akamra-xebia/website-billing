package com.demo.billing.contoller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.billing.dto.BillDetail;
import com.demo.billing.service.BillingService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BillingControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private BillingService billingService;
	
	@Test
    public void generateBill() throws Exception {
		
		String inputJson = "{\"customerName\": \"Ankur Kamra\","
				+ "\"customerType\": \"General\","
				+ "\"itemDetailList\": ["
				+ "{\"itemPrice\": 30.56,"
				+ " \"itemName\": \"Apple\","
				+ "\"discountApplicable\": false},"
				+ "{\"itemPrice\": 390.45,"
				+ "\"itemName\": \"Table\","
				+ "\"discountApplicable\": true}]}";
		
		BillDetail billDetail = new BillDetail();
		
		Mockito.when(billingService.generateBill(Mockito.any(BillDetail.class))).thenReturn(billDetail);	
		MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/billing/generate")
				.contentType(MediaType.APPLICATION_JSON)
        		.content(inputJson)
        		.accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

	

}
