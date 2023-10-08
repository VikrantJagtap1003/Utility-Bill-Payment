package com.finzly.UtilityBill_PaymentPlatform.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.UtilityBill_PaymentPlatform.entity.BillPaymentDetails;

@Repository
@Transactional
public class BillPaymentDetailsDao {
	@Autowired
	private SessionFactory billPaymentSessionFactory;

	public String addTransaction(BillPaymentDetails billPayment) {

		Session session = billPaymentSessionFactory.openSession();

		session.save(billPayment);
		session.beginTransaction().commit();
		session.close();
		return "Done";
	}

	public List<BillPaymentDetails> viewCashPayments() {
		
		Session session = billPaymentSessionFactory.openSession();
		Criteria criteria=session.createCriteria(BillPaymentDetails.class);
		criteria.add(Restrictions.eq("paymentType","cash"));		
		List<BillPaymentDetails> listBillPaymentDetails = criteria.list();
		session.close();
		return listBillPaymentDetails;
	}
	public List<BillPaymentDetails> getPaymentData(int billid){
		Session session = billPaymentSessionFactory.openSession();
		Criteria criteria=session.createCriteria(BillPaymentDetails.class);
		criteria.add(Restrictions.eq("billId",billid));
		 List<BillPaymentDetails> listBillPaymentDetails = criteria.list();
		 session.close();
		return listBillPaymentDetails;
	}

}
