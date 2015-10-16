package com.onlinemarketplace.dataentity.helper;

import java.util.List;

import com.onlinemarketplace.dataentity.domain.ProductProperty;
import com.onlinemarketplace.dataentity.enums.PropertyName;

public class ProductPropertyHelper {

	public static ProductProperty getPropertyByName(List<ProductProperty> productProperties,String propertyName){
		if(productProperties!=null){
			for (ProductProperty productProperty : productProperties) {
				if(productProperty!=null){
					if(productProperty.getPropertyName().trim().equalsIgnoreCase( propertyName.trim() )){
						return productProperty;
					}
				}
			}
		}
		return null;
	}
	//NAME,CATEGORY,INSTOCK,PRICE,DISCOUNT,SUBCATEGORY,PUBLISHER
	public static ProductProperty getName(List<ProductProperty> productProperties){
		return getPropertyByName(productProperties,PropertyName.NAME.getValue());
	}
	
	public static ProductProperty getCategory(List<ProductProperty> productProperties){
		return getPropertyByName(productProperties,PropertyName.CATEGORY.getValue());
	}
	
	public static ProductProperty getStock(List<ProductProperty> productProperties){
		return getPropertyByName(productProperties,PropertyName.INSTOCK.getValue());
	}
	
	
	public static ProductProperty getPrice(List<ProductProperty> productProperties){
		return getPropertyByName(productProperties,PropertyName.PRICE.getValue());
	}
	
	public static ProductProperty getDiscount(List<ProductProperty> productProperties){
		return getPropertyByName(productProperties,PropertyName.DISCOUNT.getValue());
	}
	
	public static ProductProperty getSubCategory(List<ProductProperty> productProperties){
		return getPropertyByName(productProperties,PropertyName.SUBCATEGORY.getValue());
	}
	public static ProductProperty getPublisher(List<ProductProperty> productProperties){
		return getPropertyByName(productProperties,PropertyName.PUBLISHER.getValue());
	}
	
	
}
