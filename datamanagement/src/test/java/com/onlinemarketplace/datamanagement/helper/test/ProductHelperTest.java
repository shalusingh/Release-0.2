package com.onlinemarketplace.datamanagement.helper.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.onlinemarketplace.datamanagement.helper.ProductHelper;

public class ProductHelperTest {

	
	@Test
	public void getQuery(){
		System.out.println(">> One");
		Map<String, String> map = new HashMap<String, String>();
		map.put("NAME","NFS");
		System.out.println( ProductHelper.createQuery(map));
		
	}
	
	@Test
	public void getQueryTwo(){
		System.out.println(">> TWO ");
		Map<String, String> map = new HashMap<String, String>();
		map.put("NAME","NFS");
		map.put("CATEGORY","ACTION");
		System.out.println( ProductHelper.createQuery(map));
	}
	
	@Test
	public void getQueryMulti(){
		System.out.println(">> Multi");
		Map<String, String> map = new HashMap<String, String>();
		map.put("NAME","NFS");
		map.put("CATEGORY","ACTION");
		map.put("PRICE","2800");
		System.out.println( ProductHelper.createQuery(map));
	}
	
}
