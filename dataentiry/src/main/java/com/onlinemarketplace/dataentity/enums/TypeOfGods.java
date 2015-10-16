package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

public enum TypeOfGods {
	UNVERIFY(0,"UNVERIFY",""),
	VERIFY(1,"VERIFY",""),
	DELETED(2,"DELETED","");
	
	public int id;
	public String value;
	public String description;

	private TypeOfGods(int id, String value, String description) {
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

	
	
	private static final Map<Integer, TypeOfGods> byId = new HashMap<Integer, TypeOfGods>();
	private static final Map<String, TypeOfGods> byValue = new HashMap<String, TypeOfGods>();
	
	
	static {
	     for (TypeOfGods e : TypeOfGods.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	 public static TypeOfGods getById(int id) {
	    return byId.get(id);
	 }
	 
	 public static TypeOfGods getByValue(String value) {
		    return byValue.get(value);
		 }

	
}
