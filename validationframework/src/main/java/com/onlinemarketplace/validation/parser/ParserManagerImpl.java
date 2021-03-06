package com.onlinemarketplace.validation.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.onlinemarketplace.validation.model.Field;
import com.onlinemarketplace.validation.model.Validation;
import com.onlinemarketplace.validation.model.Validations;

/**
 * @author jitendra Dec 17, 2015 2015
 */

public class ParserManagerImpl
    implements ParserManager {

    /** logger. */
    private static final Logger logger = Logger.getLogger(ParserManagerImpl.class);

    private static final String validation = "com.onlinemarketplace.validation.model.Validations";

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private Environment environment;

	public Unmarshaller getInstance(String className) throws JAXBException, ClassNotFoundException {
		 return JAXBContext.newInstance(Class.forName(className)).createUnmarshaller();
	}

	public Marshaller getInstance(String className, Boolean property) throws JAXBException {
		 Marshaller marshaller = JAXBContext.newInstance(className).createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, property);
	        return marshaller;
	}

	public Object unMarshaller(String classtoBind, String url) throws JAXBException, ClassNotFoundException {
		File file = getClassPathFile(url);
        return getInstance(classtoBind).unmarshal(file);
	}

	public void marshaller(Object object, String url) throws JAXBException {
		 Marshaller marshaller = getInstance(object.getClass().getName(), true);
	        marshaller.marshal(object, System.out);
		
	}

	public File getClassPathFile(String fileName) {
		File file = null;
        Resource resource = appContext.getResource("classpath:"
            + fileName);
        try {
            if (resource.exists()) {
                file = resource.getFile();
            } else {
                resource = appContext.getResource("classpath:"
                    + fileName);
                resource = resource.createRelative(fileName);

            }
        } catch (IOException ioException) {
            logger.info(" >>> Unable to file file in class path");
            ioException.printStackTrace();
        }
        return file;
	}

	public List<Field> getList(String className) throws ClassNotFoundException, JAXBException, NullPointerException {
		Validations validations;

        validations = (Validations) unMarshaller(ParserManagerImpl.validation, environment.getProperty(
            "ProductCategory"));
        if (validations.getList() == null)
            throw new NullPointerException("No Validation found.");

        for (Validation validation : validations.getList()) {
            String name = validation.getDomainClassName();
            if (className.trim().equalsIgnoreCase(name.trim())) {
                return validation.getFields();
            }
        }

        return null;
	}

	public Validation getValidation(String className)
			throws ClassNotFoundException, JAXBException, NullPointerException {
		 Validations validations;

	        validations = (Validations) unMarshaller(ParserManagerImpl.validation, environment.getProperty(
	            "ProductCategory"));
	        if (validations.getList() == null)
	            throw new NullPointerException("No Validation found.");

	        for (Validation validation : validations.getList()) {
	            String name = validation.getDomainClassName();
	            if (className.trim().equalsIgnoreCase(name.trim())) {
	                return validation;
	            }
	        }

	        return null;
	}

	
	
	
	 
 
	    
	    
   
}