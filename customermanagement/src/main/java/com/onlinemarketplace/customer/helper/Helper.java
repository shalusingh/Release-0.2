package com.onlinemarketplace.customer.helper;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.onlinemarketplace.customer.constant.Constants;
import com.onlinemarketplace.dataentity.domain.Customer;
import com.onlinemarketplace.exception.FieldNotFoundException;

/**
 * This class have some helper method of customer module.
 *  1) Convert Request Object To Customer Object. getCustomerByRequest();
 */
public class Helper {

	private static final Logger logger = LoggerFactory.getLogger(Helper.class);

	public static Customer getCustomerByRequest(HttpServletRequest request) throws FieldNotFoundException{
		logger.info(request.getParameterMap().toString());
		Customer customer = new Customer();
		
		if(	StringUtils.isEmpty(request.getParameter( Constants.EMAIL) ) ){
			throw new FieldNotFoundException(Constants.EMAIL +"is null or not found.");
		}else{
			customer.setEmail( request.getParameter( Constants.EMAIL) );
		}
		
		if(	StringUtils.isEmpty(request.getParameter( Constants.NAME) ) ){
			throw new FieldNotFoundException(Constants.NAME +"is null or not found.");
		}else{
			customer.setName( request.getParameter( Constants.NAME) );
		}
		
		if(	StringUtils.isNumeric( request.getParameter( Constants.LANDLINE) ) ){
			throw new FieldNotFoundException(Constants.LANDLINE +"is null or Invalid");
		}else{
			customer.setLandLineNumber( request.getParameter( Constants.LANDLINE) );
		}
		
		if(	StringUtils.isNumeric( request.getParameter( Constants.MOBILE) ) ){
			throw new FieldNotFoundException(Constants.MOBILE +"is null or Invalid");
		}else{
			customer.setMobileNumber( request.getParameter( Constants.MOBILE) );
		}
		
		if(	StringUtils.isEmpty( request.getParameter( Constants.ORGANIZATION) ) ){
			throw new FieldNotFoundException(Constants.ORGANIZATION +"is null or not found.");
		}else{
			customer.setLandLineNumber( request.getParameter( Constants.ORGANIZATION ) );
		}
		
		if(	StringUtils.isEmpty( request.getParameter( Constants.PASSWORD) ) ){
			throw new FieldNotFoundException(Constants.PASSWORD +"is null or not found.");
		}else{
			customer.setLandLineNumber( request.getParameter( Constants.PASSWORD) );
		}
				
		return customer;
	}
}
