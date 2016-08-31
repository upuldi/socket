package com.enums;

/**
 * Created by udoluweera on 2/13/15.
 */
public enum MessageSource {

    PRO_YARD ("P"),
    MIS ("M");

    MessageSource(String code) {
        this.code = code;
    }
    private String code;

    public String getCode() {
        return code;
    }
}
