package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.SupplierAddressRepository;
import com.onlinemarketplace.datamanagement.service.SupplierAddressService;


@Service
@Transactional
public class SupplierAddressServiceImpl implements SupplierAddressService  {
	
	@Autowired
	SupplierAddressRepository supplierAddressRepository;

	 
	public SupplierAddressRepository getRepository() {
		return supplierAddressRepository;
	}
	
	

}
