/**
 *
 */
package com.onlinemarketplace.dataentity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.onlinemarketplace.dataentity.base.NaturalAbstractEntity;
import com.onlinemarketplace.dataentity.enums.Right;

/**
 * @author jitendra Dec 23, 2015 2015
 */
@Entity
@Table(name = "authentication")
public class Authentication
    extends NaturalAbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String authCode;

    @Column(nullable = false, unique = true)
    private Long appId;

    @Column(name = "userright", nullable = false)
    private Right right;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Right getRight() {
        return right;
    }

    public void setRight(Right right) {
        this.right = right;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((appId == null)
                ? 0 : appId.hashCode());
        result = prime
            * result
            + ((authCode == null)
                ? 0 : authCode.hashCode());
        result = prime
            * result
            + ((right == null)
                ? 0 : right.hashCode());
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
        Authentication other = (Authentication) obj;
        if (appId == null) {
            if (other.appId != null)
                return false;
        } else
            if (!appId.equals(other.appId))
                return false;
        if (authCode == null) {
            if (other.authCode != null)
                return false;
        } else
            if (!authCode.equals(other.authCode))
                return false;
        if (right != other.right)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Authentication [authCode="
            + authCode + ", appId=" + appId + ", right=" + right + "]";
    }

}
