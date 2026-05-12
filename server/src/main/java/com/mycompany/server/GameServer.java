/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server;

/**
 *
 * @author user
 */
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class GameServer {
    public static final int PORT = 1234;
    private ServerSocket serverSocket;
    private ExecutorService pool;
    public static QuizGame game = new QuizGame();

    public GameServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        pool = Executors.newFixedThreadPool(20);
        System.out.println("Server started");
    }

    public void start() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            ClientThread client = new ClientThread(socket, this);
            pool.execute(client);
        }
    }

    public void stop() throws IOException {
        pool.shutdown();
        serverSocket.close();
        System.out.println("Server stopped");
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.start();
    }
}
