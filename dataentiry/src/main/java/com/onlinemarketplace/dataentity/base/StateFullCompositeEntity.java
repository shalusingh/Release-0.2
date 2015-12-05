package com.onlinemarketplace.dataentity.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author jitendra.sagoriya
 *
 * @version $Revision: $ ($Date: $)
 */
@MappedSuperclass
public abstract class StateFullCompositeEntity<STATE, ID>
    extends CompositeAbstractEntity<ID> {

    @Column(name = "status", nullable = false)
    protected STATE status;

    public abstract STATE getStatus();

    public abstract void setStatus(STATE status);

}
