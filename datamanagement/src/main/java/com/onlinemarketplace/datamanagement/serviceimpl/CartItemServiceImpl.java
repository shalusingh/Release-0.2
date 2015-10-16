package com.onlinemarketplace.datamanagement.serviceimpl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlinemarketplace.datamanagement.repository.CartItemRepository;
import com.onlinemarketplace.datamanagement.service.CartItemService;

public class CartItemServiceImpl implements  CartItemService {
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	private EntityManager entityManager;
	

	public CartItemRepository getRepository() {
		 return cartItemRepository;
	}

	public EntityManager getEntityManager() {
		 return entityManager;
	}

}
