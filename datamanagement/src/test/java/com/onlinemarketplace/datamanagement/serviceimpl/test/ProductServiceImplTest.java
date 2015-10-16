package com.onlinemarketplace.datamanagement.serviceimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;
import com.onlinemarketplace.datamanagement.service.ProductService;

@ContextConfiguration(classes={DataManagementApplicationContext.class})
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {
	
	@Autowired
	private ProductService  service;
	
	
	@Test
	public void getAll(){
		List<Product> products = service.getRepository().findAll();
		assertNotNull(products);
		assertEquals(34, products.size());
	}
	
	
	@Test
	public void getByCategory(){
		List<Product> products = service.getRepository().getByCategory(4L);
		assertEquals(4, products.size());
	}
	
	@Test
	public void getBySubCategory(){
		List<Product> products = service.getRepository().getBySubCategory( 2);
		assertEquals(7, products.size());
		assertNotNull(products) ;
	}
	
	@Test
	public void getBySubCategoryNull(){
		List<Product> products = service.getRepository().getBySubCategory(22);
		assertEquals(true,products.isEmpty() ) ;
	}
	
	@Test
	public void getByCategoryAndSubCategoryAndPrice(){
		List<Product> products = service.getRepository().getByCategoryAndSubCategoryAndPrice(10003,2,1000,2000);
		assertNotNull(products) ;
		assertEquals(2, products.size());
	}
	
	@Test
	public void likeName(){
		List<Product> products = service.getRepository().likeName("Need");
		assertNotNull(products) ;
		assertEquals(7, products.size());
	}
	
	@Test
	public void getByCategoryLike(){
		List<Product> products = service.getRepository().getByCategory("Need",10003);
		assertNotNull(products) ;
		assertEquals(7, products.size());
	}
	
	@Test
	public void getByCategoryLikeNull(){
		List<Product> products = service.getRepository().getByCategory("Need",4);
		assertEquals(true, products.isEmpty());
		
	}
	
	@Test
	public void getProduct(){
		assertNotNull( service.getRepository().findOne(1L)); 
	}
	
	
}
