package dev.hbrown.handlers;

import dev.hbrown.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TransmogrifyHandler implements Handler<Socket> {

    @Override
    public void handle(Socket socket) throws IOException {
        try (
                socket;
                final InputStream inputStream = socket.getInputStream();
                final OutputStream outputStream = socket.getOutputStream()
        ) {
            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(Util.transmogrify(data));
            }
        }
    }
}
