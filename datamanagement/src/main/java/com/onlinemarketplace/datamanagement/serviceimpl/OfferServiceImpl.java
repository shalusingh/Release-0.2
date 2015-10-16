package com.onlinemarketplace.datamanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.datamanagement.repository.OfferRepository;
import com.onlinemarketplace.datamanagement.service.OfferService;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {
	
	@Autowired
	private OfferRepository offerRepository;

	
	public OfferRepository getRepository() {
		return offerRepository;
	}
	
}
