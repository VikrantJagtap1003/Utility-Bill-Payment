package com.finzly.UtilityBill_PaymentPlatform.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finzly.UtilityBill_PaymentPlatform.entity.CustomerBillData;
import com.finzly.UtilityBill_PaymentPlatform.service.CustomerBillDataService;

@RestController
@CrossOrigin
@RequestMapping("Bill-Payment")
public class CustomerBillDataController {
	@Autowired
	private CustomerBillDataService customerBillDataService;

	//this api is used to get all paid bills
	@GetMapping("/paidBills")
	public List<CustomerBillData> getPaidBills() {
		return customerBillDataService.getPaidBills();
	}
	
	// this api is used to get all unpaid payments
	@GetMapping("/unpaidBills")
	public List<CustomerBillData> getUnpaidBills() {
		return customerBillDataService.getUnpaidBills();
	}
	
	//this api is used to get all bills related to specific customer
	@GetMapping("/getByCustomer-id/{customerId}")
	public List<CustomerBillData> getCustomerBillDataById(@PathVariable long customerId){
		return customerBillDataService.getCustomerBillDataById(customerId);
	}
	
	//this api is used to pay bill online
	@PutMapping("/payBillOnline")
	public String payBillOnline(@RequestBody CustomerBillData customerBillData) {
		return customerBillDataService.payBillOnline(customerBillData);
	}
	
	// this api is used get specific bill using using bill id
	@GetMapping("getById/{billid}")
	public CustomerBillData getSpecificBill(@PathVariable int billid){
		return customerBillDataService.getSpecificBill(billid);
	}
	
	
	

}
