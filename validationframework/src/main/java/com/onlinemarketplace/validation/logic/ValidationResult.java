package com.onlinemarketplace.validation.logic;

public class ValidationResult {

    public enum ResultCode {
        SUCCESS,
        FAILED,
        ABORT
    };

    private ResultCode code;

    private String errorMessage;

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ValidationResult [code="
            + code + ", errorMessage=" + errorMessage + "]";
    }

}
