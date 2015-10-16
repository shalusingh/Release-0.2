package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.RecntlyViewRepository;
import com.onlinemarketplace.datamanagement.service.RecntlyViewService;


@Service
@Transactional
public class RecntlyViewServiceImpl implements RecntlyViewService  {

	@Autowired
	RecntlyViewRepository recntlyViewRepository;

	 
	public RecntlyViewRepository getRepository() {
		return recntlyViewRepository;
	}

}
