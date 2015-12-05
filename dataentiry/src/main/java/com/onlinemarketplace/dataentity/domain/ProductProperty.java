package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
/**
 * @author jitu
 */
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;

@Entity
@Table(name = "productproperty")
public class ProductProperty
    extends NaturalAbstractEntity<Long>
    implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Product product;

    @Column(length = 20, nullable = false)
    private String propertyName;

    @Column(length = 200, nullable = false)
    private String propertyValue;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((product == null)
                ? 0 : product.hashCode());
        result = prime
            * result
            + ((propertyName == null)
                ? 0 : propertyName.hashCode());
        result = prime
            * result
            + ((propertyValue == null)
                ? 0 : propertyValue.hashCode());
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
        ProductProperty other = (ProductProperty) obj;
        if (product == null) {
            if (other.product != null)
                return false;
        } else
            if (!product.equals(other.product))
                return false;
        if (propertyName == null) {
            if (other.propertyName != null)
                return false;
        } else
            if (!propertyName.equals(other.propertyName))
                return false;
        if (propertyValue == null) {
            if (other.propertyValue != null)
                return false;
        } else
            if (!propertyValue.equals(other.propertyValue))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductProperty [product="
            + product + ", propertyName=" + propertyName + ", propertyValue=" + propertyValue + "]";
    }

    public static String toString(List<ProductProperty> properties) {
        StringBuffer buffer = new StringBuffer();
        if (properties != null) {
            for (ProductProperty productProperty : properties) {
                buffer.append(productProperty.propertyName
                    + "=" + productProperty.propertyValue);
                buffer.append("/");
            }
        }
        return buffer.toString();
    }

}
