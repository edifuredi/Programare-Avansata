/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server;

/**
 *
 * @author user
 */
import java.io.*;
import java.util.*;

public class QuizGame {
    public List<Question> questions = new ArrayList<>();

    public int bestScore = 0;
    public long bestTime = Long.MAX_VALUE;
    public String bestPlayer = "";

    public QuizGame() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("questions.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                questions.add(new Question(parts[0], parts[1]));
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}