package com.onlinemarketplace.validation.logic;

import java.util.List;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

import com.onlinemarketplace.validation.logic.ValidationResult.ResultCode;
import com.onlinemarketplace.validation.model.Field;
import com.onlinemarketplace.validation.model.Validation;

public class ValidationManagerImpl<DTO, STATUS>
    implements ValidationManager<DTO, STATUS> {

    public ValidationManagerImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private final ApplicationContext applicationContext;

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.validation.logic.ValidationManager#validate(java.lang.Object,
     * com.onlinemarketplace.validation.model.Validation)
     */
    @Override
    @SuppressWarnings("unchecked")
    public ValidationResult validate(DTO dto, Validation validation) {
        ValidationResult result = new ValidationResult();

        if (validation == null) {
            result.setCode(ResultCode.SUCCESS);
            result.setErrorMessage("No Validation is found.");
        }

        List<Field> validationList = validation.getFields();

        if (validationList == null) {
            result.setCode(ResultCode.SUCCESS);
            result.setErrorMessage("No Validation is found.");
        }

        for (Field field : validationList) {

            String fieldName = field.getFieldName();

            Object fieldValue = null;
            List<String> validator = field.getValidate();
            AutowireCapableBeanFactory autowireCapableBeanFactory;
            autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
            Validator<DTO, STATUS> targetValidator;

            try {
                Class<? extends Object> dtoClass = dto.getClass();
                fieldValue = dtoClass.getMethod("get"
                    + fieldName).invoke(dto);

                for (String valid : validator) {

                    Class<? extends Validator<DTO, STATUS>> classz;
                    classz = (Class<? extends Validator<DTO, STATUS>>) Class.forName(valid).asSubclass(
                        Validator.class);

                    targetValidator = (Validator<DTO, STATUS>) autowireCapableBeanFactory.createBean(classz,
                        AutowireCapableBeanFactory.AUTOWIRE_NO, true);

                    result = targetValidator.validate(fieldValue);

                    if (result.getCode() == ResultCode.ABORT
                        || result.getCode() == ResultCode.FAILED) {
                        result.setErrorMessage(fieldName.concat(" "
                            + result.getErrorMessage()));
                        return result;
                    }

                }

            } catch (Exception e) {
                result.setCode(ResultCode.ABORT);
                result.setErrorMessage(e.getMessage());
                e.printStackTrace();
                return result;
            }
        }

        return result;

    }

}
