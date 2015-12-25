package com.onlinemarketplace.validation.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author jitendra Dec 17, 2015 2015
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Field {

    @XmlElement(name = "name")
    private String fieldName;

    @XmlElement(name = "type")
    private String type;

    @XmlElementWrapper(name = "validates")
    @XmlElement(name = "validate")
    private List<String> validate;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String categoryName) {
        this.fieldName = categoryName;
    }

    public List<String> getValidates() {
        return validate;
    }

    public void setValidates(List<String> validates) {
        this.validate = validates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getValidate() {
        return validate;
    }

    public void setValidate(List<String> validate) {
        this.validate = validate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((fieldName == null)
                ? 0 : fieldName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (fieldName == null) {
            if (obj != null)
                return false;
        } else
            if (!fieldName.equals(obj))
                return false;
        return true;
    }

}