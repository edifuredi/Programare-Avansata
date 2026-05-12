/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.client;

import java.net.*;
import java.io.*;

public class GameClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 1234);

            BufferedReader keyboard =
                    new BufferedReader(new InputStreamReader(System.in));

            BufferedReader in =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);

            Thread readThread = new Thread(() -> {

                try {

                    String response;

                    while ((response = in.readLine()) != null) {
                        System.out.println(response);
                    }

                } catch (Exception e) {
                }

            });

            Thread writeThread = new Thread(() -> {

                try {

                    String command;

                    while (true) {

                        command = keyboard.readLine();

                        if (command.equals("exit")) {
                            socket.close();
                            break;
                        }

                        out.println(command);
                    }

                } catch (Exception e) {
                }

            });

            readThread.start();
            writeThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}