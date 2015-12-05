package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;
import com.onlinemarketplace.dataentity.enums.OrderStatus;

/**
 * @author jitu
 */
@Entity
@Table(name = "orderitemdelivery")
public class OrderItemDelivery
    extends NaturalAbstractEntity<Long>
    implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Long orderItemId;

    @Column(nullable = false)
    private Long supplierId;

    @Column(nullable = false)
    private Timestamp orderDate;

    @Column(nullable = false)
    private Timestamp deliveredDate;

    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false, length = 150)
    private String deliveryBy;

    @Column(nullable = false, length = 150, unique = true)
    private String tackingNumber;

    @Column(nullable = false)
    private Float deliveryCharge;

    @Column(nullable = false)
    private String paymentMode;

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Timestamp deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getDeliveryBy() {
        return deliveryBy;
    }

    public void setDeliveryBy(String deliveryBy) {
        this.deliveryBy = deliveryBy;
    }

    public String getTackingNumber() {
        return tackingNumber;
    }

    public void setTackingNumber(String tackingNumber) {
        this.tackingNumber = tackingNumber;
    }

    public Float getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Float deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((deliveredDate == null)
                ? 0 : deliveredDate.hashCode());
        result = prime
            * result
            + ((deliveryBy == null)
                ? 0 : deliveryBy.hashCode());
        result = prime
            * result
            + ((deliveryCharge == null)
                ? 0 : deliveryCharge.hashCode());
        result = prime
            * result
            + ((orderDate == null)
                ? 0 : orderDate.hashCode());
        result = prime
            * result
            + ((orderItemId == null)
                ? 0 : orderItemId.hashCode());
        result = prime
            * result
            + ((paymentMode == null)
                ? 0 : paymentMode.hashCode());
        result = prime
            * result
            + ((status == null)
                ? 0 : status.hashCode());
        result = prime
            * result
            + ((supplierId == null)
                ? 0 : supplierId.hashCode());
        result = prime
            * result
            + ((tackingNumber == null)
                ? 0 : tackingNumber.hashCode());
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
        OrderItemDelivery other = (OrderItemDelivery) obj;
        if (deliveredDate == null) {
            if (other.deliveredDate != null)
                return false;
        } else
            if (!deliveredDate.equals(other.deliveredDate))
                return false;
        if (deliveryBy == null) {
            if (other.deliveryBy != null)
                return false;
        } else
            if (!deliveryBy.equals(other.deliveryBy))
                return false;
        if (deliveryCharge == null) {
            if (other.deliveryCharge != null)
                return false;
        } else
            if (!deliveryCharge.equals(other.deliveryCharge))
                return false;
        if (orderDate == null) {
            if (other.orderDate != null)
                return false;
        } else
            if (!orderDate.equals(other.orderDate))
                return false;
        if (orderItemId == null) {
            if (other.orderItemId != null)
                return false;
        } else
            if (!orderItemId.equals(other.orderItemId))
                return false;
        if (paymentMode == null) {
            if (other.paymentMode != null)
                return false;
        } else
            if (!paymentMode.equals(other.paymentMode))
                return false;
        if (status != other.status)
            return false;
        if (supplierId == null) {
            if (other.supplierId != null)
                return false;
        } else
            if (!supplierId.equals(other.supplierId))
                return false;
        if (tackingNumber == null) {
            if (other.tackingNumber != null)
                return false;
        } else
            if (!tackingNumber.equals(other.tackingNumber))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderItemDelivery [orderItemId="
            + orderItemId + ", supplierId=" + supplierId + ", orderDate=" + orderDate + ", deliveredDate="
            + deliveredDate + ", status=" + status + ", deliveryBy=" + deliveryBy + ", tackingNumber=" + tackingNumber
            + ", deliveryCharge=" + deliveryCharge + ", paymentMode=" + paymentMode + "]";
    }

}
