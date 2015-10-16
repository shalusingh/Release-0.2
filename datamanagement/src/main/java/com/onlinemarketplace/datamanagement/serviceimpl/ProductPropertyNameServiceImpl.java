package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.ProductPropertyNameRepository;
import com.onlinemarketplace.datamanagement.service.ProductPropertyNameService;


@Service
@Transactional
public class ProductPropertyNameServiceImpl implements ProductPropertyNameService   {

	@Autowired
	ProductPropertyNameRepository productPropertyNameRepository;

 
	public ProductPropertyNameRepository getRepository() {
		return productPropertyNameRepository;
	}
	
}
