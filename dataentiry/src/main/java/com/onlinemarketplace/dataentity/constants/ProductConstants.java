package com.onlinemarketplace.dataentity.constants;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductConstants  extends CommenConstant {

	public final static String CHECK_AUTOCOMPLETE = "instituteType,";
	public final static int START = 0;
	public final static int END = 1;
	public final static int NOPAGE = 2;
	
	public final static ArrayList<String> LIST = new ArrayList<String>(Arrays.asList("NAME","CATEGORY","INSTOCK","PRICE","DISCOUNT"
			+ ",SUBCATEGORY","PUBLISHER"));

}
