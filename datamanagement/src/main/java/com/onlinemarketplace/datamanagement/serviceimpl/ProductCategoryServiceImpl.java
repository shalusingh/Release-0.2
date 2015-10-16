package com.onlinemarketplace.datamanagement.serviceimpl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.ProductCategoryRepository;
import com.onlinemarketplace.datamanagement.service.ProductCategoryService;

@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	private EntityManager entityManager;

	 
	public ProductCategoryRepository getRepository() {
		return productCategoryRepository;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}

}
