package dev.hbrown;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class SingleThreadedBlockingServer {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            final Socket socket = serverSocket.accept();
            handle(socket);
        }
    }

    private static void handle(Socket socket) throws IOException {
        out.printf("Connected to %s%n", socket);
        try (
                socket;
                final InputStream inputStream = socket.getInputStream();
                final OutputStream outputStream = socket.getOutputStream()
        ) {
            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(transmogrify(data));
            }
        } finally {
            out.printf("Disconnected from %s%n", socket);
        }
    }

    private static int transmogrify(int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }
}
