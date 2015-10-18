package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.onlinemarketplace.dataentity.base.AbstractEntity;


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
	
	 
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private ProductCategory category;
	 
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

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((productCategory == null) ? 0 : productCategory.hashCode());
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
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
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
		return true;
	}

	@Override
	public String toString() {
		return "ProductSubCategory [productCategory=" + productCategory + ", categoryName=" + categoryName
				+ ", category=" + category + "]";
	}

	
	 
 
	 
}
