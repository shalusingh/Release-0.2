package com.onlinemarketplace.customer.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@Configurable
@ComponentScan( value={ "com.onlinemarketplace.customer.service"})
@PropertySource(value = { "classpath:product.properties" })
public class CustomerConfig {

	public CustomerConfig() {
		// TODO Auto-generated constructor stub
	}

}
