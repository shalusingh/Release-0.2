/**
 *
 */
package com.onlinemarketplace.dto.domain;

import java.util.Date;

/**
 * @author jitendra Dec 7, 2015 2015
 */
public class OfferDto
    extends BaseDto {

    /**
     *
     */
    private static final long serialVersionUID = 4081726817833725755L;

    private String code;

    private Date validTo;

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
        OfferDto other = (OfferDto) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else
            if (!code.equals(other.code))
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
        return "OfferDto [code="
            + code + ", validTo=" + validTo + ", getId()=" + getId() + ", getName()=" + getName() + ", toString()="
            + super.toString() + ", getClass()=" + getClass() + "]";
    }

}
