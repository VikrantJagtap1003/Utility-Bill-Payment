package com.finzly.UtilityBill_PaymentPlatform.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finzly.UtilityBill_PaymentPlatform.entity.InvoiceInfo;

@Repository
@Transactional
public class InvoiceInfoDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addInvoiceInfo(InvoiceInfo invoiceinfo) {
		Session session=sessionFactory.openSession();
		session.save(invoiceinfo);
		session.beginTransaction().commit();
		session.close();
		
	}

	public InvoiceInfo getInvoiceInfo(int billId) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(InvoiceInfo.class);
		criteria.add(Restrictions.eq("billId",billId));
		InvoiceInfo info = (InvoiceInfo) criteria.list().get(0);
		session.close();
		return info;
	}
	
}
