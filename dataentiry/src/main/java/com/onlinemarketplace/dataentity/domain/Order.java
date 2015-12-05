package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.StateFullNaturalEntity;
import com.onlinemarketplace.dataentity.enums.OrderStatus;

/**
 * @author jitu
 */
@Entity
@Table(name = "orders")
public class Order
    extends StateFullNaturalEntity<OrderStatus, Long>
    implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private Long addressId;

    @Column(nullable = false)
    private Long cartId;

    @Column(nullable = false)
    private Timestamp orderDate;

    @Column(nullable = true)
    private Timestamp completionDate;

    @Column(nullable = false)
    private Float amount;

    @Column(nullable = false)
    private Float discount;

    @Column(nullable = true, length = 350)
    private String description;

    @Column(nullable = true, length = 350)
    private String statusDetails;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    @Override
    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Timestamp completionDate) {
        this.completionDate = completionDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusDetails() {
        return statusDetails;
    }

    public void setStatusDetails(String statusDetails) {
        this.statusDetails = statusDetails;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((addressId == null)
                ? 0 : addressId.hashCode());
        result = prime
            * result
            + ((amount == null)
                ? 0 : amount.hashCode());
        result = prime
            * result
            + ((cartId == null)
                ? 0 : cartId.hashCode());
        result = prime
            * result
            + ((completionDate == null)
                ? 0 : completionDate.hashCode());
        result = prime
            * result
            + ((customerId == null)
                ? 0 : customerId.hashCode());
        result = prime
            * result
            + ((description == null)
                ? 0 : description.hashCode());
        result = prime
            * result
            + ((discount == null)
                ? 0 : discount.hashCode());
        result = prime
            * result
            + ((orderDate == null)
                ? 0 : orderDate.hashCode());
        result = prime
            * result
            + ((status == null)
                ? 0 : status.hashCode());
        result = prime
            * result
            + ((statusDetails == null)
                ? 0 : statusDetails.hashCode());
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
        Order other = (Order) obj;
        if (addressId == null) {
            if (other.addressId != null)
                return false;
        } else
            if (!addressId.equals(other.addressId))
                return false;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else
            if (!amount.equals(other.amount))
                return false;
        if (cartId == null) {
            if (other.cartId != null)
                return false;
        } else
            if (!cartId.equals(other.cartId))
                return false;
        if (completionDate == null) {
            if (other.completionDate != null)
                return false;
        } else
            if (!completionDate.equals(other.completionDate))
                return false;
        if (customerId == null) {
            if (other.customerId != null)
                return false;
        } else
            if (!customerId.equals(other.customerId))
                return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else
            if (!description.equals(other.description))
                return false;
        if (discount == null) {
            if (other.discount != null)
                return false;
        } else
            if (!discount.equals(other.discount))
                return false;
        if (orderDate == null) {
            if (other.orderDate != null)
                return false;
        } else
            if (!orderDate.equals(other.orderDate))
                return false;
        if (status != other.status)
            return false;
        if (statusDetails == null) {
            if (other.statusDetails != null)
                return false;
        } else
            if (!statusDetails.equals(other.statusDetails))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [customerId="
            + customerId + ", addressId=" + addressId + ", cartId=" + cartId + ", status=" + status + ", orderDate="
            + orderDate + ", completionDate=" + completionDate + ", amount=" + amount + ", discount=" + discount
            + ", description=" + description + ", statusDetails=" + statusDetails + "]";
    }

}
