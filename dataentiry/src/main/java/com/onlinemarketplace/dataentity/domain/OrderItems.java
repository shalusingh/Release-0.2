package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;

/**
 * @author jitu
 */
@Entity
@Table(name = "orderitems")
public class OrderItems
    extends NaturalAbstractEntity<Long>
    implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long orderId;

    private Long productId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Float costPerUnit;

    @Column(nullable = false)
    private Float totalCost;

    @Column(nullable = false)
    private Float discountPerUnit;

    @Column(nullable = false)
    private Float totalDiscount;

    @Column(nullable = false)
    private Float tax;

    @Column(nullable = false)
    private Float finalCost;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(Float costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    public Float getDiscountPerUnit() {
        return discountPerUnit;
    }

    public void setDiscountPerUnit(Float discountPerUnit) {
        this.discountPerUnit = discountPerUnit;
    }

    public Float getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Float totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Float getTax() {
        return tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

    public Float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Float finalCost) {
        this.finalCost = finalCost;
    }

    @Override
    public String toString() {
        return "OrderItems [orderId="
            + orderId + ", productId=" + productId + ", quantity=" + quantity + ", costPerUnit=" + costPerUnit
            + ", totalCost=" + totalCost + ", discountPerUnit=" + discountPerUnit + ", totalDiscount=" + totalDiscount
            + ", tax=" + tax + ", finalCost=" + finalCost + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((costPerUnit == null)
                ? 0 : costPerUnit.hashCode());
        result = prime
            * result
            + ((discountPerUnit == null)
                ? 0 : discountPerUnit.hashCode());
        result = prime
            * result
            + ((finalCost == null)
                ? 0 : finalCost.hashCode());
        result = prime
            * result
            + ((orderId == null)
                ? 0 : orderId.hashCode());
        result = prime
            * result
            + ((productId == null)
                ? 0 : productId.hashCode());
        result = prime
            * result
            + quantity;
        result = prime
            * result
            + ((tax == null)
                ? 0 : tax.hashCode());
        result = prime
            * result
            + ((totalCost == null)
                ? 0 : totalCost.hashCode());
        result = prime
            * result
            + ((totalDiscount == null)
                ? 0 : totalDiscount.hashCode());
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
        OrderItems other = (OrderItems) obj;
        if (costPerUnit == null) {
            if (other.costPerUnit != null)
                return false;
        } else
            if (!costPerUnit.equals(other.costPerUnit))
                return false;
        if (discountPerUnit == null) {
            if (other.discountPerUnit != null)
                return false;
        } else
            if (!discountPerUnit.equals(other.discountPerUnit))
                return false;
        if (finalCost == null) {
            if (other.finalCost != null)
                return false;
        } else
            if (!finalCost.equals(other.finalCost))
                return false;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else
            if (!orderId.equals(other.orderId))
                return false;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else
            if (!productId.equals(other.productId))
                return false;
        if (quantity != other.quantity)
            return false;
        if (tax == null) {
            if (other.tax != null)
                return false;
        } else
            if (!tax.equals(other.tax))
                return false;
        if (totalCost == null) {
            if (other.totalCost != null)
                return false;
        } else
            if (!totalCost.equals(other.totalCost))
                return false;
        if (totalDiscount == null) {
            if (other.totalDiscount != null)
                return false;
        } else
            if (!totalDiscount.equals(other.totalDiscount))
                return false;
        return true;
    }

}
