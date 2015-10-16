package com.onlinemarketplace.product.helper;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.onlinemarketplace.dataentity.constants.ProductConstants;
import com.onlinemarketplace.exception.InvalidParameterException;



public class PageingHealperTest {

	
	@Test
	public void pagingCounters(){
		int[] values = PageingHelper.pagingCounters(10, 3, 26);
		System.out.println( values[ProductConstants.START]);
		System.out.println( values[ProductConstants.END]);
		System.out.println( values[ProductConstants.NOPAGE]);
	}

	@Test
	public void queryString(){
		Map<String, String> resultMap = null;
		try {
			resultMap = PageingHelper.getMap("jitendra/sagoriya/shalu/singh") ;
			Assert.assertEquals(2, resultMap.size() );
		} catch (InvalidParameterException e) {
			 e.printStackTrace();
		}
	}
	
	@Test
	public void queryStringWithHash(){
		Map<String, String> resultMap = null;
		try {
			resultMap = PageingHelper.getMap("jitendra/sagoriya/") ;
			 Assert.assertEquals(1, resultMap.size() );
		} catch (InvalidParameterException e) {
			 e.printStackTrace();
		}
	}
	
	@Test
	public void getParam(){
		Map<String, String> resultMap = null;
		try {
			resultMap = PageingHelper.getParam("category/RACING/subcategory/CAR/price/2500/3000/property/INSTOCK/TRUE/PUBLISHER/EASPORT") ;
			Assert.assertEquals(2, resultMap.size() );
		} catch (InvalidParameterException e) {
			 e.printStackTrace();
		}
	}
	
	@Test
	public void getParamException(){
		Map<String, String> resultMap = null;
		try {
			resultMap = PageingHelper.getParam("category/RACING/subcategory/CAR/price/2500/3000/properties/INSTOCK/TRUE/PUBLISHER/EASPORT") ;
			Assert.assertEquals(2, resultMap.size() );
		} catch (InvalidParameterException e) {
			 e.printStackTrace();
		}
	}
	
	
	@Test
	public void queryStringExceptionOnlyOneParam(){
		 try {
			  PageingHelper.getMap("jitendra") ;
			  
		} catch (InvalidParameterException e) {
			Assert.assertEquals(InvalidParameterException.class,e.getClass());
		}
	}
	
	@Test
	public void queryStringException(){
		 try {
			 PageingHelper.getMap("jitendra/sagoriya/shalu") ;
			  
		} catch (InvalidParameterException e) {
			Assert.assertEquals(InvalidParameterException.class,e.getClass());
		}
	}
}
