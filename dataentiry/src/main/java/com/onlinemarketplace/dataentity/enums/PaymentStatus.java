package com.onlinemarketplace.dataentity.enums;

import java.util.HashMap;
import java.util.Map;

public enum PaymentStatus {

	INITIATE(0,"INITIATE",""),
	SENDTOPAYMENTGATEAY(1,"SENDTOPAYMENTGATEAY",""),
	SUCCESSFULL(2,"SUCCESSFULL",""),
	CANCELBYUSER(3,"CANCELBYUSER",""),
	REFUSEBYBANK(4,"REFUSEBYBANK","");
	
	public int id;
	public String value;
	public String description;

	private PaymentStatus(int id, String value, String description) {
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

	
	
	private static final Map<Integer, PaymentStatus> byId = new HashMap<Integer, PaymentStatus>();
	private static final Map<String, PaymentStatus> byValue = new HashMap<String, PaymentStatus>();
	
	
	static {
	     for (PaymentStatus e : PaymentStatus.values() ) {
	            if (byId.put(e.getId(), e) != null) {
	                throw new IllegalArgumentException("duplicate id: " + e.getId());
	            }
	            
	            if (byValue.put(e.getValue(), e) != null) {
	                throw new IllegalArgumentException("duplicate value: " + e.getValue());
	            }
	    }
	 }
	
	 public static PaymentStatus getById(int id) {
	    return byId.get(id);
	 }
	 
	 public static PaymentStatus getByValue(String value) {
		    return byValue.get(value);
		 }

	
}
