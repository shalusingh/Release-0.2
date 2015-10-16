package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl {	
	
	@Autowired CustomerRepository customerRepository;
	
}
