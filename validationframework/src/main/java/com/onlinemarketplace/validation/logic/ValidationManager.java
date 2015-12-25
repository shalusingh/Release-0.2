package com.onlinemarketplace.validation.logic;

import com.onlinemarketplace.validation.model.Validation;

public interface ValidationManager<DTO, STATUS> {

    /**
     * This Function in validate dto object.
     * @param dto
     *            : {@link DTO}
     * @param validation
     *            : {@link Validation}
     *
     * @return {@link ValidationResult}
     *
     */
    public ValidationResult validate(DTO dto, Validation validation);
}
