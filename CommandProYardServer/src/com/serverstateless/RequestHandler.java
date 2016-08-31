package com.serverstateless;

import com.domain.Message;
import com.enums.MessageStatus;
import com.enums.MessageType;
import com.enums.MessageSource;
import com.message.HeartBeatMessageBuilder;
import com.message.MessageComposer;
import com.message.RejectMessageBuilder;

import java.io.*;
import java.net.Socket;

/**
 * Created by udoluweera on 2/15/15.
 */
public class RequestHandler implements Runnable {

    private Socket socket;
    public RequestHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println("Incoming connection from : " + socket.getRemoteSocketAddress() );
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received Message is : " + message);

            /* Rejected message*/
            if (message.length()<=27) {
                System.out.println("Wrong Message Format. Sending a reject message back");
                dataOutputStream.writeUTF(getRejectMessage().getMessageData());
                dataOutputStream.flush();
            } else {
                /* Valid message*/

                MessageType messageType = getMessageCode(message);
                switch (messageType) {
                    case HEART_BEAT: {
                        System.out.println("Heart Beat Message Found...");
                        System.out.println("Sending Heart Beat back..");
                        dataOutputStream.writeUTF(getSuccessfulHeartBeatMesasage().getMessageData());
                        dataOutputStream.flush();
                    }
                }

            }
            // Do what you want.


            dataOutputStream.writeUTF("SOMETHING FROM SERVER");
            dataOutputStream.flush();


            dataInputStream.close();
            dataOutputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Closing connection...");
    }

    private Message getSuccessfulHeartBeatMesasage() {
        HeartBeatMessageBuilder heartBeatMessageBuilder = new HeartBeatMessageBuilder();
        heartBeatMessageBuilder.setStatus(MessageStatus.SUCCESS);
        return new MessageComposer(heartBeatMessageBuilder).composeMessage(MessageSource.MIS);
    }

    private Message getRejectMessage() {
        RejectMessageBuilder rejectMessageBuilder = new RejectMessageBuilder();
        return new MessageComposer(rejectMessageBuilder).composeMessage(MessageSource.MIS);
    }

    private MessageType getMessageCode(String message) {
        String messageCode = message.substring(9,11);
        System.out.println("Message Code is : " +messageCode);
        return MessageType.getMessageTypeByMessageCode(messageCode);
    }


}
