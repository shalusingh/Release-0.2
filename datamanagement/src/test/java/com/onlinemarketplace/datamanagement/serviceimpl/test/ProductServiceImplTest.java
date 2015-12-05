package com.onlinemarketplace.datamanagement.serviceimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.domain.ProductCategory;
import com.onlinemarketplace.dataentity.domain.ProductSubCategory;
import com.onlinemarketplace.dataentity.domain.SubSubCategory;
import com.onlinemarketplace.dataentity.enums.ProductStatus;
import com.onlinemarketplace.dataentity.enums.Status;
import com.onlinemarketplace.datamanagement.config.DataManagementApplicationContext;
import com.onlinemarketplace.datamanagement.service.ProductCategoryService;
import com.onlinemarketplace.datamanagement.service.ProductService;
import com.onlinemarketplace.datamanagement.service.ProductSubCategoryService;
import com.onlinemarketplace.datamanagement.service.SubSubCategoryService;

@ContextConfiguration(classes = {
    DataManagementApplicationContext.class })
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductService service;

    @Autowired
    ProductCategoryService pService;

    @Autowired
    ProductSubCategoryService subCategoryService;

    @Autowired
    SubSubCategoryService subSubCategoryService;

    @Test
    public void getAll() {
        List<Product> products = service.getRepository().findAll();
        assertNotNull(products);
        assertEquals(34, products.size());
    }

    @Test
    public void getByCategory() {
        List<Product> products = service.getRepository().getByCategory(4L);
        assertEquals(4, products.size());
    }

    @Test
    public void getBySubCategory() {
        List<Product> products = service.getRepository().getBySubCategory(2);
        assertEquals(7, products.size());
        assertNotNull(products);
    }

    @Test
    public void getBySubCategoryNull() {
        List<Product> products = service.getRepository().getBySubCategory(22);
        assertEquals(true, products.isEmpty());
    }

    @Test
    public void getByCategoryAndSubCategoryAndPrice() {
        List<Product> products = service.getRepository().getByCategoryAndSubCategoryAndPrice(10003, 2, 1000, 2000);
        assertNotNull(products);
        assertEquals(2, products.size());
    }

    @Test
    public void likeName() {
        List<Product> products = service.getRepository().likeName("Need");
        assertNotNull(products);
        assertEquals(7, products.size());
    }

    @Test
    public void getByCategoryLike() {
        List<Product> products = service.getRepository().getByCategory("Need", 10003);
        assertNotNull(products);
        assertEquals(7, products.size());
    }

    @Test
    public void getByCategoryLikeNull() {
        List<Product> products = service.getRepository().getByCategory("Need", 4);
        assertEquals(true, products.isEmpty());

    }

    @Test
    public void getProduct() {
        assertNotNull(service.getRepository().findOne(1L));
    }

    public void insertProduct() {
        Product product = new Product();
        ProductCategory category = new ProductCategory();
        ProductSubCategory subCategory = new ProductSubCategory();
        List<SubSubCategory> subSubCategories = new ArrayList<SubSubCategory>();
        List<ProductSubCategory> subCategories = new ArrayList<ProductSubCategory>();
        List<ProductCategory> categories = new ArrayList<ProductCategory>();
        SubSubCategory subSubCategory = new SubSubCategory();
        /* --------------------------------------------------------- */
        subSubCategory.setCategoryName("SubSubCategory");
        subSubCategory.setSubCategory(subCategory);
        subSubCategories.add(subSubCategory);

        /* ---------------------------------------------------------- */
        subCategory.setCategoryName("subcategory");
        subCategory.setCategory(category);
        subCategory.setSubSubCategory(subSubCategories);
        subCategories.add(subCategory);
        /* --------------------------------------------------------- */

        category.setCategoryName("categoryName");
        category.setSubCategory(subCategories);
        category.setStatus(Status.ACTIVE);
        categories.add(category);

        product.setAvailableDate(new Timestamp(System.currentTimeMillis()));
        product.setCastPrice(122F);
        product.setListingPrice(140f);
        product.setName("New Product");
        product.setPreOrderStatus(true);
        product.setPrice(125f);
        product.setProductCategory(pService.getRepository().getByName("RACING"));
        product.setProductCode("CODE12");
        product.setQuantity(1);
        product.setProductSubCategory(subCategoryService.getRepository().getByName("CAR"));

        product.setStatus(ProductStatus.ACTIVE);

        service.save(product);

    }

}
