package com.enums;

/**
 * Created by udoluweera on 2/14/15.
 */
public enum BEARING_CODE {
    TTX_TYPECAR_LOAD("B"),
    TTX_TYPECAR_UNLOAD("L"),
    TTX_TYPECAR_EMPTY("E");

    private String code;
    BEARING_CODE(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
