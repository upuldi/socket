package com.util;

import com.domain.Message;
import com.enums.*;
import com.message.*;

import java.awt.*;

/**
 * Created by udoluweera on 2/13/15.
 */
public class MessageTester {

    public static void main(String[] args) {

        HeartBeatMessageBuilder messageBuilder = new HeartBeatMessageBuilder();
        messageBuilder.setStatus(MessageStatus.SUCCESS);
        Message heartBeatMessage = new MessageComposer(messageBuilder).composeMessage(MessageSource.MIS);
        System.out.println("HeartBeat Message : " + heartBeatMessage.getMessageData());

        RejectMessageBuilder rejectMessageBuilder = new RejectMessageBuilder();
        Message rejectMessage = new MessageComposer(rejectMessageBuilder).composeMessage(MessageSource.MIS);
        System.out.println("Reject Message : " + rejectMessage.getMessageData());

        StartOfHumpListMessageBuilder startOfHumpListMessageBuilder = new StartOfHumpListMessageBuilder();
        startOfHumpListMessageBuilder.setTrainId("12345");
        Message startHumpListMessage = new MessageComposer(startOfHumpListMessageBuilder).
                composeMessage(MessageSource.MIS);
        System.out.println("Start Hump List Message : " + startHumpListMessage.getMessageData());


        HumpListCarDetailMessageBuilder humpListCarDetailMessageBuilder = new HumpListCarDetailMessageBuilder();
        humpListCarDetailMessageBuilder.setCarLoadedStatus(CarLoadedStatus.LOADED);
        humpListCarDetailMessageBuilder.setArticulated_status(ARTICULATED_STATUS.ARTICULATED);
        humpListCarDetailMessageBuilder.setBearing_code(BEARING_CODE.TTX_TYPECAR_EMPTY);
        humpListCarDetailMessageBuilder.setRsb_status(RSB_STATUS.NO);

        Message humpListCarDetailMessage = new MessageComposer(humpListCarDetailMessageBuilder).composeMessage(MessageSource.MIS);
        System.out.println("Hump List Car Detail Message : " + humpListCarDetailMessage.getMessageData());

    }
}
