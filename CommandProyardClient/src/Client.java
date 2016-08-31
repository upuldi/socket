import java.io.*;
import java.net.Socket;

/**
 * Created by udoluweera on 2/15/15.
 */
public class Client {

    private static String serverName = "localhost";
    private static int port = 8225;

    public static void main(String[] args) throws InterruptedException {

        Thread faultyMessageThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Connecting to " + serverName + " on port " + port);
                Socket socket = null;
                try {
                    socket = new Socket(serverName, port);
                    System.out.println("Just connected to " + socket.getRemoteSocketAddress());
                    OutputStream outToServer = socket.getOutputStream();
                    DataOutputStream out = new DataOutputStream(outToServer);
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    out.writeUTF("CRAZY MESSAGE");
                    out.flush();
                    System.out.println("Server response is : " + in.readUTF());
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        faultyMessageThread.start();
        faultyMessageThread.join();

        Thread heartBeatThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    System.out.println("Connecting to " + serverName + " on port " + port);
                    Socket socket = null;
                    try {
                        socket = new Socket(serverName, port);
                        System.out.println("Just connected to " + socket.getRemoteSocketAddress());
                        OutputStream outToServer = socket.getOutputStream();
                        DataOutputStream out = new DataOutputStream(outToServer);
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                        out.writeUTF("PMim032PM01000021423992832000000");
                        out.flush();
                        System.out.println("Server response is : " + in.readUTF());
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        heartBeatThread.start();
        heartBeatThread.join();

    }


}
