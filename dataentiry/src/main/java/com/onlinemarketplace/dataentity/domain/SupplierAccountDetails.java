package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
/**
 * @author jitu
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;

@Entity
@Table(name = "supplieraccountdetails")
public class SupplierAccountDetails
    extends NaturalAbstractEntity<Long>
    implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false)
    private Long supplierId;

    @Column(nullable = false)
    private Long accountNumber;

    @Column(nullable = false, length = 150)
    private String branchName;

    @Column(nullable = false, length = 250)
    private String branchAddress;

    @Column(nullable = false, length = 150)
    private String bankCity;

    @Column(nullable = false, length = 150)
    private String bankState;

    public SupplierAccountDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getBankState() {
        return bankState;
    }

    public void setBankState(String bankState) {
        this.bankState = bankState;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((accountNumber == null)
                ? 0 : accountNumber.hashCode());
        result = prime
            * result
            + ((bankCity == null)
                ? 0 : bankCity.hashCode());
        result = prime
            * result
            + ((bankState == null)
                ? 0 : bankState.hashCode());
        result = prime
            * result
            + ((branchAddress == null)
                ? 0 : branchAddress.hashCode());
        result = prime
            * result
            + ((branchName == null)
                ? 0 : branchName.hashCode());
        result = prime
            * result
            + ((supplierId == null)
                ? 0 : supplierId.hashCode());
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
        SupplierAccountDetails other = (SupplierAccountDetails) obj;
        if (accountNumber == null) {
            if (other.accountNumber != null)
                return false;
        } else
            if (!accountNumber.equals(other.accountNumber))
                return false;
        if (bankCity == null) {
            if (other.bankCity != null)
                return false;
        } else
            if (!bankCity.equals(other.bankCity))
                return false;
        if (bankState == null) {
            if (other.bankState != null)
                return false;
        } else
            if (!bankState.equals(other.bankState))
                return false;
        if (branchAddress == null) {
            if (other.branchAddress != null)
                return false;
        } else
            if (!branchAddress.equals(other.branchAddress))
                return false;
        if (branchName == null) {
            if (other.branchName != null)
                return false;
        } else
            if (!branchName.equals(other.branchName))
                return false;
        if (supplierId == null) {
            if (other.supplierId != null)
                return false;
        } else
            if (!supplierId.equals(other.supplierId))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "SupplierAccountDetails [supplierId="
            + supplierId + ", accountNumber=" + accountNumber + ", branchName=" + branchName + ", branchAddress="
            + branchAddress + ", bankCity=" + bankCity + ", bankState=" + bankState + "]";
    }

}
