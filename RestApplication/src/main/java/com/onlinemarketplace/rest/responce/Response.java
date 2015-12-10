package com.onlinemarketplace.rest.responce;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Response<T>
    implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean Status;
    private String Message;
    private Exception exception;
    private int responceCode;

    private Object Result;

    public Response() {
    }

    /**
     * @param status
     * @param message
     * @param responceCode
     */
    public Response(Boolean status, String message, int responceCode) {
        super();
        Status = status;
        Message = message;
        this.responceCode = responceCode;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getResult() {
        return Result;
    }

    @SuppressWarnings("unchecked")
    public void setResult(Object result) {
        try {
            if (result.getClass() == ArrayList.class) {
                if (result != null) {
                    List<T> addresses = (List<T>) result;
                    this.Result = addresses;
                }
            } else {
                T city = (T) result;
                this.Result = city;
            }
        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }

    public int getResponceCode() {
        return responceCode;
    }

    public void setResponceCode(int responceCode) {
        this.responceCode = responceCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
            * result
            + ((Message == null)
                ? 0 : Message.hashCode());
        result = prime
            * result
            + ((Result == null)
                ? 0 : Result.hashCode());
        result = prime
            * result
            + ((Status == null)
                ? 0 : Status.hashCode());
        result = prime
            * result
            + ((exception == null)
                ? 0 : exception.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        @SuppressWarnings("unchecked")
        Response<T> other = (Response<T>) obj;
        if (Message == null) {
            if (other.Message != null)
                return false;
        } else
            if (!Message.equals(other.Message))
                return false;
        if (Result == null) {
            if (other.Result != null)
                return false;
        } else
            if (!Result.equals(other.Result))
                return false;
        if (Status == null) {
            if (other.Status != null)
                return false;
        } else
            if (!Status.equals(other.Status))
                return false;
        if (exception == null) {
            if (other.exception != null)
                return false;
        } else
            if (!exception.equals(other.exception))
                return false;

        return true;
    }

    @Override
    public String toString() {
        return "Response [Status="
            + Status + ", Message=" + Message + ", exception=" + exception + ", Result=" + Result + "]";
    }

}
