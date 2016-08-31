package com.message;

import com.enums.MessageStatus;
import com.enums.MessageType;
import com.util.MessageCounter;

/**
 * Created by udoluweera on 2/12/15.
 */
public class HeartBeatMessageBuilder extends MessageBuilder {

    private MessageStatus status;

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    @Override
    protected void createDataPotion() {
        getMessage().setMessageId(MessageType.HEART_BEAT);
        getMessage().setDataPotion(status.getCode());
        getMessage().setSequenceNo(MessageCounter.getMessageCount());
        getMessage().setCrc("00000");
    }
}
