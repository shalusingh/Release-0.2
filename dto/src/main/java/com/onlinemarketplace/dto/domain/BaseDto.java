/**
 *
 */
package com.onlinemarketplace.dto.domain;

import java.io.Serializable;

/**
 * @author jitendra Dec 7, 2015 2015
 */
public class BaseDto
    implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8103823325805757574L;

    private Long id;

    private String name;

    private String extraField1;

    private String extraField2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((extraField1 == null)
                ? 0 : extraField1.hashCode());
        result = prime
            * result
            + ((extraField2 == null)
                ? 0 : extraField2.hashCode());
        result = prime
            * result
            + ((id == null)
                ? 0 : id.hashCode());
        result = prime
            * result
            + ((name == null)
                ? 0 : name.hashCode());
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
        BaseDto other = (BaseDto) obj;
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else
            if (!id.equals(other.id))
                return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else
            if (!name.equals(other.name))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "BaseDto [id="
            + id + ", name=" + name + ", extraField1=" + extraField1 + ", extraField2=" + extraField2 + "]";
    }

}
