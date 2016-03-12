package com.onlinemarketplace.admin.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;

public class SpringMvcInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
            com.onlinemarketplace.admin.config.AppConfig.class, DataManagementApplicationContext.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
            "/" };
    }

}