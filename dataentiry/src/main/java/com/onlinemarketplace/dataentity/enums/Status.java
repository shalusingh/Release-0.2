package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

public enum Status {

	
	UNACTIVE(0,"UNACTIVE",""),
	ACTIVE(1,"ACTIVE",""),
	HOLD(2,"HOLD",""),
	OUTOFSTOCK(3,"OUTOFSTOCK","");
	
	public int id;
	public String value;
	public String description;

	private Status(int id, String value, String description) {
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
	
	private static final Map<Integer, Status> byId = new HashMap<Integer, Status>();
	private static final Map<String, Status> byValue = new HashMap<String, Status>();
	
	
	static {
	     for (Status e : Status.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	 public static Status getById(int id) {
	    return byId.get(id);
	 }
	 
	 public static Status getByValue(String value) {
		    return byValue.get(value);
		 }

	
	
}
