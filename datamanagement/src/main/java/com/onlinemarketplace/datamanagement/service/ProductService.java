package com.onlinemarketplace.datamanagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.datamanagement.repository.ProductRepository;

@Service
@Transactional
public interface ProductService extends BaseService<ProductRepository> {
	
	 public List<Product> getByProperyNameAndValue();
	 public List<Product> getByProperyNameAndValue(Map<String, String> param);
	 
	 public List<Product> getAll();
	 
	 public void save(Product product);
	 public void saveAll(List<Product> products);
		 
}
