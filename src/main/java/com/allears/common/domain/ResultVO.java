package com.allears.common.domain;

/**
 * resultVO
 */
public class ResultVO {
    private Boolean valid;

    private String message;

    private Object data;

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        if (valid == null) {
            valid = false;
        }
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
