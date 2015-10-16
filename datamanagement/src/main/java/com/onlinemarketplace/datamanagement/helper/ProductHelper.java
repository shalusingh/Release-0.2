package com.onlinemarketplace.datamanagement.helper;

import java.util.Map;
import java.util.Map.Entry;

public class ProductHelper {

	public static String createQuery(Map<String, String> param){
		StringBuffer query = new StringBuffer("SELECT p FROM Product p JOIN p.productProperty pp WHERE ");
		if(param != null){
			int iSize = param.entrySet().size();
			int iCounter = 1;
			for (Entry<String, String> entry : param.entrySet()) {
				query.append( "   pp.propertyName = '"+entry.getKey()+"'");
				query.append(" OR ");
				query.append( "pp.propertyValue = '"+entry.getValue() +"' ");
				if(iSize != iCounter)
					query.append(" AND ");
				iCounter++;
			}
		}
		System.out.println( query);
		return query.toString();
		
	}
}
