package com.onlinemarketplace.validation.validator;

import com.onlinemarketplace.dataentity.enums.Status;
import com.onlinemarketplace.validation.logic.ValidationResult;
import com.onlinemarketplace.validation.logic.ValidationResult.ResultCode;
import com.onlinemarketplace.validation.logic.Validator;
import com.onlinemarketplace.validation.model.DtoBase;

public class NullValidator
    implements Validator<DtoBase, Status> {

    @Override
    public ValidationResult validate(Object object) {
        ValidationResult result = new ValidationResult();
        if (object == null) {
            result.setCode(ResultCode.FAILED);
            result.setErrorMessage("is Null");
        }
        result.setCode(ResultCode.SUCCESS);

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.onlinemarketplace.validation.logic.Validator#validate(java.lang.Object, java.lang.Object)
     */
    @Override
    public ValidationResult validate(Object object, Status status) {
        // TODO Auto-generated method stub
        return null;
    }

}
