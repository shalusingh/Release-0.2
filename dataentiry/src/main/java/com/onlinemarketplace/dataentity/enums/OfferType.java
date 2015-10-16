package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

public enum OfferType {
	CASH(21001,"FLAT","CASH"),
	PERCENT(21002,"PERCENT","PERCENT"),
	ANYPRODUCT(21003,"ANYPRODUCT","ANYPRODUCT"),
	CASHBACK(21004,"CASHBACK","CASHBACK");
	
	public int id;
	public String value;
	public String description;

	private OfferType(int id, String value, String description) {
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

	
	
	private static final Map<Integer, OfferType> byId = new HashMap<Integer, OfferType>();
	private static final Map<String, OfferType> byValue = new HashMap<String, OfferType>();
	
	
	static {
	     for (OfferType e : OfferType.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	 public static OfferType getById(int id) {
	    return byId.get(id);
	 }
	 
	 public static OfferType getByValue(String value) {
		    return byValue.get(value);
		 }

	
	
	
	
}
