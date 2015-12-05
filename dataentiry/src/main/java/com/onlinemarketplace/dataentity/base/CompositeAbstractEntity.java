package com.onlinemarketplace.dataentity.base;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CompositeAbstractEntity<ID>
extends AbstractEntity<ID> {

    @EmbeddedId
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
        int result = super.hashCode();
        result = prime
            * result + ((id == null)
                ? 0 : id.hashCode());
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CompositeAbstractEntity<ID> other = (CompositeAbstractEntity<ID>) obj;
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
        return "CompositeAbstractEntity [id="
            + id + "]";
    }

}
