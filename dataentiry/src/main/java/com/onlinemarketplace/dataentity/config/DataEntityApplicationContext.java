package com.onlinemarketplace.dataentity.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan( value={ "com.onlinemarketplace.dataentity.domain","com.onlinemarketplace.dataentity.dto"})
public class DataEntityApplicationContext {

}
