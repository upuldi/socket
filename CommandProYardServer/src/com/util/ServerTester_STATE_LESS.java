package com.util;

import com.serverstateless.PrimitiveSocketServerWONIO;

import java.io.IOException;

/**
 * Created by udoluweera on 2/15/15.
 */
public class ServerTester_STATE_LESS {

    public static void main(String[] args) throws InterruptedException, IOException {

        PrimitiveSocketServerWONIO primitiveSocketServerWONIO = new PrimitiveSocketServerWONIO(8225);
        primitiveSocketServerWONIO.startServer();



        //Stop Server
/*        Thread.sleep(5000);
        System.out.println("STOP SERVER request sent");
        primitiveSocketServerWONIO.stopServer();*/

    }
}
