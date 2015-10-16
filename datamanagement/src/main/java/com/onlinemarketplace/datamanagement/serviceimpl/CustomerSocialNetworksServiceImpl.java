package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.CustomerSocialNetworksRepository;
import com.onlinemarketplace.datamanagement.service.CustomerSocialNetworksService;

@Service
@Transactional
public class CustomerSocialNetworksServiceImpl implements
		CustomerSocialNetworksService {

	@Autowired private CustomerSocialNetworksRepository  repository;

	public CustomerSocialNetworksRepository getRepository() {
		return repository;
	}

	

}
