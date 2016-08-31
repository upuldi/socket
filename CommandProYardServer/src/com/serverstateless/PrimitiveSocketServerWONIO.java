package com.serverstateless;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by udoluweera on 2/15/15.
 */
public class PrimitiveSocketServerWONIO extends Thread {

    private int port;
    public void setPort(int port) {
        this.port = port;
    }
    public PrimitiveSocketServerWONIO(int port) {
        this.port = port;
    }

    private ServerSocket serverSocket;


    @Override
    public void run() {

        System.out.println("Server is listening for incoming connections on : " + port );

        ExecutorService executorService = Executors.newCachedThreadPool();
        while(!serverSocket.isClosed()) {

            try {
                Socket socket = serverSocket.accept();
                executorService.submit(new RequestHandler(socket));

            } catch (SocketException e) {
                System.out.println("Server is close for new connections : " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        try {
            System.out.println("Server is waiting on current requests to finish up to two hours");
            executorService.awaitTermination(2, TimeUnit.HOURS);
            System.out.println("Server finished successfully....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        System.out.println("STARTING SOCKET SERVER...");
        try {
            serverSocket = new ServerSocket(port);
            this.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stopServer() throws InterruptedException, IOException {
        System.out.println("STOPPING SOCKET SERVER...");
        serverSocket.close();
    }
}
