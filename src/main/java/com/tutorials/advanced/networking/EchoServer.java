package com.tutorials.advanced.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * A minimal TCP server built on the classic (blocking) java.net.Socket API:
 * accept() blocks until a client connects, then the connection is handled
 * with the same Reader/Writer decorator style covered in the io topic.
 * One accept-loop iteration per call to start() — a real server would loop
 * indefinitely and hand each connection to its own thread (or, since Java
 * 21, a virtual thread — see concurrency.virtualthreads).
 */
public class EchoServer implements AutoCloseable {
    private final ServerSocket serverSocket;

    public EchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public int port() {
        return serverSocket.getLocalPort();
    }

    // Accepts exactly one connection, echoes exactly one line, then returns —
    // deliberately simple so it's easy to trace end-to-end against EchoClient.
    public void handleOneConnection() throws IOException {
        try (Socket client = serverSocket.accept();
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true, StandardCharsets.UTF_8)) {
            String line = in.readLine();
            out.println("echo: " + line);
        }
    }

    @Override
    public void close() throws IOException {
        serverSocket.close();
    }
}
