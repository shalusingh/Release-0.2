package com.onlinemarketplace.datamanagement.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.datamanagement.helper.ProductHelper;
import com.onlinemarketplace.datamanagement.repository.ProductRepository;
import com.onlinemarketplace.datamanagement.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService  {
	
	@Autowired
	ProductRepository ProductRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	
	 
	public ProductRepository getRepository() {
		return ProductRepository;
	}


	public EntityManager getEntityManager() {
		 return entityManager;
	}


	 
	@SuppressWarnings("unchecked")
	public List<Product> getByProperyNameAndValue() {
		return entityManager.createNamedQuery("Product.All.Join").getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Product> getByProperyNameAndValue(Map<String, String> param) {
		return entityManager.createQuery(ProductHelper.createQuery(param)).getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Product> getAll() {
		return entityManager.createNamedQuery("Product.All").getResultList();
	}


	public void save(Product product) {
		 entityManager.persist(product);;
	}


	public void saveAll(List<Product> products) {
		// TODO Auto-generated method stub
		
	}

}
