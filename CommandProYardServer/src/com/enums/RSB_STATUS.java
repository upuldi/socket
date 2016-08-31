package com.enums;

/**
 * Created by udoluweera on 2/14/15.
 */
public enum RSB_STATUS {
    NO("0"),
    YES("1");

    private String code;
    RSB_STATUS(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
