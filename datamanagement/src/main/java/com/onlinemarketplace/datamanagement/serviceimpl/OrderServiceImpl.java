package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.OrderReopsitory;
import com.onlinemarketplace.datamanagement.service.OrderService;


@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderReopsitory orderReopsitory;
	
	public OrderReopsitory getReopsitory() {
		return orderReopsitory;
	}

	
}
