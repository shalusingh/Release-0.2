package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.onlinemarketplace.dataentity.base.AbstractEntity;
import com.onlinemarketplace.dataentity.enums.Status;


/**
 * @author jitendra.sagoriya
 * 
 */
@Entity
@Table(name="productsubcategory")
public class ProductSubCategory extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Transient
	private ProductCategory productCategory;
	
	@Column(length=50,nullable=false)
	private String categoryName;
	
	@Column(length=1,nullable=false)
	private Status status;
	 
	public ProductSubCategory() {
		super();
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((productCategory == null) ? 0 : productCategory.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductSubCategory other = (ProductSubCategory) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (productCategory == null) {
			if (other.productCategory != null)
				return false;
		} else if (!productCategory.equals(other.productCategory))
			return false;
		if (status != other.status)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "ProductSubCategory [productCategory=" + productCategory + ", categoryName=" + categoryName + ", status="
				+ status + "]";
	}

	 
 
	 
}
