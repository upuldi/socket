package com.domain;

import com.enums.MessageType;
import com.enums.MessageSource;

/**
 * Created by udoluweera on 2/12/15.
 */
public class Message {

    private String networkHeader ="PMim";
    private int messageLength=0;
    private MessageSource source;
    private MessageSource destination;
    private MessageType messageId;
    private String sequenceNo;
    private long timestamp = System.currentTimeMillis() / 1000L;

    private String dataPotion="";
    private String crc="";

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getNetworkHeader() {
        return networkHeader;
    }

    public void setNetworkHeader(String networkHeader) {
        this.networkHeader = networkHeader;
    }

    public int getMessageLength() {
        return messageLength;
    }

    public void setMessageLength(int messageLength) {
        this.messageLength = messageLength;
    }

    public MessageSource getSource() {
        return source;
    }

    public void setSource(MessageSource source) {
        this.source = source;
    }

    public MessageSource getDestination() {
        return destination;
    }

    public void setDestination(MessageSource destination) {
        this.destination = destination;
    }

    public void setMessageId(MessageType messageId) {
        this.messageId = messageId;
    }

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDataPotion() {
        return dataPotion;
    }

    public void setDataPotion(String dataPotion) {
        this.dataPotion = dataPotion;
    }

    public final String getMessageData() {

        StringBuilder messageData = new StringBuilder();
        messageData.append(networkHeader);
        messageData.append("###");
        messageData.append(source.getCode());
        messageData.append(destination.getCode());
        messageData.append(messageId.getMessageCode());
        messageData.append(sequenceNo);
        messageData.append(timestamp);
        messageData.append(dataPotion);
        messageData.append(crc);

        String messageDataStr = messageData.toString();
        int messageLength = messageData.length();

        return messageDataStr.replace("###", String.format("%03d",messageLength));
    };



}
