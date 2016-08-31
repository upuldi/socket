package com.util;

/**
 * Created by udoluweera on 2/14/15.
 */
public class MessageCounter {

    private static long messageId=1;

    public synchronized static String getMessageCount(){
        messageId += 1;
        return String.format("%05d",messageId);
    }
}
