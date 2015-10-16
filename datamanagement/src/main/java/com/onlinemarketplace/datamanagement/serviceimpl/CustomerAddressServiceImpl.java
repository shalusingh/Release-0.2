package com.onlinemarketplace.datamanagement.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.CustomerAddressRepository;
import com.onlinemarketplace.datamanagement.service.CustomerAddressService;

@Service
@Transactional
public class CustomerAddressServiceImpl implements CustomerAddressService {

	
	 @SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	
	@Autowired private CustomerAddressRepository repository;
	
	public CustomerAddressRepository getRepository() {
		return repository;
	}


}
