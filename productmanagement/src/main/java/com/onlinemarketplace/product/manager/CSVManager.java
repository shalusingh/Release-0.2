package com.onlinemarketplace.product.manager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.domain.ProductProperty;
import com.onlinemarketplace.datamanagement.service.ProductCategoryService;
import com.onlinemarketplace.datamanagement.service.ProductService;
import com.onlinemarketplace.datamanagement.service.ProductSubCategoryService;

@Service
public class CSVManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSVManager.class);

    CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    ProductService productService;

    @Autowired
    ProductCategoryService categoryService;

    @Autowired
    ProductSubCategoryService subCategoryService;

    @SuppressWarnings("unused")
    @Transactional(readOnly = true)
    public boolean writeCSV(String fileName, List<Product> list) {
        boolean result = false;
        CSVPrinter printer = null;
        LOGGER.info(" >>> Start writteng in csv file");
        boolean writeHeader = true;
        StringBuffer headers = new StringBuffer();
        FileWriter writer = null;
        try {
            writer = new FileWriter(getClassPathFile("product.csv"));
            printer = new CSVPrinter(writer, format);

            printer.printRecord("ID", "PRODUCTCODE", "NAME", "CATEGORY", "SUBCATEGORY", "LISTINGPRICE", "CASTPRICE",
                "PRIORITY", "PREORDERSTATUS", "AVAIBLEDATE", "PRICE", "QUANTITY", "PROPERTIES");

            for (Product product : list) {
                List<String> productData = new ArrayList<String>();
                productData.add(product.getId().toString());
                productData.add(product.getProductCode());
                productData.add(product.getName());
                productData.add(product.getProductCategory().toString());
                productData.add(product.getProductSubCategory().toString());
                productData.add(product.getListingPrice()
                    + "");
                productData.add(product.getCastPrice()
                    + "");

                productData.add(product.isPreOrderStatus()
                    + "");
                productData.add(product.getAvailableDate()
                    + "");
                productData.add(product.getPrice().toString());
                productData.add(product.getQuantity()
                    + "");
                productData.add(ProductProperty.toString(product.getProductProperty()));

                printer.printRecord(productData);
            }
            result = true;
        } catch (IOException ioException) {
            LOGGER.error("Unable to write data in csv file.", ioException);
            ioException.printStackTrace();
        } catch (Exception exception) {
            LOGGER.error("Unable to write data in csv file.", exception);
            exception.printStackTrace();
        } finally {
            try {
                if (printer != null)
                    printer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            LOGGER.info(" >>> End writteng in csv file");
        }
        return result;
    }

    @SuppressWarnings("unused")
    @Transactional(readOnly = true)
    public boolean writeCSV(File file, List<Product> list) {
        boolean result = false;
        CSVPrinter printer = null;
        LOGGER.info(" >>> Start writteng in csv file");
        boolean writeHeader = true;
        StringBuffer headers = new StringBuffer();
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            printer = new CSVPrinter(writer, format);

            printer.printRecord("ID", "PRODUCTCODE", "NAME", "CATEGORY", "SUBCATEGORY", "LISTINGPRICE", "CASTPRICE",
                "PRIORITY", "PREORDERSTATUS", "AVAIBLEDATE", "PRICE", "QUANTITY", "PROPERTIES");

            for (Product product : list) {
                List<String> productData = new ArrayList<String>();
                productData.add(product.getId().toString());
                productData.add(product.getProductCode());
                productData.add(product.getName());
                productData.add(product.getProductCategory().getCategoryName());
                productData.add(product.getProductSubCategory().toString());
                productData.add(product.getListingPrice()
                    + "");
                productData.add(product.getCastPrice()
                    + "");
                productData.add(product.isPreOrderStatus()
                    + "");
                productData.add(product.getAvailableDate()
                    + "");
                productData.add(product.getPrice().toString());
                productData.add(product.getQuantity()
                    + "");
                productData.add(ProductProperty.toString(product.getProductProperty()));

                printer.printRecord(productData);
            }
            result = true;
        } catch (IOException ioException) {
            LOGGER.error("Unable to write data in csv file.", ioException);
            ioException.printStackTrace();
        } catch (Exception exception) {
            LOGGER.error("Unable to write data in csv file.", exception);
            exception.printStackTrace();
        } finally {
            try {
                if (printer != null)
                    printer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            LOGGER.info(" >>> End writteng in csv file");
        }
        return result;
    }

    @Transactional(readOnly = true)
    public List<Product> readCSV(String fileName) {
        CSVParser parser = null;
        Product product = null;
        List<Product> productDtos = new ArrayList<Product>();
        ProductProperty productProperty = new ProductProperty();
        List<ProductProperty> productProperties = new ArrayList<ProductProperty>();
        try {
            parser = new CSVParser(new FileReader(getClassPathFile(fileName)), format);
            for (CSVRecord record : parser) {

                product = new Product();

                product.setId(Long.parseLong(record.get("ID")));
                product.setProductCode(record.get("PRODUCTCODE"));
                product.setName(record.get("NAME"));
                product.setProductCategory(categoryService.getRepository().getByName(record.get("CATEGORY")));

                product.setProductSubCategory(subCategoryService.getRepository().getByName(record.get("SUBCATEGORY"),
                    product.getProductCategory()));

                product.setListingPrice(Float.parseFloat(record.get("LISTINGPRICE")));
                product.setCastPrice(Float.parseFloat(record.get("CASTPRICE")));

                product.setPreOrderStatus(Boolean.parseBoolean(record.get("PREORDERSTATUS")));
                product.setPrice(Float.parseFloat(record.get("PRICE")));
                product.setQuantity(Integer.parseInt(record.get("QUANTITY")));

                if (record.get("PROPERTIES") != null) {
                    productProperties = new ArrayList<ProductProperty>();

                    String[] prStrings = record.get("PROPERTIES").split("/");
                    for (String string : prStrings) {
                        if (string != null
                            && !string.isEmpty()) {
                            productProperty = new ProductProperty();
                            String[] propertyMap = string.split("=");
                            productProperty.setPropertyName(propertyMap[0]);
                            productProperty.setPropertyValue(propertyMap[1]);
                            productProperty.setProduct(product);
                            productProperties.add(productProperty);
                        }
                    }
                    product.setProductProperty(productProperties);
                    ;
                }

                productDtos.add(product);

            }
        } catch (IOException ioException) {
            LOGGER.error("Unable to write data in csv file.", ioException);
            ioException.printStackTrace();
        } catch (Exception exception) {
            LOGGER.error("Unable to write data in csv file.", exception);
            System.out.println(exception);
        } finally {
            try {
                if (parser != null)
                    parser.close();
            } catch (Exception e) {
            }
        }
        return productDtos;
    }

    @Transactional(readOnly = true)
    public List<Product> readCSV(File file) {
        CSVParser parser = null;
        Product product = null;
        List<Product> products = new ArrayList<Product>();
        ProductProperty productProperty = new ProductProperty();
        List<ProductProperty> productProperties = new ArrayList<ProductProperty>();
        try {
            parser = new CSVParser(new FileReader(file), format);
            for (CSVRecord record : parser) {

                product = new Product();

                product.setId(Long.parseLong(record.get("ID")));
                product.setProductCode(record.get("PRODUCTCODE"));
                product.setName(record.get("NAME"));
                product.setProductCategory(categoryService.getRepository().getByName(record.get("CATEGORY")));

                product.setProductSubCategory(subCategoryService.getRepository().getByName(record.get(
                    "SUBCATEGORY")));

                product.setListingPrice(Float.parseFloat(record.get("LISTINGPRICE")));
                product.setCastPrice(Float.parseFloat(record.get("CASTPRICE")));

                product.setPreOrderStatus(Boolean.parseBoolean(record.get("PREORDERSTATUS")));
                product.setPrice(Float.parseFloat(record.get("PRICE")));
                product.setQuantity(Integer.parseInt(record.get("QUANTITY")));

                if (record.get("PROPERTIES") != null) {
                    productProperties = new ArrayList<ProductProperty>();
                    String[] prStrings = record.get("PROPERTIES").split("/");
                    for (String string : prStrings) {
                        if (string != null
                            && !string.isEmpty()) {
                            productProperty = new ProductProperty();
                            String[] propertyMap = string.split("=");
                            productProperty.setPropertyName(propertyMap[0]);
                            productProperty.setPropertyValue(propertyMap[1]);
                            productProperties.add(productProperty);
                        }
                    }
                    product.setProductProperty(productProperties);
                    ;
                }
                products.add(product);
            }
        } catch (IOException ioException) {
            LOGGER.error("Unable to write data in csv file.", ioException);
            ioException.printStackTrace();
        } finally {
            try {
                if (parser != null)
                    parser.close();
            } catch (Exception e) {
            }
        }
        return products;
    }

    public String removeChar(String name, char token) {
        StringBuffer result = new StringBuffer();
        char replace = ' ';
        if (name != null) {
            if (name.indexOf(token) > -1) {
                result.append(name.replace(token, replace).trim());
            }
        }
        return result.toString();
    }

    public File getClassPathFile(String fileName) {
        File file = null;
        Resource resource = appContext.getResource("classpath:"
            + fileName);
        try {
            if (resource.exists()) {
                file = resource.getFile();
            } else {
                resource = appContext.getResource("classpath:product.properties");
                resource = resource.createRelative("product.csv");

            }
        } catch (IOException ioException) {
            LOGGER.info(" >>> Unable to file file in class path");
        }
        return file;
    }
}
