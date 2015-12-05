package com.onlinemarketplace.dataentity.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NaturalAbstractEntity<ID>
    extends AbstractEntity<ID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result + ((id == null)
                ? 0 : id.hashCode());
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
        NaturalAbstractEntity other = (NaturalAbstractEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else
            if (!id.equals(other.id))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "AbstractEntity [id="
            + id + "]";
    }

}
