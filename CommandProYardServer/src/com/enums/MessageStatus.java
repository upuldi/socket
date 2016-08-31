package com.enums;

/**
 * Created by udoluweera on 2/13/15.
 */
public enum  MessageStatus {

    SUCCESS("0"),
    FAILURE("1");

    private String code;
    MessageStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
