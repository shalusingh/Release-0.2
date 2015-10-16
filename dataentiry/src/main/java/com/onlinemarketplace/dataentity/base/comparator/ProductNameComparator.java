package com.onlinemarketplace.dataentity.base.comparator;
import java.util.Comparator;

import com.onlinemarketplace.dataentity.domain.Product;



public class ProductNameComparator implements Comparator<Product> {

	public int compare(Product o1, Product o2) {
		
		String name1 = o1.getName();
		String name2 = o2.getName();

		// ascending order (descending order would be: name2.compareTo(name1))
		return name1.compareTo(name2);
		
	}

}
