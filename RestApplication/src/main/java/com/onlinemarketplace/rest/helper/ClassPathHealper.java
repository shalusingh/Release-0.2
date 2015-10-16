package com.onlinemarketplace.rest.helper;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

public class ClassPathHealper {
	private static final Logger logger = LoggerFactory.getLogger(ClassPathHealper.class);
	
	public static File getClassPathFile(String fileName, final ApplicationContext applicationContext){
		File file = null;
		Resource resource = applicationContext.getResource("classpath:"+fileName);
		try{
			System.out.println( resource.getURI() );
			if(resource.exists()){
				file = resource.getFile();
			}
		}catch(IOException ioException){
			logger.info(" >>> Unable to file file in class path");
		}
		return file;
	}

}
