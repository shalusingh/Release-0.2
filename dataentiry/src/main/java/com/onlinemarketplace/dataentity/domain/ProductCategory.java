package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.StateFullNaturalEntity;
import com.onlinemarketplace.dataentity.enums.Status;

/**
 * @author jitendra.sagoriya
 *
 * @version 1
 *
 * @serial
 **/
@Entity
@Table(name = "productcategory")
public class ProductCategory
    extends StateFullNaturalEntity<Status, Long>

    implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(length = 50, unique = true)
    private String categoryName;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "productCategory")
    private List<Product> product;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "category")
    private List<ProductSubCategory> subCategory;

    public ProductCategory() {
        super();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductSubCategory> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<ProductSubCategory> subCategory) {
        this.subCategory = subCategory;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((categoryName == null)
                ? 0 : categoryName.hashCode());
        result = prime
            * result
            + ((product == null)
                ? 0 : product.hashCode());
        result = prime
            * result
            + ((subCategory == null)
                ? 0 : subCategory.hashCode());
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
        ProductCategory other = (ProductCategory) obj;
        if (categoryName == null) {
            if (other.categoryName != null)
                return false;
        } else
            if (!categoryName.equals(other.categoryName))
                return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else
            if (!product.equals(other.product))
                return false;
        if (subCategory == null) {
            if (other.subCategory != null)
                return false;
        } else
            if (!subCategory.equals(other.subCategory))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductCategory [categoryName="
            + categoryName + ", product=" + product + ", subCategory=" + subCategory + "]";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dataentity.base.StateFullNaturalEntity#getStatus()
     */
    @Override
    public Status getStatus() {
        // TODO Auto-generated method stub
        return super.status;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dataentity.base.StateFullNaturalEntity#setStatus(java.lang.Object)
     */
    @Override
    public void setStatus(Status status) {
        super.status = status;

    }

}
