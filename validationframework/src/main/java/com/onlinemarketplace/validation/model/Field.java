/**
 *
 */
package com.onlinemarketplace.validation.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author jitendra Dec 17, 2015 2015
 */

public class Field {

    @XmlElement(name = "name")
    private String fieldName;

    @XmlElementWrapper(name = "validates")
    @XmlElement(name = "validate")
    private List<String> validate;

    public String getCategoryName() {
        return fieldName;
    }

    public void setCategoryName(String categoryName) {
        this.fieldName = categoryName;
    }

    public List<String> getValidates() {
        return validate;
    }

    public void setValidates(List<String> validates) {
        this.validate = validates;
    }

}
