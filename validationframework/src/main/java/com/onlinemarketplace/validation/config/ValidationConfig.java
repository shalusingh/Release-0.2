package com.onlinemarketplace.validation.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.onlinemarketplace.validation.parser.ParserManager;
import com.onlinemarketplace.validation.parser.ParserManagerImpl;

/**
 * @author jitendra Dec 17, 2015 2015
 */
@Configurable
@ComponentScan(value = { "com.onlinemarketplace.validation.model.logic" })
@PropertySource(value = { "classpath:mapper.properties" })
public class ValidationConfig {

    @Bean
    public ParserManager validationManager() {
        return new ParserManagerImpl();
    }

}