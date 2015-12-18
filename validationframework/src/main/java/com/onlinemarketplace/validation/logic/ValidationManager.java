/**
 *
 */
package com.onlinemarketplace.validation.logic;

import java.io.File;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

/**
 * @author jitendra Dec 17, 2015 2015
 */
@Component
public interface ValidationManager {
    public Unmarshaller getInstance(String className) throws JAXBException, ClassNotFoundException;

    public Marshaller getInstance(String className, Boolean property) throws JAXBException;

    public Object unMarshaller(String classtoBind, String url) throws JAXBException, ClassNotFoundException;

    public void marshaller(Object object, String url) throws JAXBException;

    public File getClassPathFile(String fileName);
}
