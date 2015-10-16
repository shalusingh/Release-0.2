package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.enums.OrderStatus;



/**
 * @author jitu
 */
@Entity
@Table(name="orderitemdelivery")
public class OrderItemDelivery implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deliveryId;
	
	@Column(nullable=false)
	private Long orderItemId;
	
	@Column(nullable=false)
	private Long supplierId;
	
	@Column(nullable=false)
	private Timestamp orderDate;
	
	@Column(nullable=false)
	private Timestamp deliveredDate;
	
	@Column(nullable=false)
	private OrderStatus status;
	
	@Column(nullable=false,length=150)
	private String deliveryBy;
	
	@Column(nullable=false,length=150,unique=true)
	private String tackingNumber;
	
	@Column(nullable=false)
	private Float deliveryCharge;
	
	@Column(nullable=false)
	private String paymentMode;
	
	@Column(length=150)
	private String extraField1;
	
	@Column(length=200)
	private String extraField2;
	
	@Column(length=200)
	private String extraField3;

	public OrderItemDelivery() {
		super();
	}

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

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
				+ ((deliveredDate == null) ? 0 : deliveredDate.hashCode());
		result = prime * result
				+ ((deliveryBy == null) ? 0 : deliveryBy.hashCode());
		result = prime * result
				+ ((deliveryCharge == null) ? 0 : deliveryCharge.hashCode());
		result = prime * result
				+ ((deliveryId == null) ? 0 : deliveryId.hashCode());
		result = prime * result
				+ ((extraField1 == null) ? 0 : extraField1.hashCode());
		result = prime * result
				+ ((extraField2 == null) ? 0 : extraField2.hashCode());
		result = prime * result
				+ ((extraField3 == null) ? 0 : extraField3.hashCode());
		result = prime * result
				+ ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result
				+ ((orderItemId == null) ? 0 : orderItemId.hashCode());
		result = prime * result
				+ ((paymentMode == null) ? 0 : paymentMode.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((supplierId == null) ? 0 : supplierId.hashCode());
		result = prime * result
				+ ((tackingNumber == null) ? 0 : tackingNumber.hashCode());
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
		OrderItemDelivery other = (OrderItemDelivery) obj;
		if (deliveredDate == null) {
			if (other.deliveredDate != null)
				return false;
		} else if (!deliveredDate.equals(other.deliveredDate))
			return false;
		if (deliveryBy == null) {
			if (other.deliveryBy != null)
				return false;
		} else if (!deliveryBy.equals(other.deliveryBy))
			return false;
		if (deliveryCharge == null) {
			if (other.deliveryCharge != null)
				return false;
		} else if (!deliveryCharge.equals(other.deliveryCharge))
			return false;
		if (deliveryId == null) {
			if (other.deliveryId != null)
				return false;
		} else if (!deliveryId.equals(other.deliveryId))
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
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderItemId == null) {
			if (other.orderItemId != null)
				return false;
		} else if (!orderItemId.equals(other.orderItemId))
			return false;
		if (paymentMode == null) {
			if (other.paymentMode != null)
				return false;
		} else if (!paymentMode.equals(other.paymentMode))
			return false;
		if (status != other.status)
			return false;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		if (tackingNumber == null) {
			if (other.tackingNumber != null)
				return false;
		} else if (!tackingNumber.equals(other.tackingNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItemDelivery [deliveryId=" + deliveryId + ", orderItemId="
				+ orderItemId + ", supplierId=" + supplierId + ", orderDate="
				+ orderDate + ", deliveredDate=" + deliveredDate + ", status="
				+ status + ", deliveryBy=" + deliveryBy + ", tackingNumber="
				+ tackingNumber + ", deliveryCharge=" + deliveryCharge
				+ ", paymentMode=" + paymentMode + ", extraField1="
				+ extraField1 + ", extraField2=" + extraField2
				+ ", extraField3=" + extraField3 + "]";
	}
	

}
