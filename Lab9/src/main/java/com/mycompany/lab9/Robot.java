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

public class Robot extends Thread {
    private Position pos;
    private Maze maze;
    private Bunny bunny;
    private GameState state;
    private SharedMemory memory;
    private int delay = 500;
    private Random rand = new Random();

    public Robot(Position start, Maze maze, Bunny bunny,
                 GameState state, SharedMemory memory) {
        this.pos = start;
        this.maze = maze;
        this.bunny = bunny;
        this.state = state;
        this.memory = memory;
    }

    public void setDelay(int d) {
        delay = d;
    }
    
    public Position getPosition() {
    return pos;
}

    @Override
    public void run() {
        while (state.running) {
            move();

            // dacă vede bunny aproape
            if (distance(pos, bunny.getPosition()) <= 1) {
                memory.updateBunny(bunny.getPosition());
            }

            // dacă îl prinde
            if (pos.equals(bunny.getPosition())) {
                System.out.println("🤖 Robot caught the bunny!");
                state.stopGame();
            }

            sleepThread();
        }
    }

    private void move() {
        Position target = memory.getBunny();

        if (target != null) {
            // sistematic: merge spre bunny
            if (target.row > pos.row) pos.row++;
            else if (target.row < pos.row) pos.row--;

            if (target.col > pos.col) pos.col++;
            else if (target.col < pos.col) pos.col--;
        } else {
            moveRandom();
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

    private int distance(Position a, Position b) {
        return Math.abs(a.row - b.row) + Math.abs(a.col - b.col);
    }

    private void sleepThread() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}
