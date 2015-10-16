package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.enums.PaymentStatus;

/**
 * @author jitu
 */
@Entity
@Table(name="payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	
	@Column(nullable = false)
	private Timestamp paymentDate;
	
	private Long orderId;
	
	private Long customerId;
	
	@Column(nullable = false)
	private PaymentStatus status;
	
	@Column(nullable = false)
	private Float finalCost;
	
	@Column(nullable = false)
	private Float totalDiscount;
	
	@Column(nullable = true,length=150)
	private String statusDescription;
	
	@Column(nullable = false,length=100)
	private String source;
	
	@Column(nullable = false,length=100)
	private String mode;
	
	@Column(nullable = false,length=15)
	private String ipAddress;
	
	@Column(nullable = false,length =100)
	private String transactionId;
	
	@Column(length=150)
	private String extraField1;
	
	@Column(length=150)
	private String extraField2;
	
	@Column(length=150)
	private String extraField3;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

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

	public PaymentStatus getStatus() {
		return status;
	}

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

	public String getExtraField1() {
		return extraField1;
	}

	public void setExtraField1(String extraField1) {
		this.extraField1 = extraField1;
	}

	public String getExtraField2() {
		return extraField2;
	}

	public void setExtraField2(String extraField2) {
		this.extraField2 = extraField2;
	}

	public String getExtraField3() {
		return extraField3;
	}

	public void setExtraField3(String extraField3) {
		this.extraField3 = extraField3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((extraField1 == null) ? 0 : extraField1.hashCode());
		result = prime * result
				+ ((extraField2 == null) ? 0 : extraField2.hashCode());
		result = prime * result
				+ ((extraField3 == null) ? 0 : extraField3.hashCode());
		result = prime * result
				+ ((finalCost == null) ? 0 : finalCost.hashCode());
		result = prime * result
				+ ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result
				+ ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result
				+ ((paymentId == null) ? 0 : paymentId.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime
				* result
				+ ((statusDescription == null) ? 0 : statusDescription
						.hashCode());
		result = prime * result
				+ ((totalDiscount == null) ? 0 : totalDiscount.hashCode());
		result = prime * result
				+ ((transactionId == null) ? 0 : transactionId.hashCode());
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
		Payment other = (Payment) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (extraField1 == null) {
			if (other.extraField1 != null)
				return false;
		} else if (!extraField1.equals(other.extraField1))
			return false;
		if (extraField2 == null) {
			if (other.extraField2 != null)
				return false;
		} else if (!extraField2.equals(other.extraField2))
			return false;
		if (extraField3 == null) {
			if (other.extraField3 != null)
				return false;
		} else if (!extraField3.equals(other.extraField3))
			return false;
		if (finalCost == null) {
			if (other.finalCost != null)
				return false;
		} else if (!finalCost.equals(other.finalCost))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (mode == null) {
			if (other.mode != null)
				return false;
		} else if (!mode.equals(other.mode))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (paymentId == null) {
			if (other.paymentId != null)
				return false;
		} else if (!paymentId.equals(other.paymentId))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (status != other.status)
			return false;
		if (statusDescription == null) {
			if (other.statusDescription != null)
				return false;
		} else if (!statusDescription.equals(other.statusDescription))
			return false;
		if (totalDiscount == null) {
			if (other.totalDiscount != null)
				return false;
		} else if (!totalDiscount.equals(other.totalDiscount))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDate="
				+ paymentDate + ", orderId=" + orderId + ", customerId="
				+ customerId + ", status=" + status + ", finalCost="
				+ finalCost + ", totalDiscount=" + totalDiscount
				+ ", statusDescription=" + statusDescription + ", source="
				+ source + ", mode=" + mode + ", ipAddress=" + ipAddress
				+ ", transactionId=" + transactionId + ", extraField1="
				+ extraField1 + ", extraField2=" + extraField2
				+ ", extraField3=" + extraField3 + "]";
	}
	
	

}
