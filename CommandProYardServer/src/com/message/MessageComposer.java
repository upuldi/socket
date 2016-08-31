package com.message;

import com.domain.Message;
import com.message.MessageBuilder;
import com.enums.MessageSource;

/**
 * Created by udoluweera on 2/13/15.
 */
public final class MessageComposer {

    private MessageBuilder messageBuilder;

    public void setMessageBuilder(MessageBuilder messageBuilder) {
        this.messageBuilder = messageBuilder;
    }

    public <T extends MessageSource>Message composeMessage(T t) {
        messageBuilder.setSourceLocation(t);
        messageBuilder.createDataPotion();
        return messageBuilder.getMessage();
    }

    public MessageComposer(MessageBuilder messageBuilder) {
        this.messageBuilder = messageBuilder;
    }
}
