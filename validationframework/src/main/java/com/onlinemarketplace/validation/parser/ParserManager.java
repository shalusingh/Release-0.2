package com.onlinemarketplace.validation.parser;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.onlinemarketplace.validation.model.Field;
import com.onlinemarketplace.validation.model.Validation;

/**
 * @author jitendra Dec 17, 2015 2015
 */
@Component
public interface ParserManager {

    /**
     * This method obtained instance of Unmarshaller.
     * @param className
     *            :{@link String}
     *
     * @return {@link Unmarshaller}
     */
    public Unmarshaller getInstance(String className) throws JAXBException, ClassNotFoundException;

    /**
     * This method obtained instance of Marshaller.
     * @param className
     *            :{@link String}
     * @param property
     *            :{@link Boolean}
     *
     * @return {@link Marshaller }
     *
     * @throws JAXBException
     *
     */
    public Marshaller getInstance(String className, Boolean property) throws JAXBException;

    /**
     * Convert xml file into JAXB Object..
     *
     * @param classtoBind
     *            :{@link String}
     * @param url
     *            :{@link String}
     *
     * @return {@link JAXB }
     *
     * @throws JAXBException
     *
     * @throws ClassNotFoundException
     */
    public Object unMarshaller(String classtoBind, String url) throws JAXBException, ClassNotFoundException;

    /**
     * Convert JAXB object into XML.
     *
     * @param object
     *            :{@link Object}
     * @param url
     *            :{@link String}
     *
     * @return void
     *
     * @throws JAXBException
     */
    public void marshaller(Object object, String url) throws JAXBException;

    /**
     * Get file from class path by given file name.
     *
     * @param fileName
     *            :{@link String}
     *
     * @return {@link File}
     */
    public File getClassPathFile(String fileName);

    /**
     * Get list of all field with all validator list.
     *
     * @param className
     *            :{@link String}
     *
     *
     * @return {@link List< {@link Field }>}
     *
     * @throws JAXBException
     *
     * @throws ClassNotFoundException
     *
     * @throws NullPointerException
     */

    public List<Field> getList(String className) throws ClassNotFoundException, JAXBException, NullPointerException;

    /**
     * Get list of all field with all validator list.
     *
     * @param className
     *            :{@link String}
     *
     *
     * @return {@link Validation>}
     *
     * @throws JAXBException
     *
     * @throws ClassNotFoundException
     *
     * @throws NullPointerException
     */
    public Validation getValidation(String className) throws ClassNotFoundException, JAXBException,
        NullPointerException;
}