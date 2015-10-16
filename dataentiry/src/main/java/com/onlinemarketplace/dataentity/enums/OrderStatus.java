package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

public enum OrderStatus {
	CREATED(0,"CREATED",""),
	PROCESSING(1,"PROCESSING",""),
	DISPACHED(2,"DISPACHED",""),
	DELIVERED(3,"DELIVERED",""),
	RETURN(4,"RETURN","");
	
	public int id;
	public String value;
	public String description;

	private OrderStatus(int id, String value, String description) {
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

	
	
	private static final Map<Integer, OrderStatus> byId = new HashMap<Integer, OrderStatus>();
	private static final Map<String, OrderStatus> byValue = new HashMap<String, OrderStatus>();
	
	
	static {
	     for (OrderStatus e : OrderStatus.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	 public static OrderStatus getById(int id) {
	    return byId.get(id);
	 }
	 
	 public static OrderStatus getByValue(String value) {
		    return byValue.get(value);
		 }

	
}
