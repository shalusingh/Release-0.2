/**
 *
 */
package com.onlinemarketplace.rest.helper;

import javax.servlet.http.HttpServletRequest;

import com.onlinemarketplace.exception.UnauthorizedAccess;

/**
 * @author jitendra Dec 15, 2015 2015
 */
public abstract class RequestHelper<T> {

    /**
     * This method ready request and create domain object.
     */
    public abstract T getObject(HttpServletRequest request) throws NullPointerException, UnauthorizedAccess;
}
