package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProductStatus {
	UNACTIVE(0,"UNACTIVE",""),
	ACTIVE(1,"ACTIVE",""),
	INSTOCK(2,"INSTOCK",""),
	OUTOFSTOCK(3,"OUTOFSTOCK","");
	
	public int id;
	public String value;
	public String description;

	private ProductStatus(int id, String value, String description) {
		this.id = id;
		this.value = value;
		this.description = description;
	}

	private int getId() {
		return id;
	}

	private String getValue() {
		return value;
	}

	@SuppressWarnings("unused")
	private String getDescription() {
		return description;
	}
	
	private static final Map<Integer, ProductStatus> byId = new HashMap<Integer, ProductStatus>();
	private static final Map<String, ProductStatus> byValue = new HashMap<String, ProductStatus>();
	
	
	static {
	     for (ProductStatus e : ProductStatus.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	 public static ProductStatus getById(int id) {
	    return byId.get(id);
	 }
	 
	 public static ProductStatus getByValue(String value) {
		    return byValue.get(value);
		 }

	
	
}
