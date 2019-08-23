package dev.hbrown;

import java.io.IOException;
import java.net.Socket;

public class NastyChump {

    public static void main(String[] args) throws IOException, InterruptedException {
        final Socket[] sockets = new Socket[5_000];
        for (int i = 0; i < sockets.length; i++) {
            sockets[i] = new Socket("localhost", 8080);
        }
        Thread.sleep(100_000);
    }
}
