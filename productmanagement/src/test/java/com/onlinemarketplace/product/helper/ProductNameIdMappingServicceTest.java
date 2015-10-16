package com.onlinemarketplace.product.helper;

import java.io.File;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.product.config.ProductConfigTest;
import com.onlinemarketplace.product.service.ProductNameIdMappingService;

@ContextConfiguration(classes={ProductConfigTest.class})
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductNameIdMappingServicceTest {
	
	@Autowired
	private ProductNameIdMappingService service;

	@Test
	public void getMapping(){
		File file = service.getClassPathFile("nameidmapping.csv");
		ProductNameIdMappingService.setFile(file);
		Map<String, Long> mapping =  ProductNameIdMappingService.getMapping();
		assertEquals(34, mapping.size() );
	}
	
	
	@Test
	public void getIDFromName(){
		File file = service.getClassPathFile("nameidmapping.csv");
		ProductNameIdMappingService.setFile(file);
		Map<String, Long> mapping =  ProductNameIdMappingService.getMapping();
		Long Id = mapping.get("FIFA Football 2002");
		assertEquals("110119", ""+Id);
	}

}
