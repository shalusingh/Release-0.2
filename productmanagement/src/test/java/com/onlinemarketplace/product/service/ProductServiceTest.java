package com.onlinemarketplace.product.service;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.datamanagement.repository.ProductRepository;
import com.onlinemarketplace.product.config.ProductConfigTest;
import com.onlinemarketplace.product.manager.CSVManager;

@ContextConfiguration(classes = {
    ProductConfigTest.class })
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService service;

    @Autowired
    private CSVManager manager;

    @Before
    public void setRepository() {
        service.setRepository(repository);
        service.setFile(manager.getClassPathFile("product.csv"));
    }

    @Test
    public void getProduct() {

        Map<Long, Product> products = service.getProduct();
        Assert.assertNotNull(products);
        Assert.assertEquals(34, products.size());
    }

    @Test
    public void getByPropertyNameAndValue() {

        List<Product> products = service.getByPropertyNameAndValue("PUBLISHER", "Electronic Arts");
        Assert.assertEquals(7, products.size());
    }

    @Test
    public void inStock() {
        List<Product> products = service.inStock();
        Assert.assertEquals(31, products.size());
    }

    @Test
    public void outOfStock() {
        List<Product> products = service.outOfStock();
        Assert.assertEquals(3, products.size());
    }

    @Test
    public void testSortedAndPagingProduct() {

        service.getSortedAndPagingProduct(null, 1, 10);
    }

    @Test
    public void testGetByCategory() {
        List<Product> products = service.getByCategory("RACING");
        Assert.assertNotNull(products);
        Assert.assertEquals(8, products.size());
    }

    @Test
    @Ignore
    public void testGetBySubCategory() {

        List<Product> products = service.getBySubCategory("CAR");
        Assert.assertNotNull(products);
        Assert.assertEquals(7, products.size());
    }

    @Test
    public void testGetByBoth() {

        List<Product> products = service.getByCategory("RACING");
        Assert.assertNotNull(products);
        Assert.assertEquals(8, products.size());

        products = service.getBySubCategory(products, "CAR");
        Assert.assertNotNull(products);
        Assert.assertEquals(7, products.size());
    }

    @Test
    public void getByPrice() {
        List<Product> products = service.getByPrice(2500F, 3000F);
        Assert.assertNotNull(products);
        Assert.assertEquals(3, products.size());
    }

}
