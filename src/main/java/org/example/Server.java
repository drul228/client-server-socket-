package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        int port = 9878;
        try(ServerSocket serverSocket = new ServerSocket(port);
            Socket client = serverSocket.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));){
            System.out.println("New connection accepted");

            final String name = in.readLine();

            out.println(String.format("Hi %s, your port is %d", name, client.getPort()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}