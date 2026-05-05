/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9;

/**
 *
 * @author user
 */
public class GameManager extends Thread {
    private Maze maze;
    private Bunny bunny;
    private Robot[] robots;
    private GameState state;
    private long startTime;
    private int timeLimit = 20000;

    public GameManager(Maze maze, Bunny bunny, Robot[] robots, GameState state) {
        this.maze = maze;
        this.bunny = bunny;
        this.robots = robots;
        this.state = state;
        this.startTime = System.currentTimeMillis();
        setDaemon(true);
    }

    @Override
    public void run() {
        while (state.running) {
            printState();

            if (System.currentTimeMillis() - startTime > timeLimit) {
                System.out.println("⏱ Time limit exceeded!");
                state.stopGame();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }
    }

    private void printState() {
        int size = maze.getSize();
        char[][] view = new char[size][size];

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                view[i][j] = '.';

        view[bunny.getPosition().row][bunny.getPosition().col] = 'B';

        for (Robot r : robots) {
            Position p = r.getPosition();
            view[p.row][p.col] = 'R';
        }

        System.out.println("\n--- MAZE ---");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(view[i][j] + " ");
            System.out.println();
        }
    }
}