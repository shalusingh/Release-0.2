/**
 *
 */
package com.onlinemarketplace.product.service;

import java.util.List;
import java.util.Map;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.dto.Pagenation;
import com.onlinemarketplace.dataentity.enums.ProductStatus;
import com.onlinemarketplace.exception.InvalidParameterException;

/**
 * @author jitendra Dec 8, 2015 2015
 */
public abstract class ProductService {

    /**
     * Check cache product list if null then read from csv file. if unable to read data from csv file then go to data
     * base to get product list.
     *
     * @return Map< Long , {@link Product}> :ProductList
     *
     */
    public abstract Map<Long, Product> getProduct();

    /**
     * Get list of product from cashe list category value.
     *
     * @param category
     *            : {@link String}
     *
     * @return List : <{@link Product}>
     */
    public abstract List<Product> getByCategory(String category);

    /**
     * Get list of product from cashe list category value.
     *
     * @param category
     *            : {@link String}
     *
     * @return List : <{@link Product}>
     */
    public abstract List<Product> getBySubCategory(String category);

    /**
     * Get list of product from cashe list category value.
     *
     * @param min
     *            : {@link Float}
     * @param max
     *            : {@link Float}
     *
     * @return List <{@link Product}>
     */
    public abstract List<Product> getByPrice(float min, float max);

    /**
     * Get list of product from cashe list according Property Name and Property Value.
     *
     * @param propertyName
     *            : {@link String}
     * @param propertyValue
     *            : {@link String}
     *
     * @return List <{@link Product}>
     *
     */
    public abstract List<Product> getByPropertyNameAndValue(String propertyName, String propertyValue);

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

    public abstract List<Product> getByPropertyNameAndValue(Map<String, String> nameValuePair)
        throws InvalidParameterException;

    /**
     * Get product by status.
     *
     * @param status
     *            : {@link ProductStatus}
     *
     * @return List <{@link Product}>
     *
     */

    public abstract List<Product> getByStatus(ProductStatus status);

    /**
     * Get product by id.
     *
     * @param status
     *            : long
     *
     * @return List <{@link Product}>
     *
     */
    public abstract Product getById(long id);

    /**
     * Get product by product code.
     *
     * @param status
     *            : String
     *
     * @return List <{@link Product}>
     *
     */
    public abstract List<Product> getByProductCode(String code);

    /**
     * Get sorted product list
     *
     * @param status
     *            : String
     *
     * @return List <{@link Product}>
     *
     */
    public abstract List<Product> getSortedProductList();

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
    public abstract Pagenation<Product> getSortedAndPagingProduct(List<Product> list, int pageNo, int productPerPage);

}
