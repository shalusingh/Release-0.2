package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.WishListRepository;
import com.onlinemarketplace.datamanagement.service.WishListService;


@Service
@Transactional
public class WishListServiceImpl implements WishListService  {
	
	@Autowired
	WishListRepository wishListRepository;

	 
	public WishListRepository getRepository() {
		return wishListRepository;
	}
	
	

}
