package com.message;

import com.enums.MessageType;
import com.util.MessageCounter;

/**
 * Created by udoluweera on 2/14/15.
 */
public class StartOfHumpListMessageBuilder extends MessageBuilder {

    private String trainId="0";

    public String getTrainId() {
        return trainId;
    }
    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    @Override
    protected void createDataPotion() {
        getMessage().setMessageId(MessageType.START_HUMP_LIST);
        getMessage().setSequenceNo(MessageCounter.getMessageCount());
        String dataPotion = String.format("%-10s",trainId).replace(" ","0");
        getMessage().setDataPotion(dataPotion);
        getMessage().setCrc("00000");

    }
}
