package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.OrderItemDeliveryRepository;
import com.onlinemarketplace.datamanagement.service.OrderItemDeliveryService;

@Service
@Transactional
public class OrderItemDeliveryServiceImpl implements OrderItemDeliveryService  {

	@Autowired
	OrderItemDeliveryRepository orderItemDeliveryRepository;
	
	
	public OrderItemDeliveryRepository getRepository() {
		return orderItemDeliveryRepository;
	}

}
