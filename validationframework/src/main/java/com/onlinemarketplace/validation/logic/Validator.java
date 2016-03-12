package com.onlinemarketplace.validation.logic;

public interface Validator<DTO, STATUS> {

    /**
     * This method is validate the object.
     * @param object
     *            : {@link Object}
     *
     * @return {@link ValidationResult}
     */
    public ValidationResult validate(Object object);

    
    /**
     * This method is validate the object.
     * @param object
     *            : {@link Object}
     * @param   status : {@link STATUS}          
     *
     * @return {@link ValidationResult}
     */
    public ValidationResult validate(Object object, STATUS status);
}
