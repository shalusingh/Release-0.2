package com.onlinemarketplace.datamanagement.serviceimpl.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.domain.ProductCategory;
import com.onlinemarketplace.dataentity.enums.Status;
import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;
import com.onlinemarketplace.datamanagement.service.ProductCategoryService;

@ContextConfiguration(classes = {
    DataManagementApplicationContext.class })
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductCategoryImplTest {

    @Autowired
    private ProductCategoryService service;

    @Test
    public void getProductCategory() {
        ProductCategory category = service.getRepository().getByName("RACING");
        Assert.assertEquals(200001L, Long.parseLong(category.getId()
            + ""));
    }

    public void insert() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("RACING");
        category.setStatus(Status.ACTIVE);

        service.getRepository().save(category);
    }

}
