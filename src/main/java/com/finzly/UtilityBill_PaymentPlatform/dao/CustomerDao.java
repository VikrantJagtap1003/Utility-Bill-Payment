package com.finzly.UtilityBill_PaymentPlatform.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finzly.UtilityBill_PaymentPlatform.entity.CustomerData;


@Repository
@Transactional
public class CustomerDao {
	@Autowired
	private SessionFactory customerSessionFactory;

	public CustomerData checkCustomerID(long customerId) {
		Session session=customerSessionFactory.openSession();
		
		CustomerData customerData= session.get(CustomerData.class, customerId);
		session.close();
		return customerData;
	}

}
