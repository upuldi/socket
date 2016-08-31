package com.message;

import com.domain.Message;
import com.enums.MessageSource;
import com.enums.MessageType;

/**
 * Created by udoluweera on 2/13/15.
 */
public abstract class MessageBuilder {

    private Message message = new Message();
    protected abstract void createDataPotion();

    protected Message getMessage() {
        return message;
    }

    private <T extends MessageSource>MessageSource getOtherEnd(T messageSource) {
        if (MessageSource.MIS.equals(messageSource)) {
            return MessageSource.PRO_YARD;
        } else if (MessageSource.PRO_YARD.equals(messageSource)) {
            return MessageSource.MIS;
        }
        return null;
    }

    public <T extends MessageSource>void setSourceLocation(T t) {
        message.setSource(t);
        message.setDestination(getOtherEnd(t));
    }
}
