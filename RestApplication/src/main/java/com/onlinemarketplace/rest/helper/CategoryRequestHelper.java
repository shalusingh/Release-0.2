/**
 *
 */
package com.onlinemarketplace.rest.helper;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.onlinemarketplace.dataentity.domain.ProductCategory;
import com.onlinemarketplace.exception.UnauthorizedAccess;

/**
 * @author jitendra Dec 15, 2015 2015
 */
public class CategoryRequestHelper
    extends RequestHelper<ProductCategory> {

    /** logger. */
    private static final Logger logger = LoggerFactory.getLogger(CategoryRequestHelper.class);

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.rest.helper.RequestHelper#getObject(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ProductCategory getObject(HttpServletRequest request) throws NullPointerException, UnauthorizedAccess {
        if (request == null)
            throw new NullPointerException("Request is null.");

        ProductCategory category = new ProductCategory();

        return null;
    }

}
