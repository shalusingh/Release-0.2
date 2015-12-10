/**
 *
 */
package com.onlinemarketplace.product.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinemarketplace.dataentity.base.comparator.ProductNameComparator;
import com.onlinemarketplace.dataentity.constants.ProductConstants;
import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.dto.Pagenation;
import com.onlinemarketplace.dataentity.enums.ProductStatus;
import com.onlinemarketplace.datamanagement.repository.ProductRepository;
import com.onlinemarketplace.exception.InvalidParameterException;
import com.onlinemarketplace.product.helper.PageingHelper;

/**
 * @author jitendra Dec 8, 2015 2015
 */
@Service
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
        return repository.getByPrice(min, max);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getByPropertyNameAndValue(java.lang.String,
     * java.lang.String)
     */
    @Override
    public List<Product> getByPropertyNameAndValue(String propertyName, String propertyValue) {
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
        return repository.getByStatus(status);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getById(long)
     */
    @Override
    public Product getById(long id) {
        return repository.findOne(id);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getByProductCode(java.lang.String)
     */
    @Override
    public Product getByProductCode(String code) {
        return repository.getByCode(code);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getSortedProductList()
     */
    @Override
    public List<Product> getSortedProductList() {
        List<Product> products = null;
        products = repository.findAll();
        Collections.sort(products, new ProductNameComparator());

        return products;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.product.service.ProductService#getSortedAndPagingProduct(java.util.List, int, int)
     */
    public Pagenation<Product> getSortedAndPagingProduct(int pageNo, int productPerPage) {

        List<Product> list = repository.findAll();

        if (list == null
            || list.isEmpty())
            return null;

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

}
