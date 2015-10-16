package com.onlinemarketplace.datamanagement.serviceimpl.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.domain.ProductSubCategory;
import com.onlinemarketplace.dataentity.enums.Priority;
import com.onlinemarketplace.dataentity.enums.Status;
import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;
import com.onlinemarketplace.datamanagement.service.ProductCategoryService;
import com.onlinemarketplace.datamanagement.service.ProductSubCategoryService;

@ContextConfiguration(classes={DataManagementApplicationContext.class})
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductSubCategoryServiceImpltTest {

	@Autowired
	private ProductSubCategoryService service;
	
	@Autowired
	private ProductCategoryService categoryService;
	
	
	public void insert(){
		ProductSubCategory subCategory = new ProductSubCategory();
		subCategory.setCategoryName("CAR MULTI PLAYERS");
		subCategory.setPriority(Priority.FOUR);
		subCategory.setProductCategory(categoryService.getRepository().getByName("RACING"));
		subCategory.setStatus(Status.ACTIVE);
		
		service.getRepository().save(subCategory);
		
		
		subCategory = new ProductSubCategory();
		subCategory.setCategoryName("GUNS");
		subCategory.setPriority(Priority.FOUR);
		subCategory.setProductCategory(categoryService.getRepository().getByName("ACTION"));
		subCategory.setStatus(Status.ACTIVE);
		service.getRepository().save(subCategory);
		
		subCategory = new ProductSubCategory();
		subCategory.setCategoryName("FIGHT");
		subCategory.setPriority(Priority.FOUR);
		subCategory.setProductCategory(categoryService.getRepository().getByName("ACTION"));
		subCategory.setStatus(Status.ACTIVE);
		service.getRepository().save(subCategory);
		
		
		subCategory = new ProductSubCategory();
		subCategory.setCategoryName("BATTLE FIELD");
		subCategory.setPriority(Priority.FOUR);
		subCategory.setProductCategory(categoryService.getRepository().getByName("ACTION"));
		subCategory.setStatus(Status.ACTIVE);
		service.getRepository().save(subCategory);
	}
	
	@Test
	public void getGet(){
		ProductSubCategory subCategory = null;
		subCategory = service.getRepository().getByName("SIMULATOR");
		assertNotNull(subCategory);;
	}
	
}
