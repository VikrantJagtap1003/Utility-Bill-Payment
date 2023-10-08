package com.finzly.UtilityBill_PaymentPlatform.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.finzly.UtilityBill_PaymentPlatform.entity.OTP;

@Repository
@Transactional
public class OTPDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<OTP> generateOTP() {
		
		Session otpSession=sessionFactory.openSession();
		Criteria otpCriteria=otpSession.createCriteria(OTP.class);
		otpCriteria.add(Restrictions.eq("isInUse",false));
		List<OTP> otpList = otpCriteria.list();
		otpSession.close();
		return otpList;
		
	}

	public String addOTP(OTP otp) {
		
		Session otpSession=sessionFactory.openSession();
		otpSession.save(otp);
		otpSession.beginTransaction().commit();
		otpSession.close();
		return "Data added successfully";
		
	}

}
