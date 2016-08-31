package com.enums;

/**
 * Created by udoluweera on 2/14/15.
 */
public enum ARTICULATED_STATUS {
    ARTICULATED(0),
    NOT_ARTICULATED(1);

    private int code;
    ARTICULATED_STATUS(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
