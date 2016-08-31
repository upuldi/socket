package com.message;

import com.enums.MessageType;
import com.util.MessageCounter;

/**
 * Created by udoluweera on 2/14/15.
 */
public class RejectMessageBuilder extends MessageBuilder {

    @Override
    protected void createDataPotion() {
        getMessage().setMessageId(MessageType.REJECT_MESSAGE);
        getMessage().setSequenceNo(MessageCounter.getMessageCount());

        getMessage().setCrc("00000");
    }
}
