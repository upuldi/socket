package com.enums;

/**
 * Created by udoluweera on 2/14/15.
 */
public enum CarLoadedStatus {
    EMPTY("E"),
    LOADED("L");

    private String code;

    CarLoadedStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
