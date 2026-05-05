/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9;

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt.*;

public class MazeGUI extends JFrame {

    private Maze maze;
    private Bunny bunny;
    private Robot[] robots;

    private int cellSize = 50;

    public MazeGUI(Maze maze, Bunny bunny, Robot[] robots) {
        this.maze = maze;
        this.bunny = bunny;
        this.robots = robots;

        setTitle("Maze Game");
        setSize(maze.getSize() * cellSize, maze.getSize() * cellSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // refresh periodic
        new Timer(500, e -> repaint()).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int size = maze.getSize();

        // desen grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                int x = j * cellSize;
                int y = i * cellSize + 30;

                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(x, y, cellSize, cellSize);

                // exit
                if (i == size - 1 && j == size - 1) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, cellSize, cellSize);
                }
            }
        }

        // bunny
        Position bp = bunny.getPosition();
        g.setColor(Color.BLUE);
        g.fillOval(bp.col * cellSize, bp.row * cellSize + 30, cellSize, cellSize);

        // robots
        g.setColor(Color.RED);
        for (Robot r : robots) {
            Position p = r.getPosition();
            g.fillRect(p.col * cellSize, p.row * cellSize + 30, cellSize, cellSize);
        }
    }
}