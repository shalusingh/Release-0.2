package com.onlinemarketplace.datamanagement.service;

import org.springframework.stereotype.Service;

import com.onlinemarketplace.datamanagement.repository.CustomerRepository;

@Service
public interface CustomerService {
	public CustomerRepository getRepository();
}
