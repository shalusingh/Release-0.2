package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

public enum SupplierStatus {
	UNACTIVE(0,"UNACTIVE",""),
	ACTIVE(1,"ACTIVE",""),
	UNSUBSCRIBE(2,"UNSUBSCRIBE",""),
	SUBSCRIBE(3,"SUBSCRIBE","");

	public int id;
	public String value;
	public String description;

	private SupplierStatus(int id, String value, String description) {
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
	
	private static final Map<Integer, SupplierStatus> byId = new HashMap<Integer, SupplierStatus>();
	private static final Map<String, SupplierStatus> byValue = new HashMap<String, SupplierStatus>();
	
	
	static {
	     for (SupplierStatus e : SupplierStatus.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	 public static SupplierStatus getById(int id) {
	    return byId.get(id);
	 }
	 
	 public static SupplierStatus getByValue(String value) {
		    return byValue.get(value);
		 }

	
}
