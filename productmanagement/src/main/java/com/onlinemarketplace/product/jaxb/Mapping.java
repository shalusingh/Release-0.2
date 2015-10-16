package com.onlinemarketplace.product.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mappings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mapping {
	
	@XmlAttribute(name="map")
	List<ProductDtoMap> productDtoMaps;

	public List<ProductDtoMap> getProductDtoMaps() {
		return productDtoMaps;
	}

	public void setProductDtoMaps(List<ProductDtoMap> productDtoMaps) {
		this.productDtoMaps = productDtoMaps;
	}

	public Mapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productDtoMaps == null) ? 0 : productDtoMaps.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mapping other = (Mapping) obj;
		if (productDtoMaps == null) {
			if (other.productDtoMaps != null)
				return false;
		} else if (!productDtoMaps.equals(other.productDtoMaps))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mapping [productDtoMaps=" + productDtoMaps + "]";
	}

	
}
