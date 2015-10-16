package com.onlinemarketplace.customer.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;

@Configurable
@ComponentScan( value={ "com.onlinemarketplace.customer.service",})
@PropertySource(value = { "classpath:customer.properties" })
@Import(value = { DataManagementApplicationContext.class })
public class CustomerConfigTest {

	
}
