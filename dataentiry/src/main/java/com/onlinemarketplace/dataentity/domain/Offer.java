package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;
import com.onlinemarketplace.dataentity.enums.OfferType;

/**
 * @author jitndra sagoriya
 * @version
 */

@Entity
@Table(name = "offer")
public class Offer
    extends NaturalAbstractEntity<Long>
    implements Serializable {

    private static final long serialVersionUID = -3278311337487524745L;

    @Column(nullable = false)
    private String offerName;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private Date validTo;

    @Column(nullable = false)
    private OfferType offerType;

    @Column
    private int offerInCash;

    @Column
    private int offerInPercent;

    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Product product;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((code == null)
                ? 0 : code.hashCode());
        result = prime
            * result
            + ((id == null)
                ? 0 : id.hashCode());
        result = prime
            * result
            + offerInCash;
        result = prime
            * result
            + offerInPercent;
        result = prime
            * result
            + ((offerName == null)
                ? 0 : offerName.hashCode());
        result = prime
            * result
            + ((offerType == null)
                ? 0 : offerType.hashCode());
        result = prime
            * result
            + ((product == null)
                ? 0 : product.hashCode());
        result = prime
            * result
            + ((validTo == null)
                ? 0 : validTo.hashCode());
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
        Offer other = (Offer) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else
            if (!code.equals(other.code))
                return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else
            if (!id.equals(other.id))
                return false;
        if (offerInCash != other.offerInCash)
            return false;
        if (offerInPercent != other.offerInPercent)
            return false;
        if (offerName == null) {
            if (other.offerName != null)
                return false;
        } else
            if (!offerName.equals(other.offerName))
                return false;
        if (offerType != other.offerType)
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else
            if (!product.equals(other.product))
                return false;
        if (validTo == null) {
            if (other.validTo != null)
                return false;
        } else
            if (!validTo.equals(other.validTo))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "Offer [id="
            + id + ", offerName=" + offerName + ", code=" + code + ", validTo=" + validTo + ", offerType=" + offerType
            + ", offerInCash=" + offerInCash + ", offerInPercent=" + offerInPercent + ", product=" + product + "]";
    }

}
