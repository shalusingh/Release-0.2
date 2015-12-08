/**
 *
 */
package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;

/**
 * @author jitendra.sagoriya Nov 27, 2015 2015
 * @version $Revision: $($Date: $)
 */
@Entity

public class SubSubCategory
    extends NaturalAbstractEntity<Long>
    implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productCategory")
    private List<Product> product;

    @Column(length = 50, nullable = false)
    private String categoryName;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = true)
    private ProductSubCategory subCategory;

    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ProductSubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(ProductSubCategory subCategory) {
        this.subCategory = subCategory;
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
        SubSubCategory other = (SubSubCategory) obj;
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
        return "SubSubCategory [product="
            + product + ", categoryName=" + categoryName + ", subCategory=" + subCategory + "]";
    }

}
