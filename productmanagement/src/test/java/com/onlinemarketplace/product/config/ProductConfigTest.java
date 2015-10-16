package com.onlinemarketplace.product.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;

@Configurable
@ComponentScan( value={ "com.onlinemarketplace.product.service","com.onlinemarketplace.product.manager"})
@PropertySource(value = { "classpath:product.properties" })
@Import(value = { DataManagementApplicationContext.class })
public class ProductConfigTest {

	public ProductConfigTest() {
		// TODO Auto-generated constructor stub
	}

}
