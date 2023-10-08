package com.finzly.UtilityBill_PaymentPlatform.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finzly.UtilityBill_PaymentPlatform.entity.PaymentType;

@Repository
@Transactional
public class PaymentTypeDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public String addPaymentType(PaymentType paymentType) {
		Session session=sessionFactory.openSession();
		session.save(paymentType);
		session.beginTransaction().commit();
		session.close();
		return "PaymentType data saved successfully";		
	}

	public List<PaymentType> getDiscount(String paymentMode) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(PaymentType.class);
		criteria.add(Restrictions.eq("paymentMode", paymentMode));
		List<PaymentType> listPaymentTypes = criteria.list();
		session.close();
		return listPaymentTypes;
		
		
	}

}
