/**
 *
 */
package com.onlinemarketplace.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.dto.Pagenation;
import com.onlinemarketplace.dataentity.enums.ProductStatus;
import com.onlinemarketplace.datamanagement.repository.ProductRepository;
import com.onlinemarketplace.exception.InvalidParameterException;

/**
 * @author jitendra Dec 8, 2015 2015
 */
public class ProductServiceDb
    extends ProductService {

    @Autowired
    private ProductRepository repository;

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getProduct()
     */
    @Override
    public Map<Long, Product> getProduct() {
        Map<Long, Product> productMap = new HashMap<Long, Product>();
        List<Product> products = repository.findAll();
        if (products != null) {
            for (Product product : products) {
                productMap.put(product.getId(), product);
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getByCategory(java.lang.String)
     */
    @Override
    public List<Product> getByCategory(String category) {

        return repository.getByCategory(category);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getBySubCategory(java.lang.String)
     */
    @Override
    public List<Product> getBySubCategory(String category) {
        return repository.getBySubCategory(category);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getByPrice(float, float)
     */
    @Override
    public List<Product> getByPrice(float min, float max) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getByPropertyNameAndValue(java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<Product> getByPropertyNameAndValue(String propertyName, String propertyValue) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getByPropertyNameAndValue(java.util.Map)
     */
    @Override
    public List<Product> getByPropertyNameAndValue(Map<String, String> nameValuePair)
        throws InvalidParameterException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getByStatus(com.onlinemarketplace.dataentity.enums.
     * ProductStatus)
     */
    @Override
    public List<Product> getByStatus(ProductStatus status) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getById(long)
     */
    @Override
    public Product getById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getByProductCode(java.lang.String)
     */
    @Override
    public List<Product> getByProductCode(String code) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getSortedProductList()
     */
    @Override
    public List<Product> getSortedProductList() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getSortedAndPagingProduct(java.util.List, int, int)
     */
    @Override
    public Pagenation<Product> getSortedAndPagingProduct(List<Product> list, int pageNo, int productPerPage) {
        // TODO Auto-generated method stub
        return null;
    }

}
