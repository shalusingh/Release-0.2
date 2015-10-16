package com.onlinemarketplace.product.helper;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.onlinemarketplace.dataentity.constants.ProductConstants;
import com.onlinemarketplace.exception.InvalidParameterException;

public class PageingHelper {

	
	private static final Logger logger = LoggerFactory.getLogger(PageingHelper.class);

	
	
	/**
	 * Calculate page valiables.
	 * Ex. get start and end point of a page.
	 * 
	 * @param iPageCount : int
	 * @param iPageNumber : int
	 * @param iTotalCount : int
	 * 
	 * @return Array of int : {@link int}[]
	 * 
	 * */
	public static int [] pagingCounters(int iPageCount,int iPageNumber,int iTotalCount){
		int[] intArray = new int[3];
		try{
			
			int iEnd	= 0;
			int iTotalPageNumber = iTotalCount/iPageCount;
			if(iTotalCount%iPageCount!=0)
				iTotalPageNumber++;
			intArray[ProductConstants.NOPAGE] = iTotalPageNumber;
			
			if(  iPageCount > iTotalCount  ){
				intArray[ProductConstants.START] = 0;
				intArray[ProductConstants.END] = iTotalCount;
			}else if(iPageCount*iPageNumber > iTotalCount ){
				if(iPageNumber>iTotalPageNumber)
					iPageNumber = iTotalPageNumber;
				
				int iTemp = iPageCount * iPageNumber;
				intArray[ProductConstants.START] = iTemp - iPageCount;
				intArray[ProductConstants.END] = iTotalCount;
				
			}else if(iPageNumber == 0){
				intArray[ProductConstants.START] = 0;
				intArray[ProductConstants.END] = iPageCount;
			}else{
				iEnd = iPageCount * iPageNumber;
				intArray[ProductConstants.END] = iEnd;
				intArray[ProductConstants.START] = iEnd - iPageCount;
			}
				
		}catch(NullPointerException nullPointerException){
			if(ProductConstants.isDevMode)
				nullPointerException.printStackTrace();
	    	logger.error(nullPointerException.getMessage() );
		}catch (Exception exception) {
			if(ProductConstants.isDevMode)
				exception.printStackTrace();
	    	logger.error(exception.getMessage() );
		}
		return intArray;
		
	}
 	
	/**
	 * Convert query string get from request into Path param.
	 * 
	 *  @param queryString : String
	 *  
	 *  @return Map <String,String>
	 * 
	 * */
	public static Map<String, String> getMap(String queryString) throws InvalidParameterException{
		Map<String,String> requestMap =  new HashMap<String, String>();
		String[] queryArray = queryString.split("/");
		
		if(queryArray.length % 2 !=0)
			throw new InvalidParameterException("Query string is not valid.");
		
		for(int i=0;i<queryArray.length;i+=2){
			requestMap.put(queryArray[i], queryArray[i+1]);
		}
		return requestMap;
	 }
	
	///category/RACING/subcategory/CAR/price/2500/3000/property/INSTOCK/TRUE/PUBLISHER/EASPORT
	public static Map<String,String> getParam(String queryString) throws InvalidParameterException{
		
		if(!queryString.contains("property"))
			throw new InvalidParameterException("Invalid query string");
			
		String[] values = queryString.split("property/");
		return getMap(values[1]);
	}

}
