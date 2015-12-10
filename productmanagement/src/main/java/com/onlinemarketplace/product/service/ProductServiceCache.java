package com.onlinemarketplace.product.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarketplace.dataentity.base.comparator.ProductNameComparator;
import com.onlinemarketplace.dataentity.constants.ProductConstants;
import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.domain.ProductProperty;
import com.onlinemarketplace.dataentity.dto.Pagenation;
import com.onlinemarketplace.dataentity.enums.ProductStatus;
import com.onlinemarketplace.datamanagement.repository.ProductRepository;
import com.onlinemarketplace.exception.InvalidParameterException;
import com.onlinemarketplace.product.helper.PageingHelper;
import com.onlinemarketplace.product.manager.CSVManager;

@Service
public class ProductServiceCache
    extends ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceCache.class);

    private static Map<Long, Product> products = new Hashtable<Long, Product>();
    private static String fileName = "product.csv";
    private File file;
    private boolean fromDB = false;

    @Autowired
    private CSVManager csvManager;

    ProductRepository repository;

    public ProductServiceCache() {
        super();
    }

    @Override
    public Map<Long, Product> getProduct() {

        if (products == null
            || products.isEmpty()) {
            logger.info("Loading product from Csv");
            products = Product.getProductMap(csvManager.readCSV(file));
        }

        if (products == null
            || products.isEmpty() || fromDB) {
            List<Product> productList = repository.findAll();
            csvManager.writeCSV(file, productList);
        }

        return products;
    }

    @Override
    public List<Product> getByCategory(String category) {
        List<Product> result = new ArrayList<Product>();
        List<Product> products = new ArrayList<Product>(getProduct().values());
        try {
            if (!products.isEmpty()) {
                for (Product product : products) {
                    if (product != null) {
                        if (product.getProductCategory().getCategoryName().trim().equalsIgnoreCase(category.trim())) {
                            result.add(product);
                        }
                    }
                }
            } else {
                logger.error("Products not found...");
            }
            Collections.sort(result, new ProductNameComparator());
        } catch (Exception exception) {
            logger.error("Products not found...");
            System.out.println(exception);
        }
        return result;
    }

    /**
     * Get list of product from cashe list category value.
     *
     * @param category
     *            : {@link String}
     * @param products
     *            : List<{@link Product}>
     *
     * @return List : <{@link Product}>
     */
    public List<Product> getByCategory(List<Product> products, String category) {
        List<Product> result = new ArrayList<Product>();
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product != null) {
                    if (product.getProductCategory().getCategoryName().trim().equalsIgnoreCase(category.trim())) {
                        result.add(product);
                    }
                }
            }
        } else {
            logger.error("Products not found...");
        }
        Collections.sort(result, new ProductNameComparator());
        return result;
    }

    @Override
    public List<Product> getBySubCategory(String category) {
        List<Product> result = new ArrayList<Product>();
        List<Product> products = new ArrayList<Product>(getProduct().values());
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product != null) {
                    if (product.getProductSubCategory().getCategoryName().trim().equalsIgnoreCase(category.trim())) {
                        result.add(product);
                    }
                }
            }
        } else {
            logger.error("Products not found...");
        }
        Collections.sort(result, new ProductNameComparator());

        return result;
    }

    /**
     * Get list of product from cashe list category value.
     *
     * @param category
     *            : {@link String}
     * @param products
     *            : List<{@link Product}>
     *
     * @return List <{@link Product}>
     */
    public List<Product> getBySubCategory(List<Product> products, String category) {
        List<Product> result = new ArrayList<Product>();
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product != null) {
                    if (product.getProductSubCategory().getCategoryName().trim().equalsIgnoreCase(category.trim())) {
                        result.add(product);
                    }
                }
            }
        } else {
            logger.error("Products not found...");
        }
        Collections.sort(result, new ProductNameComparator());
        return result;
    }

    @Override
    public List<Product> getByPrice(float min, float max) {
        List<Product> result = new ArrayList<Product>();
        List<Product> products = new ArrayList<Product>(getProduct().values());
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product != null) {
                    if (product.getPrice() >= min
                        && product.getPrice() <= max) {
                        result.add(product);
                    }
                }
            }
        } else {
            logger.error("Products not found...");
        }
        Collections.sort(result, new ProductNameComparator());
        return result;
    }

    /**
     * Get list of product from cashe list category value.
     *
     * @param max
     *            : List<{@link Product}>
     * @param min
     *            : {@link Float}
     * @param max
     *            : {@link Float}
     *
     * @return List <{@link Product}>
     */
    public List<Product> getByPrice(List<Product> products, float min, float max) {
        List<Product> result = new ArrayList<Product>();
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product != null) {
                    if (product.getPrice() >= min
                        && product.getPrice() <= max) {
                        result.add(product);
                    }
                }
            }
        } else {
            logger.error("Products not found...");
        }
        Collections.sort(result, new ProductNameComparator());
        return result;
    }

    @Override
    public List<Product> getByPropertyNameAndValue(String propertyName, String propertyValue) {
        List<Product> result = new ArrayList<Product>();
        List<Product> products = new ArrayList<Product>(getProduct().values());
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product != null) {
                    List<ProductProperty> properties = product.getProductProperty();
                    if (properties == null) {
                        logger.error("Product property not found.Fetching from data base");
                        product = repository.findOne(product.getId());
                    }
                    if (properties != null) {
                        for (ProductProperty productProperty : properties) {
                            if (productProperty.getPropertyName().trim().toUpperCase().equals(propertyName.trim()
                                .toUpperCase())
                                && productProperty.getPropertyValue().trim().toUpperCase().equals(propertyValue.trim()
                                    .toUpperCase())) {
                                result.add(product);
                            }
                        }
                    }
                }
            }
        } else {
            logger.error("Products not found...");
        }
        Collections.sort(result, new ProductNameComparator());
        return result;
    }

    /**
     * Get product list according to property name and property value from the give List.
     *
     * @param products
     *            : List<{@link Product}>
     * @param propertyName
     *            : {@link String}
     * @param propertyValue
     *            : {@link String}
     *
     * @return List <{@link Product}>
     *
     */
    public List<Product> getByPropertyNameAndValue(List<Product> products, String propertyName,
        String propertyValue) {
        List<Product> result = new ArrayList<Product>();
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product != null) {
                    List<ProductProperty> properties = product.getProductProperty();
                    if (properties == null) {
                        logger.error("Product property not found.Fetching from data base");
                        product = repository.findOne(product.getId());
                    }
                    if (properties != null) {
                        for (ProductProperty productProperty : properties) {
                            if (productProperty.getPropertyName().trim().toUpperCase().equals(propertyName.trim()
                                .toUpperCase())
                                && productProperty.getPropertyValue().trim().toUpperCase().equals(propertyValue.trim()
                                    .toUpperCase())) {
                                result.add(product);
                            }
                        }
                    }
                }
            }
        } else {
            logger.error("Products not found...");
        }
        Collections.sort(result, new ProductNameComparator());
        return result;
    }

    /**
     * Get product list according to property name and property value from the give List.
     *
     * @param products
     *            : List<{@link Product}>
     * @param propertyName
     *            : {@link String}
     * @param propertyValue
     *            : {@link String}
     *
     * @return List <{@link Product}>
     *
     */
    @Override
    @SuppressWarnings("null")
    public List<Product> getByPropertyNameAndValue(Map<String, String> nameValuePair)
        throws InvalidParameterException {
        List<Product> result = new ArrayList<Product>();
        if (nameValuePair == null) {
            logger.info("Property Map is null.");
            throw new InvalidParameterException("Property Map is null.");
        }
        for (String key : nameValuePair.keySet()) {
            String value = nameValuePair.get(key);
            if (value == null
                && value.isEmpty()) {
                logger.info("Value for the key "
                    + key + " is not found in nameValuePair");
            }
            result.addAll(getByPropertyNameAndValue(key, value));
        }
        return result;
    }

    /**
     * Get product list according to property name and property value from the give List.
     *
     * @param products
     *            : List<{@link Product}>
     * @param propertyName
     *            : {@link String}
     * @param propertyValue
     *            : {@link String}
     *
     * @return List <{@link Product}>
     *
     */

    @SuppressWarnings("null")
    public List<Product> getByPropertyNameAndValue(List<Product> products, Map<String, String> nameValuePair)
        throws InvalidParameterException {

        if (products == null)
            products = new ArrayList<Product>(getProduct().values());

        if (nameValuePair == null) {
            logger.info("Property Map is null.");
            throw new InvalidParameterException("Property Map is null.");
        }
        for (String key : nameValuePair.keySet()) {
            String value = nameValuePair.get(key);
            if (value == null
                && value.isEmpty()) {
                logger.info("Value for the key "
                    + key + " is not found in nameValuePair");
            }
            products = getByPropertyNameAndValue(products, key, value);
        }
        return products;
    }

    public Pagenation<Product> search(String queryString) throws InvalidParameterException {
        List<Product> products = new ArrayList<Product>(getProduct().values());
        Map<String, String> queryParam = null;
        int pageNo;
        int itemPerPage;
        if (queryString.contains("~")) {
            String[] pageQuery = queryString.split("~");
            String[] pageParam = pageQuery[1].split("/");

            try {
                pageNo = Integer.parseInt(pageParam[0]);
                itemPerPage = Integer.parseInt(pageParam[1]);
            } catch (NumberFormatException numberFormatException) {
                throw new InvalidParameterException("Unable to parse page variable.");
            }
            queryParam = PageingHelper.getMap(pageQuery[0]);
            products = getByPropertyNameAndValue(products, queryParam);
            return getSortedAndPagingProduct(products, pageNo, itemPerPage);
        } else {
            queryParam = PageingHelper.getMap(queryString);
            products = getByPropertyNameAndValue(products, queryParam);
        }
        return new Pagenation<Product>(products);
    }

    /**
     * Get product by status.
     *
     * @param status
     *            : {@link ProductStatus}
     *
     * @return List <{@link Product}>
     *
     */

    @Override
    public List<Product> getByStatus(ProductStatus status) {
        List<Product> result = new ArrayList<Product>();
        List<Product> products = new ArrayList<Product>(getProduct().values());
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product != null) {
                    if (product.getStatus() == status) {
                        result.add(product);
                    }
                }
            }
        } else {
            logger.error("Products not found...");
        }
        Collections.sort(result, new ProductNameComparator());
        return result;
    }

    /**
     * Get product by id.
     *
     * @param status
     *            : long
     *
     * @return List <{@link Product}>
     *
     */
    @Override
    public Product getById(long id) {
        Map<Long, Product> products = getProduct();
        if (products != null)
            return products.get(id);
        else
            return null;
    }

    /**
     * Get product by product code.
     *
     * @param status
     *            : String
     *
     * @return List <{@link Product}>
     *
     */
    @Override
    public Product getByProductCode(String code) {
        Product result = null;
        List<Product> products = new ArrayList<Product>(getProduct().values());
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product != null) {
                    if (product.getProductCode().trim().equalsIgnoreCase(code.trim())) {
                        result = product;
                        break;
                    }
                }
            }
        } else {
            logger.error("Products not found...");
        }
        return result;
    }

    /**
     * Get product by product code.
     *
     * @param status
     *            : String
     *
     * @return List <{@link Product}>
     *
     */
    public List<Product> getByStatus(String code) {
        List<Product> result = new ArrayList<Product>();
        List<Product> products = new ArrayList<Product>(getProduct().values());
        if (!products.isEmpty()) {
            for (Product product : products) {
                if (product != null) {
                    if (product.getProductCode().trim().equalsIgnoreCase(code.trim())) {
                        result.add(product);
                    }
                }
            }
        } else {
            logger.error("Products not found...");
        }
        Collections.sort(result, new ProductNameComparator());
        return result;
    }

    /**
     * Get sorted product list
     *
     * @param status
     *            : String
     *
     * @return List <{@link Product}>
     *
     */
    @Override
    public List<Product> getSortedProductList() {
        List<Product> list = new ArrayList<Product>(getProduct().values());
        Collections.sort(list, new ProductNameComparator());
        return list;
    }

    /**
     * Get sorted and paging product list
     *
     * @param list
     *            : List <{@link Product}>
     * @param pageNo
     *            : int
     * @param productPerPage
     *            : int
     *
     * @return List <{@link Product}>
     *
     */

    public Pagenation<Product> getSortedAndPagingProduct(List<Product> list, int pageNo, int productPerPage) {

        if (list == null
            || list.isEmpty())
            list = new ArrayList<Product>(getProduct().values());

        List<Product> resultList = new ArrayList<Product>();
        Pagenation<Product> pagenation = new Pagenation<Product>();
        Collections.sort(list, new ProductNameComparator());
        int totalSize = list.size();
        int[] pageing = PageingHelper.pagingCounters(productPerPage, pageNo, totalSize);

        for (int i = pageing[ProductConstants.START]; i < pageing[ProductConstants.END]; i++) {
            resultList.add(list.get(i));
        }
        Collections.sort(resultList, new ProductNameComparator());

        pagenation.setiCount(totalSize);
        pagenation.setiPageNo(pageNo);
        pagenation.setiEnd(pageing[ProductConstants.END]);
        pagenation.setiPageSize(productPerPage);
        pagenation.setiStart(pageing[ProductConstants.START]);
        pagenation.setResult(resultList);

        return pagenation;

    }

    public Product getById(Long id) {
        return getProduct().get(id);
    }

    public List<Product> inStock() {
        return getByPropertyNameAndValue("INSTOCK", "TRUE");
    }

    public List<Product> outOfStock() {
        return getByPropertyNameAndValue("INSTOCK", "FALSE");
    }

    /* ************************ GETTER AND SETTER *************************** */

    /**/
    public ProductServiceCache(ProductRepository repository) {
        this.repository = repository;
    }

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        ProductServiceCache.fileName = fileName;
    }

    public boolean isFromDB() {
        return fromDB;
    }

    public void setFromDB(boolean fromDB) {
        this.fromDB = fromDB;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

}
