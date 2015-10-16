package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.OrderItemsRepository;
import com.onlinemarketplace.datamanagement.service.OrderItemsService;



@Service
@Transactional
public class OrderItemsServiceImpl implements OrderItemsService  {
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;

	
	public OrderItemsRepository getReopsitory() {
		return orderItemsRepository;
	}

}
