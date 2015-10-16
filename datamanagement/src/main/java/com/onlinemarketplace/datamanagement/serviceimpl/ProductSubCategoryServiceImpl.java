package com.onlinemarketplace.datamanagement.serviceimpl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.ProductSubCategoryRepository;
import com.onlinemarketplace.datamanagement.service.ProductSubCategoryService;

@Service
@Transactional
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService  {

	
	@Autowired
	private ProductSubCategoryRepository productSubCategoryRepository;
	
	@Autowired
	private EntityManager entityManager;
	 
	public ProductSubCategoryRepository getRepository() {
		return productSubCategoryRepository;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
