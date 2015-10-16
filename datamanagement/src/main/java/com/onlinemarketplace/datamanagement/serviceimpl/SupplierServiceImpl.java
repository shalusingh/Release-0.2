package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.SupplierRepository;
import com.onlinemarketplace.datamanagement.service.SupplierService;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierRepository supplierRepository;

	 
	public SupplierRepository getRepository() {
		return supplierRepository;
	}

}
