package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;

/**
 * @author jitu
 */

@Entity
@Table(name = "wishlist")
public class WishList
    extends NaturalAbstractEntity<Long>
    implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    private Long customerId;

    @Column
    private Long productId;

    @Column(nullable = false)
    private Timestamp date;

    @Column(nullable = false)
    private int status;

    public WishList() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((customerId == null)
                ? 0 : customerId.hashCode());
        result = prime
            * result
            + ((date == null)
                ? 0 : date.hashCode());
        result = prime
            * result
            + ((id == null)
                ? 0 : id.hashCode());
        result = prime
            * result
            + ((productId == null)
                ? 0 : productId.hashCode());
        result = prime
            * result
            + status;
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
        WishList other = (WishList) obj;
        if (customerId == null) {
            if (other.customerId != null)
                return false;
        } else
            if (!customerId.equals(other.customerId))
                return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else
            if (!date.equals(other.date))
                return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else
            if (!id.equals(other.id))
                return false;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else
            if (!productId.equals(other.productId))
                return false;
        if (status != other.status)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WishList [id="
            + id + ", customerId=" + customerId + ", productId=" + productId + ", date=" + date + ", status=" + status
            + "]";
    }

}
