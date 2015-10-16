package com.onlinemarketplace.product.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDtoMap {

	@XmlAttribute(name="product")
	public String product;
	
	@XmlAttribute(name="productDto")
	public String productDto;

	public ProductDtoMap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductDto() {
		return productDto;
	}

	public void setProductDto(String productDto) {
		this.productDto = productDto;
	}

	@Override
	public String toString() {
		return "ProductDtoMap [product=" + product + ", productDto=" + productDto + "]";
	}
	
	
}
