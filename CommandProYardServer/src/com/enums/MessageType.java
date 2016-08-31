package com.enums;

/**
 * Created by udoluweera on 2/14/15.
 */
public enum MessageType {
    HEART_BEAT("01"),
    REJECT_MESSAGE("02"),
    START_HUMP_LIST("10"),
    HUMP_LIST_CAR_DETAIL("11");

    MessageType(String messageCode) {
        this.messageCode = messageCode;
    }
    private String messageCode;

    public String getMessageCode() {
        return messageCode;
    }
    public static MessageType getMessageTypeByMessageCode(String messageCode) {

        if (messageCode != null) {
            for (MessageType messageType : MessageType.values()) {
                if (messageType.getMessageCode().equalsIgnoreCase(messageCode)) {
                    return messageType;
                }
            }
        }
        throw new IllegalArgumentException("No constant with text " + messageCode + " found");
    }
}
