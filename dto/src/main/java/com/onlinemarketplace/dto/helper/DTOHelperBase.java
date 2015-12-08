/**
 *
 */
package com.onlinemarketplace.dto.helper;

import java.util.List;

/**
 * @author jitendra Dec 7, 2015 2015
 */
public abstract class DTOHelperBase<BASE, DTO> {

    /**
     * This method convert Base class to spacific Dto class.
     * @param base
     *            : {@link BASE}
     * @return DTO : {@link DTO}
     */
    public abstract DTO serialize(BASE base) throws NullPointerException;

    /**
     * This method convert Dto class to spacific domain class.
     * @param base
     *            {@link BASE}
     *
     * @return BASE :base
     */
    public abstract BASE deSerialize(DTO dto) throws NullPointerException;

    /**
     * This method convert list of domain object to seccific dto object.
     * @param {@link
     *            List} : bases
     *
     * @return {@link List} of Dto
     *
     */
    public abstract List<DTO> serializeAll(List<BASE> bases) throws NullPointerException;

    /**
     * This method convert list of dto object to specific domain object.
     * @return {@link List} : bases
     *
     * @param {@link
     *            List} of Dto
     *
     */

    public abstract List<BASE> deSerializeAll(List<DTO> dtos) throws NullPointerException;

}
