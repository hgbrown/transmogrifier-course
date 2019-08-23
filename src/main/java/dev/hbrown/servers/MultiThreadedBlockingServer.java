package dev.hbrown.servers;

import dev.hbrown.handlers.Handler;
import dev.hbrown.handlers.PrintingHandler;
import dev.hbrown.handlers.ThreadedHandler;
import dev.hbrown.handlers.TransmogrifyHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedBlockingServer {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(PORT);
        final Handler<Socket> handler = new ThreadedHandler<>(
                new PrintingHandler<>(new TransmogrifyHandler())
        );

        while (true) {
            final Socket socket = serverSocket.accept();
            handler.handle(socket);
        }
    }


}
