package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @author jitndra.sagoriy
 */

@Entity
@Table(name="customersocialnetworks")
public class CustomerSocialNetworks implements Serializable {

	
	private static final long serialVersionUID = -3736091962672819654L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SOCIALNETWORKID")
	private Long socialNetworkId;
	
	@Column(length=20,name="CUSTOMERID")
	private Long customerId;

	@Column(length=300,name="SOCIALNETWORKTOKEN")
	private String socialNetworkToken;
	
	@Column(length=200,name="SOCIALNETWORKNAME")
	private String socialNetworkName;
	
	@Column(length=150,name="EXTRAFIELD1")
	private String extraField1;

	@Column(length=150,name="EXTRAFIELD2")
	private String extraField2;
	
	@Column(length=150,name="EXTRAFIELD3")
	private String extraField3;

	public CustomerSocialNetworks() {
		super();
	}

	public Long getSocialNetworkId() {
		return socialNetworkId;
	}

	public void setSocialNetworkId(Long socialNetworkId) {
		this.socialNetworkId = socialNetworkId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getSocialNetworkToken() {
		return socialNetworkToken;
	}

	public void setSocialNetworkToken(String socialNetworkToken) {
		this.socialNetworkToken = socialNetworkToken;
	}

	public String getSocialNetworkName() {
		return socialNetworkName;
	}

	public void setSocialNetworkName(String socialNetworkName) {
		this.socialNetworkName = socialNetworkName;
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
				+ ((socialNetworkId == null) ? 0 : socialNetworkId.hashCode());
		result = prime
				* result
				+ ((socialNetworkName == null) ? 0 : socialNetworkName
						.hashCode());
		result = prime
				* result
				+ ((socialNetworkToken == null) ? 0 : socialNetworkToken
						.hashCode());
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
		CustomerSocialNetworks other = (CustomerSocialNetworks) obj;
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
		if (socialNetworkId == null) {
			if (other.socialNetworkId != null)
				return false;
		} else if (!socialNetworkId.equals(other.socialNetworkId))
			return false;
		if (socialNetworkName == null) {
			if (other.socialNetworkName != null)
				return false;
		} else if (!socialNetworkName.equals(other.socialNetworkName))
			return false;
		if (socialNetworkToken == null) {
			if (other.socialNetworkToken != null)
				return false;
		} else if (!socialNetworkToken.equals(other.socialNetworkToken))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerSocialNetworks [socialNetworkId=" + socialNetworkId
				+ ", customerId=" + customerId + ", socialNetworkToken="
				+ socialNetworkToken + ", socialNetworkName="
				+ socialNetworkName + ", extraField1=" + extraField1
				+ ", extraField2=" + extraField2 + ", extraField3="
				+ extraField3 + "]";
	}
	
	
}
