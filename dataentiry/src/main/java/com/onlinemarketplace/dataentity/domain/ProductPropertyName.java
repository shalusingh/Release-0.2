package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.StateFullNaturalEntity;
import com.onlinemarketplace.dataentity.enums.Status;

/**
 * @author jitu
 */
@Entity
@Table(name = "productpropertyname")
public class ProductPropertyName
    extends StateFullNaturalEntity<Status, Long>
    implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    private Long categoryId;

    @Column(length = 50, nullable = false)
    private String propertName;

    public ProductPropertyName() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getPropertName() {
        return propertName;
    }

    public void setPropertName(String propertName) {
        this.propertName = propertName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((categoryId == null)
                ? 0 : categoryId.hashCode());
        result = prime
            * result
            + ((propertName == null)
                ? 0 : propertName.hashCode());
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
        ProductPropertyName other = (ProductPropertyName) obj;
        if (categoryId == null) {
            if (other.categoryId != null)
                return false;
        } else
            if (!categoryId.equals(other.categoryId))
                return false;
        if (propertName == null) {
            if (other.propertName != null)
                return false;
        } else
            if (!propertName.equals(other.propertName))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "ProductPropertyName [categoryId="
            + categoryId + ", propertName=" + propertName + "]";
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
