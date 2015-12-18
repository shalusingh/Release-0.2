/**
 *
 */
package com.onlinemarketplace.validation.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jitendra Dec 17, 2015 2015
 */
@XmlRootElement(name = "Validations")
@XmlAccessorType(XmlAccessType.FIELD)

public class Validations {

    @XmlElement(name = "validation")
    List<Validation> list;

    public List<Validation> getList() {
        return list;
    }

    public void setList(List<Validation> list) {
        this.list = list;
    }

}
