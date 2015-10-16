package com.onlinemarketplace.cart.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@Configurable
@ComponentScan( value={ "com.onlinemarketplace.cart.service"})
@PropertySource(value = { "classpath:cart.properties" })
public class CarConfig {
	
}
