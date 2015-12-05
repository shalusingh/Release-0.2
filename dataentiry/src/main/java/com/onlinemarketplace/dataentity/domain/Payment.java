package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.StateFullNaturalEntity;
import com.onlinemarketplace.dataentity.enums.PaymentStatus;

/**
 * @author jitu
 */
@Entity
@Table(name = "payment")
public class Payment
    extends StateFullNaturalEntity<PaymentStatus, Long>
    implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Timestamp paymentDate;

    private Long orderId;

    private Long customerId;

    @Column(nullable = false)
    private Float finalCost;

    @Column(nullable = false)
    private Float totalDiscount;

    @Column(nullable = true, length = 150)
    private String statusDescription;

    @Column(nullable = false, length = 100)
    private String source;

    @Column(nullable = false, length = 100)
    private String mode;

    @Column(nullable = false, length = 15)
    private String ipAddress;

    @Column(nullable = false, length = 100)
    private String transactionId;

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public PaymentStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public Float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Float finalCost) {
        this.finalCost = finalCost;
    }

    public Float getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Float totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((customerId == null)
                ? 0 : customerId.hashCode());
        result = prime
            * result
            + ((finalCost == null)
                ? 0 : finalCost.hashCode());
        result = prime
            * result
            + ((ipAddress == null)
                ? 0 : ipAddress.hashCode());
        result = prime
            * result
            + ((mode == null)
                ? 0 : mode.hashCode());
        result = prime
            * result
            + ((orderId == null)
                ? 0 : orderId.hashCode());
        result = prime
            * result
            + ((paymentDate == null)
                ? 0 : paymentDate.hashCode());
        result = prime
            * result
            + ((source == null)
                ? 0 : source.hashCode());
        result = prime
            * result
            + ((status == null)
                ? 0 : status.hashCode());
        result = prime
            * result
            + ((statusDescription == null)
                ? 0 : statusDescription.hashCode());
        result = prime
            * result
            + ((totalDiscount == null)
                ? 0 : totalDiscount.hashCode());
        result = prime
            * result
            + ((transactionId == null)
                ? 0 : transactionId.hashCode());
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
        Payment other = (Payment) obj;
        if (customerId == null) {
            if (other.customerId != null)
                return false;
        } else
            if (!customerId.equals(other.customerId))
                return false;
        if (finalCost == null) {
            if (other.finalCost != null)
                return false;
        } else
            if (!finalCost.equals(other.finalCost))
                return false;
        if (ipAddress == null) {
            if (other.ipAddress != null)
                return false;
        } else
            if (!ipAddress.equals(other.ipAddress))
                return false;
        if (mode == null) {
            if (other.mode != null)
                return false;
        } else
            if (!mode.equals(other.mode))
                return false;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else
            if (!orderId.equals(other.orderId))
                return false;
        if (paymentDate == null) {
            if (other.paymentDate != null)
                return false;
        } else
            if (!paymentDate.equals(other.paymentDate))
                return false;
        if (source == null) {
            if (other.source != null)
                return false;
        } else
            if (!source.equals(other.source))
                return false;
        if (status != other.status)
            return false;
        if (statusDescription == null) {
            if (other.statusDescription != null)
                return false;
        } else
            if (!statusDescription.equals(other.statusDescription))
                return false;
        if (totalDiscount == null) {
            if (other.totalDiscount != null)
                return false;
        } else
            if (!totalDiscount.equals(other.totalDiscount))
                return false;
        if (transactionId == null) {
            if (other.transactionId != null)
                return false;
        } else
            if (!transactionId.equals(other.transactionId))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "Paymentt [paymentDate="
            + paymentDate + ", orderId=" + orderId + ", customerId=" + customerId + ", status=" + status
            + ", finalCost=" + finalCost + ", totalDiscount=" + totalDiscount + ", statusDescription="
            + statusDescription + ", source=" + source + ", mode=" + mode + ", ipAddress=" + ipAddress
            + ", transactionId=" + transactionId + "]";
    }

}
