package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;

/**
 * @author jitendra.sagoriya
 * @version $Revision: $($Date: $)
 *
 */
@Entity
@Table(name = "productsubcategory")
public class ProductSubCategory
    extends NaturalAbstractEntity<Long>

    implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productCategory")
    private List<Product> product;

    @Column(length = 50, nullable = false)
    private String categoryName;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private ProductCategory category;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "subCategory")
    private List<SubSubCategory> subSubCategory;

    public ProductSubCategory() {
        super();
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public List<SubSubCategory> getSubSubCategory() {
        return subSubCategory;
    }

    public void setSubSubCategory(List<SubSubCategory> subSubCategory) {
        this.subSubCategory = subSubCategory;
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
        result = prime
            * result
            + ((category == null)
                ? 0 : category.hashCode());
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
            + ((subSubCategory == null)
                ? 0 : subSubCategory.hashCode());
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
        } else
            if (!category.equals(other.category))
                return false;
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
        if (subSubCategory == null) {
            if (other.subSubCategory != null)
                return false;
        } else
            if (!subSubCategory.equals(other.subSubCategory))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductSubCategory [product="
            + product + ", categoryName=" + categoryName + ", category=" + category + ", subSubCategory="
            + subSubCategory + "]";
    }

}
