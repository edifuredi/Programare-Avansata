/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9;

/**
 *
 * @author user
 */
import java.util.Random;

public class Bunny extends Thread {
    private Position pos;
    private Maze maze;
    private GameState state;
    private int delay = 500;
    private Random rand = new Random();

    public Bunny(Position start, Maze maze, GameState state) {
        this.pos = start;
        this.maze = maze;
        this.state = state;
    }

    public Position getPosition() {
        return pos;
    }

    public void setDelay(int d) {
        delay = d;
    }

    @Override
    public void run() {
        while (state.running) {
            moveRandom();

            if (maze.isExit(pos.row, pos.col)) {
                System.out.println("🐰 Bunny escaped!");
                state.stopGame();
            }

            sleepThread();
        }
    }

    private void moveRandom() {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int i = rand.nextInt(4);
        int nr = pos.row + dr[i];
        int nc = pos.col + dc[i];

        if (maze.isValid(nr, nc)) {
            pos = new Position(nr, nc);
        }
    }

    private void sleepThread() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}
