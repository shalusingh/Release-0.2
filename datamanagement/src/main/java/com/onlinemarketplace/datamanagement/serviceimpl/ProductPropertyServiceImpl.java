package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.ProductPropertyRepository;
import com.onlinemarketplace.datamanagement.service.ProductPropertyService;


@Service
@Transactional
public class ProductPropertyServiceImpl implements ProductPropertyService  {

	@Autowired
	ProductPropertyRepository productPropertyRepository;
	
	 
	public ProductPropertyRepository getRepository() {
				return productPropertyRepository;
	}

}
