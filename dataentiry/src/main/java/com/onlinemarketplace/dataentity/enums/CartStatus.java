package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

public enum CartStatus {
	UNVERIFY(0,"UNVERIFY",""),
	VERIFY(1,"VERIFY",""),
	DELETED(2,"DELETED","");
	
	public int id;
	public String value;
	public String description;

	private CartStatus(int id, String value, String description) {
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

	
	
	private static final Map<Integer, CartStatus> byId = new HashMap<Integer, CartStatus>();
	private static final Map<String, CartStatus> byValue = new HashMap<String, CartStatus>();
	
	
	static {
	     for (CartStatus e : CartStatus.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	 public static CartStatus getById(int id) {
	    return byId.get(id);
	 }
	 
	 public static CartStatus getByValue(String value) {
		    return byValue.get(value);
		 }

	
}
