/**
 *
 */
package com.onlinemarketplace.validation.logic;

import java.io.File;
import java.io.IOException;

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
import com.onlinemarketplace.validation.model.Validations;

/**
 * @author jitendra Dec 17, 2015 2015
 */
@ContextConfiguration(classes = {
    ValidationConfig.class })
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ValidationManagerTest {

    @Autowired
    ValidationManager manager;

    @Autowired
    Environment environment;

    @Test
    public void getXml() throws XmlMappingException, IOException, JAXBException, ClassNotFoundException {
        Validations validations = (Validations) manager.unMarshaller(
            "com.onlinemarketplace.validation.model.Validations", environment.getProperty("ProductCategory"));
        Assert.assertEquals(1, validations.getList().size());
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

}
