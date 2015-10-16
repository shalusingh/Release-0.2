package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.CartRepository;
import com.onlinemarketplace.datamanagement.service.CartService;


@Service
@Transactional
public class CartServiceImpl implements CartService  {
	
	@Autowired 
	CartRepository shopplingCartRepository;

	 
	public CartRepository getRepository() {
		// TODO Auto-generated method stub
		return shopplingCartRepository;
	}

}
