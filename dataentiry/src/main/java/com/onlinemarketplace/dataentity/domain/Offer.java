package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.enums.OfferType;


/**
 * @author jitndra sagoriya
 * @version
 */

@Entity
@Table(name="offer")
public class Offer implements Serializable {

	
	private static final long serialVersionUID = -3278311337487524745L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String offerName;
	
	@Column(nullable=false)
	private String code;
	
	@Column(nullable=false)
	private Date creationTime;
	
	@Column(nullable=false)
	private Date validTo;
	
	@Column(nullable=false)
	private OfferType offerType;
	
	@Column
	private int offerInCash;
	
	@Column
	private int offerInPercent;
	
	@ManyToOne(targetEntity=Product.class,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Product product;
	
	
	@Column(length=150)
	private String extraField1;
	
	@Column(length=150)
	private String extraField2;
	
	
	@Column(length=150)
	private String extraField3;


	public Offer() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getOfferName() {
		return offerName;
	}


	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Date getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}


	public Date getValidTo() {
		return validTo;
	}


	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}


	public OfferType getOfferType() {
		return offerType;
	}


	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}


	public int getOfferInCash() {
		return offerInCash;
	}


	public void setOfferInCash(int offerInCash) {
		this.offerInCash = offerInCash;
	}


	public int getOfferInPercent() {
		return offerInPercent;
	}


	public void setOfferInPercent(int offerInPercent) {
		this.offerInPercent = offerInPercent;
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((extraField1 == null) ? 0 : extraField1.hashCode());
		result = prime * result + ((extraField2 == null) ? 0 : extraField2.hashCode());
		result = prime * result + ((extraField3 == null) ? 0 : extraField3.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + offerInCash;
		result = prime * result + offerInPercent;
		result = prime * result + ((offerName == null) ? 0 : offerName.hashCode());
		result = prime * result + ((offerType == null) ? 0 : offerType.hashCode());
		result = prime * result + ((validTo == null) ? 0 : validTo.hashCode());
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
		Offer other = (Offer) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
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
		if (id != other.id)
			return false;
		if (offerInCash != other.offerInCash)
			return false;
		if (offerInPercent != other.offerInPercent)
			return false;
		if (offerName == null) {
			if (other.offerName != null)
				return false;
		} else if (!offerName.equals(other.offerName))
			return false;
		if (offerType != other.offerType)
			return false;
		if (validTo == null) {
			if (other.validTo != null)
				return false;
		} else if (!validTo.equals(other.validTo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Offer [id=" + id + ", offerName=" + offerName + ", code=" + code + ", creationTime=" + creationTime
				+ ", validTo=" + validTo + ", offerType=" + offerType + ", offerInCash=" + offerInCash
				+ ", offerInPercent=" + offerInPercent + ", extraField1=" + extraField1 + ", extraField2=" + extraField2
				+ ", extraField3=" + extraField3 + "]";
	}
	
	

}
