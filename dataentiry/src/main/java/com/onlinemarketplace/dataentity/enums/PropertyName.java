package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

public enum PropertyName {
	NAME(9001,"NAME"),
	CATEGORY(9002,"CATEGORY"),
	INSTOCK(9003,"INSTOCK"),
	PRICE(9004,"PRICE"),
	DISCOUNT(9005,"DISCOUNT"),
	SUBCATEGORY(9006,"SUBCATEGORY"),
	PUBLISHER(9007,"PUBLISHER");
	
	private Integer code;
	private String value;
	private PropertyName(Integer code, String value) {
		this.code = code;
		this.value = value;
	}
	

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	private static final Map<Integer, PropertyName> byId = new HashMap<Integer, PropertyName>();
	private static final Map<String, PropertyName> byValue = new HashMap<String, PropertyName>();
	
	
	static {
	     for (PropertyName e : PropertyName.values() ) {
	            if (byId.put(e.getCode(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getCode());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	 public static PropertyName getById(int id) {
	    return byId.get(id);
	 }
	 
	 public static PropertyName getByValue(String value) {
		    return byValue.get(value);
		 }

	
}
