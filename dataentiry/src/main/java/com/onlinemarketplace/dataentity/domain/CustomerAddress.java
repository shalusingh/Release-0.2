package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;
import com.onlinemarketplace.dataentity.enums.AddressStatus;

/**
 * @author jitndra.sagoriya
 *
 */
@Entity
@Table(name = "customeraddress")
public class CustomerAddress
    extends NaturalAbstractEntity<Long>
    implements Serializable {

    private static final long serialVersionUID = 7802271965474985994L;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;

    @Column(length = 200)
    private String addressLine1;

    @Column(length = 200)
    private String addressLine2;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String state;

    @Column(length = 6)
    private Long pinCode;

    @Column(length = 1)
    private AddressStatus addressStatus;

    @Column(length = 1)
    private int isPrimaryAddrss;

    @Column(length = 1)
    private int isDeliveryAddress;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }

    public AddressStatus getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(AddressStatus addressStatus) {
        this.addressStatus = addressStatus;
    }

    public int getIsPrimaryAddrss() {
        return isPrimaryAddrss;
    }

    public void setIsPrimaryAddrss(int isPrimaryAddrss) {
        this.isPrimaryAddrss = isPrimaryAddrss;
    }

    public int getIsDeliveryAddress() {
        return isDeliveryAddress;
    }

    public void setIsDeliveryAddress(int isDeliveryAddress) {
        this.isDeliveryAddress = isDeliveryAddress;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((addressLine1 == null)
                ? 0 : addressLine1.hashCode());
        result = prime
            * result
            + ((addressLine2 == null)
                ? 0 : addressLine2.hashCode());
        result = prime
            * result
            + ((addressStatus == null)
                ? 0 : addressStatus.hashCode());
        result = prime
            * result
            + ((city == null)
                ? 0 : city.hashCode());
        result = prime
            * result
            + ((customer == null)
                ? 0 : customer.hashCode());
        result = prime
            * result
            + isDeliveryAddress;
        result = prime
            * result
            + isPrimaryAddrss;
        result = prime
            * result
            + ((pinCode == null)
                ? 0 : pinCode.hashCode());
        result = prime
            * result
            + ((state == null)
                ? 0 : state.hashCode());
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
        CustomerAddress other = (CustomerAddress) obj;
        if (addressLine1 == null) {
            if (other.addressLine1 != null)
                return false;
        } else
            if (!addressLine1.equals(other.addressLine1))
                return false;
        if (addressLine2 == null) {
            if (other.addressLine2 != null)
                return false;
        } else
            if (!addressLine2.equals(other.addressLine2))
                return false;
        if (addressStatus != other.addressStatus)
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else
            if (!city.equals(other.city))
                return false;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else
            if (!customer.equals(other.customer))
                return false;
        if (isDeliveryAddress != other.isDeliveryAddress)
            return false;
        if (isPrimaryAddrss != other.isPrimaryAddrss)
            return false;
        if (pinCode == null) {
            if (other.pinCode != null)
                return false;
        } else
            if (!pinCode.equals(other.pinCode))
                return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else
            if (!state.equals(other.state))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomerAddress [customer="
            + customer + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
            + ", state=" + state + ", pinCode=" + pinCode + ", addressStatus=" + addressStatus + ", isPrimaryAddrss="
            + isPrimaryAddrss + ", isDeliveryAddress=" + isDeliveryAddress + "]";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
