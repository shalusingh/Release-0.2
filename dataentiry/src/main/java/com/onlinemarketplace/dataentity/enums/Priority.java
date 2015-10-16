package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

public enum Priority {
	ONE(1,"ONE",""),
	TWO(2,"TWO",""),
	THREE(3,"THREE",""),
	FOUR(4,"FOUR",""),
	FIVE(5,"FIVE","");
	
	public int id;
	public String value;
	public String description;

	private Priority(int id, String value, String description) {
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

	
	
	private static final Map<Integer, Priority> byId = new HashMap<Integer, Priority>();
	private static final Map<String, Priority> byValue = new HashMap<String, Priority>();
	
	
	static {
	     for (Priority e : Priority.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	 public static Priority getById(int id) {
	    return byId.get(id);
	 }
	 
	 public static Priority getByValue(String value) {
		    return byValue.get(value);
		 }

}
