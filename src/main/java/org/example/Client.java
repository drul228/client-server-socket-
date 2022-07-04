package org.example;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        int port = 9878;
        String host = "127.0.0.1";
        try(Socket client = new Socket(host, port);
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));){
            out.println("Timur");
            String resp = in.readLine();
            System.out.println(resp);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
