
package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;
import com.onlinemarketplace.dataentity.enums.CustomerStatus;

@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "byEmailAndPassword",
        query = "SELECT c FROM Customer c where c.email= :email AND c.password= :password") })
public class Customer
    extends NaturalAbstractEntity<Long>
    implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8989687019288919573L;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "registrationDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp registrationDate;

    @Column(name = "lastLogin", nullable = true)
    private Timestamp lastLogin;

    @Column(name = "mobileNumber", nullable = false, length = 12)
    private String mobileNumber;

    @Column(name = "landLineNumber", nullable = true, length = 15)
    private String landLineNumber;

    @Column(name = "status", nullable = false)
    private CustomerStatus status;

    @Column(name = "phoneNumber", nullable = true, length = 12)
    private String phoneNumber;

    @Column(name = "secondaryEmail", nullable = true)
    private String secondaryEmail;

    @Column(name = "country", nullable = true)
    private String country;

    @Column(name = "organization", nullable = true)
    private String organization;

    public List<CustomerAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CustomerAddress> addresses) {
        this.addresses = addresses;
    }

    @Column(name = "extraField3", nullable = true)
    private String extraField3;

    @OneToMany(targetEntity = CustomerAddress.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    List<CustomerAddress> addresses;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLandLineNumber() {
        return landLineNumber;
    }

    public void setLandLineNumber(String landLineNumber) {
        this.landLineNumber = landLineNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getExtraField3() {
        return extraField3;
    }

    public void setExtraField3(String extraField3) {
        this.extraField3 = extraField3;
    }

    @Override
    public String toString() {
        return "Customer [email="
            + email + ", name=" + name + ", password=" + password + ", registrationDate=" + registrationDate
            + ", lastLogin=" + lastLogin + ", mobileNumber=" + mobileNumber + ", landLineNumber=" + landLineNumber
            + ", status=" + status + ", phoneNumber=" + phoneNumber + ", secondaryEmail=" + secondaryEmail
            + ", country=" + country + ", organization=" + organization + ", extraField3=" + extraField3
            + ", addresses=" + addresses + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((addresses == null)
                ? 0 : addresses.hashCode());
        result = prime
            * result
            + ((country == null)
                ? 0 : country.hashCode());
        result = prime
            * result
            + ((email == null)
                ? 0 : email.hashCode());
        result = prime
            * result
            + ((extraField3 == null)
                ? 0 : extraField3.hashCode());
        result = prime
            * result
            + ((landLineNumber == null)
                ? 0 : landLineNumber.hashCode());
        result = prime
            * result
            + ((lastLogin == null)
                ? 0 : lastLogin.hashCode());
        result = prime
            * result
            + ((mobileNumber == null)
                ? 0 : mobileNumber.hashCode());
        result = prime
            * result
            + ((name == null)
                ? 0 : name.hashCode());
        result = prime
            * result
            + ((organization == null)
                ? 0 : organization.hashCode());
        result = prime
            * result
            + ((password == null)
                ? 0 : password.hashCode());
        result = prime
            * result
            + ((phoneNumber == null)
                ? 0 : phoneNumber.hashCode());
        result = prime
            * result
            + ((registrationDate == null)
                ? 0 : registrationDate.hashCode());
        result = prime
            * result
            + ((secondaryEmail == null)
                ? 0 : secondaryEmail.hashCode());
        result = prime
            * result
            + ((status == null)
                ? 0 : status.hashCode());
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
        Customer other = (Customer) obj;
        if (addresses == null) {
            if (other.addresses != null)
                return false;
        } else
            if (!addresses.equals(other.addresses))
                return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else
            if (!country.equals(other.country))
                return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else
            if (!email.equals(other.email))
                return false;
        if (extraField3 == null) {
            if (other.extraField3 != null)
                return false;
        } else
            if (!extraField3.equals(other.extraField3))
                return false;
        if (landLineNumber == null) {
            if (other.landLineNumber != null)
                return false;
        } else
            if (!landLineNumber.equals(other.landLineNumber))
                return false;
        if (lastLogin == null) {
            if (other.lastLogin != null)
                return false;
        } else
            if (!lastLogin.equals(other.lastLogin))
                return false;
        if (mobileNumber == null) {
            if (other.mobileNumber != null)
                return false;
        } else
            if (!mobileNumber.equals(other.mobileNumber))
                return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else
            if (!name.equals(other.name))
                return false;
        if (organization == null) {
            if (other.organization != null)
                return false;
        } else
            if (!organization.equals(other.organization))
                return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else
            if (!password.equals(other.password))
                return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else
            if (!phoneNumber.equals(other.phoneNumber))
                return false;
        if (registrationDate == null) {
            if (other.registrationDate != null)
                return false;
        } else
            if (!registrationDate.equals(other.registrationDate))
                return false;
        if (secondaryEmail == null) {
            if (other.secondaryEmail != null)
                return false;
        } else
            if (!secondaryEmail.equals(other.secondaryEmail))
                return false;
        if (status != other.status)
            return false;
        return true;
    }

}
