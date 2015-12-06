package com.onlinemarketplace.datamanagement.serviceimpl.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.domain.ProductSubCategory;
import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;
import com.onlinemarketplace.datamanagement.service.ProductCategoryService;
import com.onlinemarketplace.datamanagement.service.ProductSubCategoryService;

@ContextConfiguration(classes = {
    DataManagementApplicationContext.class })
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductSubCategoryServiceImpltTest {

    @Autowired
    private ProductSubCategoryService service;

    @Autowired
    private ProductCategoryService categoryService;

    public void insert() {
        ProductSubCategory subCategory = new ProductSubCategory();
        subCategory.setCategoryName("CAR MULTI PLAYERS");
        subCategory.setCategory(categoryService.getRepository().getByName("RACING"));

        service.getRepository().save(subCategory);

        subCategory = new ProductSubCategory();
        subCategory.setCategoryName("GUNS");
        subCategory.setCategory(categoryService.getRepository().getByName("RACING"));

        service.getRepository().save(subCategory);

        subCategory = new ProductSubCategory();
        subCategory.setCategoryName("FIGHT");
        subCategory.setCategory(categoryService.getRepository().getByName("RACING"));

        service.getRepository().save(subCategory);

        subCategory = new ProductSubCategory();
        subCategory.setCategoryName("BATTLE FIELD");

        subCategory.setCategory(categoryService.getRepository().getByName("RACING"));

        service.getRepository().save(subCategory);
    }

    @Test
    public void getGet() {
        ProductSubCategory subCategory = null;
        subCategory = service.getRepository().getByName("SIMULATOR");
        assertNotNull(subCategory);
        ;
    }

    @Test
    public void getSubCategory() {
        ProductSubCategory subCategory = null;
        subCategory = service.getRepository().getByName("KIDS", categoryService.getRepository().getByName(
            "EDUCATION"));
        assertNotNull(subCategory);
        Assert.assertEquals(new Long(210006L), subCategory.getId());
    }

    @Test(expected = IncorrectResultSizeDataAccessException.class)
    public void getSubCategoryException() {
        ProductSubCategory subCategory = null;
        subCategory = service.getRepository().getByName("KIDS");

        assertNotNull(subCategory);
        Assert.assertEquals(new Long(210001L), subCategory.getId());
    }

}
