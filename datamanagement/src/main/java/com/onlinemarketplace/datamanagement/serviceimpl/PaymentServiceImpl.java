package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.PaymentRepository;
import com.onlinemarketplace.datamanagement.service.PaymentService;



@Service
@Transactional
public class PaymentServiceImpl implements PaymentService  {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	 
	 
	public PaymentRepository getRepository() {
		return paymentRepository;
	}

}
