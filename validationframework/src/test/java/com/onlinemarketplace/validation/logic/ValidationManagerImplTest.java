package com.onlinemarketplace.validation.logic;

import javax.xml.bind.JAXBException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.enums.Status;
import com.onlinemarketplace.dto.domain.CategoryDto;
import com.onlinemarketplace.validation.config.ValidationConfig;
import com.onlinemarketplace.validation.logic.ValidationResult.ResultCode;
import com.onlinemarketplace.validation.parser.ParserManager;

/**
 * @author jitendra Dec 20, 2015 2015
 */

@ContextConfiguration(classes = {
    ValidationConfig.class })
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ValidationManagerImplTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ParserManager parserManager;

    @Test
    public void validate() throws ClassNotFoundException, NullPointerException, JAXBException {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("NewCategory");

        ValidationManagerImpl<CategoryDto, Status> validationManagerImpl =
            new ValidationManagerImpl<CategoryDto, Status>(applicationContext);
        ValidationResult validationResult = validationManagerImpl.validate(categoryDto, parserManager.getValidation(
            "Category"));
        Assert.assertNotNull(validationResult);
        Assert.assertEquals(ResultCode.SUCCESS, validationResult.getCode());

    }

    @Test
    public void validateException() throws ClassNotFoundException, NullPointerException, JAXBException {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("111111");

        ValidationManagerImpl<CategoryDto, Status> validationManagerImpl =
            new ValidationManagerImpl<CategoryDto, Status>(applicationContext);
        ValidationResult validationResult = validationManagerImpl.validate(categoryDto, parserManager.getValidation(
            "Category"));
        Assert.assertNotNull(validationResult);
        Assert.assertEquals(ResultCode.FAILED, validationResult.getCode());

    }

}
