package com.finzly.UtilityBill_PaymentPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBill_PaymentPlatform.entity.InvoiceInfo;
import com.finzly.UtilityBill_PaymentPlatform.service.InvoiceInfoService;

@RestController
@CrossOrigin()
public class InvoiceInfoController {
	
	@Autowired
	private InvoiceInfoService invoiceInfoService;
	
	// this api is use to add  customer bill invoice 
	@PostMapping("/addInvoiceInfo")
	public void addInvoiceInfo(@RequestBody InvoiceInfo invoiceinfo ) {
		invoiceInfoService.addInvoiceInfo(invoiceinfo);
	}
	
	//this api is used to get invoice info of specific bill
	@GetMapping("/getInvoiceInfo/{billId}")
	public InvoiceInfo getInvoiceInfo(@PathVariable int billId) {
		return invoiceInfoService.getInvoiceInfo(billId);
	}

	

}
