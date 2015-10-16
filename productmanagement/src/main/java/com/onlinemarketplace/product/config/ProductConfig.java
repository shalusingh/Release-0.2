package com.onlinemarketplace.product.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@Configurable
@ComponentScan( value={ "com.onlinemarketplace.product.service","com.onlinemarketplace.product.manager"})
@PropertySource(value = { "classpath:product.properties" })
public class ProductConfig {

}
