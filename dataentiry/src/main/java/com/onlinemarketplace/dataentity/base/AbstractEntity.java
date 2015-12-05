package com.onlinemarketplace.dataentity.base;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public class AbstractEntity<I> {

    /** CreationTimestamp variable. */
    @Column(name = "creationTime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ")
    // @Temporal(TemporalType.TIMESTAMP)
    private Timestamp creationTime;

    /** CreationTimestamp variable. */
    @Column(name = "lastUpdate", columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    // @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastUpdateTime;

    @Column(name = "extraField1")
    private String extraField1;

    @Column(name = "extraField2")
    private String extraField2;

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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

    @PrePersist
    protected void onCreate() {
        if (creationTime == null) {
            creationTime = new Timestamp(System.currentTimeMillis());
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((creationTime == null)
                ? 0 : creationTime.hashCode());
        result = prime
            * result
            + ((extraField1 == null)
                ? 0 : extraField1.hashCode());
        result = prime
            * result
            + ((extraField2 == null)
                ? 0 : extraField2.hashCode());
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractEntity other = (AbstractEntity) obj;
        if (creationTime == null) {
            if (other.creationTime != null)
                return false;
        } else
            if (!creationTime.equals(other.creationTime))
                return false;
        if (extraField1 == null) {
            if (other.extraField1 != null)
                return false;
        } else
            if (!extraField1.equals(other.extraField1))
                return false;
        if (extraField2 == null) {
            if (other.extraField2 != null)
                return false;
        } else
            if (!extraField2.equals(other.extraField2))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "AbstractEntity [creationTime="
            + creationTime + ", extraField1=" + extraField1 + ", extraField2=" + extraField2 + "]";
    }

}
