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

public class ClientThread extends Thread {
    private Socket socket;
    private GameServer server;
    private BufferedReader in;
    private PrintWriter out;

    private String playerName = "";
    private int score = 0;
    private long totalTime = 0;

    public ClientThread(Socket socket, GameServer server) throws IOException {
        this.socket = socket;
        this.server = server;

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() {
        try {
            out.println("Enter your name:");
            playerName = in.readLine();

            for (Question q : GameServer.game.questions) {

                long start = System.currentTimeMillis();

                out.println("Question: " + q.question);
                out.println("You have 10 seconds");

                socket.setSoTimeout(10000);

                String answer;

                try {
                    answer = in.readLine();
                } catch (Exception e) {
                    out.println("Time expired");
                    continue;
                }

                long end = System.currentTimeMillis();
                totalTime += (end - start);

                if (answer.equalsIgnoreCase(q.answer)) {
                    score++;
                    out.println("Correct");
                } else {
                    out.println("Wrong. Correct answer: " + q.answer);
                }
            }

            out.println("Game finished");
            out.println("Player: " + playerName);
            out.println("Score: " + score);
            out.println("Total time: " + totalTime + " ms");

            if (score == GameServer.game.bestScore) {
                if (totalTime < GameServer.game.bestTime) {
                    GameServer.game.bestPlayer = playerName;
                    GameServer.game.bestTime = totalTime;
                }
            }

            if (score > GameServer.game.bestScore) {
                GameServer.game.bestScore = score;
                GameServer.game.bestPlayer = playerName;
                GameServer.game.bestTime = totalTime;
            }

            out.println("Winner: " + GameServer.game.bestPlayer);

            String request;

            while ((request = in.readLine()) != null) {

                if (request.equals("stop")) {
                    out.println("Server stopped");
                    server.stop();
                    break;
                } else {
                    out.println("Server received the request " + request);
                }
            }

            socket.close();

        } catch (Exception e) {
            System.out.println("Client disconnected");
        }
    }
}