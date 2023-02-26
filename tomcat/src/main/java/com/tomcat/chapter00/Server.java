package com.tomcat.chapter00;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    Boolean shutdown = false;
    public static void main(String[] args) {
    }

    public void await(){
        ServerSocket serverSocket = null;
        int port = 8080;
        try{
            serverSocket = new ServerSocket(port,1, InetAddress.getByName("127.0.01"));
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        while(!shutdown){
            try{
                Socket socket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
