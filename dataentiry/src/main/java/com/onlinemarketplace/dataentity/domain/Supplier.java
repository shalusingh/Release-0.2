package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.enums.SupplierStatus;
import com.onlinemarketplace.dataentity.enums.TypeOfGods;

/**
 * @author jitndra.sagoriya
 */
@Entity
@Table(name="supplier")
public class Supplier implements Serializable {

	private static final long serialVersionUID = -5188813846273305344L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long supplierId;
	
	@Column(length=150,nullable=false,unique=true)
	private String name;
	
	@Column(length=12,nullable=false)
	private String mobileNumber;
	
	@Column(length=12,nullable=false)
	private String secondaryMobileNumber;
	
	@Column(length=12,nullable=true)
	private String landLineNumber;
	
	@Column(length=12,nullable=false)
	private String landLineNumber2;
	
	@Column(length=12,nullable=true)
	private String fax;
	
	@Column(length=50,nullable=false)
	private String email;
	
	@Column(length=50)
	private String url;
	
	@Column(length=50)
	private String logo;
	
	@Column(length=20,nullable=false)
	private String tinNumber;
	
	@Column(length=50,nullable=false)
	private String registrationNumber ;
	
	@Column(nullable=false)
	private Timestamp registrationDate;
	
	@Column(nullable=false)
	private SupplierStatus supplierStatus; 
	
	@Column(nullable=false)
	private TypeOfGods typeOfGods;
	
	@Column(length=150)
	private String extraField1;
	
	@Column(length=150)
	private String extraField2;
	
	@Column(length=150)
	private String extraField3;
	
	@Column(length=200)
	private String extraField4;

	public Supplier() {
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSecondaryMobileNumber() {
		return secondaryMobileNumber;
	}

	public void setSecondaryMobileNumber(String secondaryMobileNumber) {
		this.secondaryMobileNumber = secondaryMobileNumber;
	}

	public String getLandLineNumber() {
		return landLineNumber;
	}

	public void setLandLineNumber(String landLineNumber) {
		this.landLineNumber = landLineNumber;
	}

	public String getLandLineNumber2() {
		return landLineNumber2;
	}

	public void setLandLineNumber2(String landLineNumber2) {
		this.landLineNumber2 = landLineNumber2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTinNumber() {
		return tinNumber;
	}

	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public SupplierStatus getSupplierStatus() {
		return supplierStatus;
	}

	public void setSupplierStatus(SupplierStatus supplierStatus) {
		this.supplierStatus = supplierStatus;
	}

	public TypeOfGods getTypeOfGods() {
		return typeOfGods;
	}

	public void setTypeOfGods(TypeOfGods typeOfGods) {
		this.typeOfGods = typeOfGods;
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

	public String getExtraField4() {
		return extraField4;
	}

	public void setExtraField4(String extraField4) {
		this.extraField4 = extraField4;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((extraField1 == null) ? 0 : extraField1.hashCode());
		result = prime * result
				+ ((extraField2 == null) ? 0 : extraField2.hashCode());
		result = prime * result
				+ ((extraField3 == null) ? 0 : extraField3.hashCode());
		result = prime * result
				+ ((extraField4 == null) ? 0 : extraField4.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result
				+ ((landLineNumber == null) ? 0 : landLineNumber.hashCode());
		result = prime * result
				+ ((landLineNumber2 == null) ? 0 : landLineNumber2.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result
				+ ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime
				* result
				+ ((registrationNumber == null) ? 0 : registrationNumber
						.hashCode());
		result = prime
				* result
				+ ((secondaryMobileNumber == null) ? 0 : secondaryMobileNumber
						.hashCode());
		result = prime * result
				+ ((supplierId == null) ? 0 : supplierId.hashCode());
		result = prime * result
				+ ((supplierStatus == null) ? 0 : supplierStatus.hashCode());
		result = prime * result
				+ ((tinNumber == null) ? 0 : tinNumber.hashCode());
		result = prime * result
				+ ((typeOfGods == null) ? 0 : typeOfGods.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Supplier other = (Supplier) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (extraField4 == null) {
			if (other.extraField4 != null)
				return false;
		} else if (!extraField4.equals(other.extraField4))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (landLineNumber == null) {
			if (other.landLineNumber != null)
				return false;
		} else if (!landLineNumber.equals(other.landLineNumber))
			return false;
		if (landLineNumber2 == null) {
			if (other.landLineNumber2 != null)
				return false;
		} else if (!landLineNumber2.equals(other.landLineNumber2))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (registrationNumber == null) {
			if (other.registrationNumber != null)
				return false;
		} else if (!registrationNumber.equals(other.registrationNumber))
			return false;
		if (secondaryMobileNumber == null) {
			if (other.secondaryMobileNumber != null)
				return false;
		} else if (!secondaryMobileNumber.equals(other.secondaryMobileNumber))
			return false;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		if (supplierStatus != other.supplierStatus)
			return false;
		if (tinNumber == null) {
			if (other.tinNumber != null)
				return false;
		} else if (!tinNumber.equals(other.tinNumber))
			return false;
		if (typeOfGods != other.typeOfGods)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", name=" + name
				+ ", mobileNumber=" + mobileNumber + ", secondaryMobileNumber="
				+ secondaryMobileNumber + ", landLineNumber=" + landLineNumber
				+ ", landLineNumber2=" + landLineNumber2 + ", fax=" + fax
				+ ", email=" + email + ", url=" + url + ", logo=" + logo
				+ ", tinNumber=" + tinNumber + ", registrationNumber="
				+ registrationNumber + ", registrationDate=" + registrationDate
				+ ", supplierStatus=" + supplierStatus + ", typeOfGods="
				+ typeOfGods + ", extraField1=" + extraField1
				+ ", extraField2=" + extraField2 + ", extraField3="
				+ extraField3 + ", extraField4=" + extraField4 + "]";
	}
	
	
}
