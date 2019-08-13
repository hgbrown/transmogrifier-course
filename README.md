# Transmogrifier: Java NIO and Non-Blocking IO Course

My source code for the above course.

## Required Software

- Java 9
- Gradle

## Single-threaded blocking server with old java.io

Implemented a single threaded blocking server using the old `java.io` packages.

To connect, we can use `telent` as follows:

```bash
$ telenet localhost 8080 
```

We should be able to connect to the server and get responses from the server.
When we attempt to open a second telnet connection, we notice that since the
server is single-threaded we do not get any response until we disconnect the first
connection.
