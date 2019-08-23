package dev.hbrown.handlers;

import java.io.IOException;

import static java.lang.System.out;

public class PrintingHandler<S> extends DecoratedHandler<S> {

    public PrintingHandler(Handler<S> other) {
        super(other);
    }

    @Override
    public void handle(S s) throws IOException {
        out.printf("Connected to %s%n", s);
        try {
            super.handle(s);
        } finally {
            out.printf("Disconnected from %s%n", s);
        }
    }
}
