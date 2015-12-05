package com.onlinemarketplace.product.helper;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.domain.ProductProperty;
import com.onlinemarketplace.dataentity.enums.ProductStatus;
import com.onlinemarketplace.datamanagement.service.ProductService;
import com.onlinemarketplace.product.config.ProductConfigTest;
import com.onlinemarketplace.product.manager.CSVManager;

@ContextConfiguration(classes = {
    ProductConfigTest.class })
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CSVManagerTest {

    @Autowired
    CSVManager manager;

    @Autowired
    private ProductService service;

    public static Product init() {

        List<ProductProperty> properties = new ArrayList<ProductProperty>();
        ProductProperty property = new ProductProperty();
        property.setPropertyName("SIZE");
        property.setPropertyValue("7");
        properties.add(property);

        property = new ProductProperty();
        property.setPropertyName("PUBLISHER");
        property.setPropertyValue("EA SPORT");
        properties.add(property);

        Product product = new Product();
        product.setAvailableDate(new Timestamp(System.currentTimeMillis()));
        product.setCastPrice(2500F);
        product.setId(110111L);
        product.setListingPrice(2800f);
        product.setName("NEED FOR SPEED - VI");
        product.setPreOrderStatus(false);
        product.setPrice(2100f);

        product.setProductCode("RACCAR10001");

        product.setQuantity(2);
        product.setStatus(ProductStatus.ACTIVE);
        product.setProductProperty(properties);

        return product;
    }

    public void writeFile() {
        List<Product> products = new ArrayList<Product>();
        products.add(init());
        manager.writeCSV("product.csv", products);
    }

    @Test
    public void read() {
        List<Product> products = manager.readCSV("product.csv");
        Assert.assertEquals(34, products.size());
    }

    @Test
    public void removeCharTest() {
        String name = "\"ID,PRODUCTCODE,STATUS,PROPERTIES,NAME,CATEGORY,INSTOCK\"";
        String result = manager.removeChar(name, '"');
        Assert.assertEquals("ID,PRODUCTCODE,STATUS,PROPERTIES,NAME,CATEGORY,INSTOCK", result);
    }

    @Test
    public void getClassPathFile() {
        File file = manager.getClassPathFile("product.csv");
        Assert.assertEquals(file.getName(), "product.csv");
        Assert.assertNotNull(file);
    }

    @Test

    public void loadDataBase() {
        List<Product> products = manager.readCSV("product.csv");
        int counter = 0;
        try {
            for (Product product : products) {
                product.setId(null);
                product.setStatus(ProductStatus.ACTIVE);

                service.save(product);
                System.out.println(counter++);
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
