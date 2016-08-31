package com.serverstateless;

import java.net.Socket;

/**
 * Created by udoluweera on 2/15/15.
 */
public class HeartBeat implements Runnable {

    private Socket socket;
    public HeartBeat(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
