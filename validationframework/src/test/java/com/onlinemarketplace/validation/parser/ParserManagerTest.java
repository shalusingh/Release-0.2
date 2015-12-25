/**
 *
 */
package com.onlinemarketplace.validation.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.validation.config.ValidationConfig;
import com.onlinemarketplace.validation.model.Field;
import com.onlinemarketplace.validation.model.Validation;
import com.onlinemarketplace.validation.model.Validations;

/**
 * @author jitendra Dec 17, 2015 2015
 */
@ContextConfiguration(classes = {
    ValidationConfig.class })
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ParserManagerTest {

    @Autowired
    private ParserManager manager;

    @Autowired
    private Environment environment;

    @Test
    public void getXml() throws XmlMappingException, IOException, JAXBException, ClassNotFoundException {
        Validations validations = (Validations) manager.unMarshaller(
            "com.onlinemarketplace.validation.model.Validations", environment.getProperty("ProductCategory"));
        Assert.assertEquals(3, validations.getList().size());
        Assert.assertEquals("Category", validations.getList().get(0).getDomainClassName());
    }

    @Test
    public void readPropertyfile() {
        Assert.assertEquals("CategoryValidationConfig.xml", environment.getProperty("ProductCategory"));
    }

    @Test
    public void getFile() {
        File file = manager.getClassPathFile(environment.getProperty("ProductCategory"));
        Assert.assertNotNull(file);
        Assert.assertEquals("CategoryValidationConfig.xml", file.getName());
    }

    @Test
    public void getValidationList() throws ClassNotFoundException, NullPointerException, JAXBException {
        List<Field> fields = manager.getList("Category");
        Assert.assertNotNull(fields);
        Assert.assertEquals(1, fields.size());
    }

    @Test
    public void getValidation() throws ClassNotFoundException, NullPointerException, JAXBException {
        Validation validation = manager.getValidation("Category");
        Assert.assertNotNull(validation);
        Assert.assertEquals(1, validation.getFields().size());
    }

}
