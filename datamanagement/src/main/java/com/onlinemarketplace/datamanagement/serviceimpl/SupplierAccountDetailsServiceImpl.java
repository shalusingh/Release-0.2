package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.SupplierAccountDetailsRepository;
import com.onlinemarketplace.datamanagement.service.SupplierAccountDetailsService;


@Service
@Transactional
public class SupplierAccountDetailsServiceImpl implements SupplierAccountDetailsService   {

	@Autowired
	SupplierAccountDetailsRepository supplierAccountDetailsRepository;

	 
	public SupplierAccountDetailsRepository getRepository() {
		// TODO Auto-generated method stub
		return supplierAccountDetailsRepository;
	}
	
	
}
