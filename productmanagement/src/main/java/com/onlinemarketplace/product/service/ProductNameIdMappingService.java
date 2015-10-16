package com.onlinemarketplace.product.service;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.onlinemarketplace.product.manager.ProductNameIdMappingManager;

@Service
public class ProductNameIdMappingService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductNameIdMappingService.class);

	/** variable to store mapping in memmory.*/
	private static Map<String,Long> mapping = new Hashtable<String,Long>();

	/** File object.*/
	private static File file;
	
	/** from data base variable. */
	private boolean fromDB = false;

	/** ProductNameIdMappingManager. */
	private static ProductNameIdMappingManager manager;
	

	@Autowired
	private ApplicationContext appContext;
	
	
	static{
		manager = new ProductNameIdMappingManager();
	}
	
	/**
	 * Get Name and Id Mapping If mappins is empty and read from csv file.
	 * 
	 * @return Map<String,Long> mapping. 
	 */	
	public static Map<String,Long> getMapping(){
		if(mapping == null || mapping.isEmpty() ){
			mapping = manager.getMappingFromCSV(file);
		}
		return mapping;
	}

	/**
	 *  Get file.
	 *  
	 *  @return File.
	 */
	public static File getFile() {
		return file;
	}


	/**
	 *  Set file variable.
	 *  
	 *  @param file : {@link File}
	 */
	public static void setFile(File file) {
		ProductNameIdMappingService.file = file;
	}


	/**
	 * Get fromDB variable.
	 * 
	 * @return fromDB : {@link Boolean}
	 */
	public boolean isFromDB() {
		return fromDB;
	}


	/**
	 * Set fromDB Variable.
	 * 
	 * @param fromDB {@link Boolean}
	 */
	public void setFromDB(boolean fromDB) {
		this.fromDB = fromDB;
	}
	
	public File getClassPathFile(String fileName){
		File file = null;
		Resource resource = appContext.getResource("classpath:"+fileName);
		try{
			if(resource.exists()){
				file = resource.getFile();
			}else{
				resource = appContext.getResource("classpath:product.properties");
				resource = resource.createRelative("product.csv");
				
			}
		}catch(IOException ioException){
			LOGGER.info(" >>> Unable to file file in class path");
		}
		return file;
	}
	
}
