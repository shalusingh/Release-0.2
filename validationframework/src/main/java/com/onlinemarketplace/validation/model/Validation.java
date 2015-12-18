/**
 *
 */
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
public class Validation {

    @XmlElement(name = "name")
    private String domainClassName;

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    List<Field> fields;

    public String getDomainClassName() {
        return domainClassName;
    }

    public void setDomainClassName(String domainClassName) {
        this.domainClassName = domainClassName;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

}
