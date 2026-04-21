/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8;

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    MainFrame frame;
    int n = 10;
    Cell[][] grid;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initMaze();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int size = Math.min(getWidth(), getHeight());
                int cell = size / n;
                int col = e.getX() / cell;
                int row = e.getY() / cell;

                if (row >= n || col >= n) return;

                int x = e.getX() % cell;
                int y = e.getY() % cell;

                Cell c = grid[row][col];

                if (y < 5) c.top = !c.top;
                else if (x > cell - 5) c.right = !c.right;
                else if (y > cell - 5) c.bottom = !c.bottom;
                else if (x < 5) c.left = !c.left;

                repaint();
            }
        });
    }

    void setSize(int n) {
        this.n = n;
        initMaze();
        repaint();
    }

    void initMaze() {
        grid = new Cell[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = new Cell(i, j);
    }

    void reset() {
        initMaze();
        repaint();
    }

    void randomize() {
        Random rand = new Random();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                Cell c = grid[i][j];
                c.top = rand.nextBoolean();
                c.right = rand.nextBoolean();
                c.bottom = rand.nextBoolean();
                c.left = rand.nextBoolean();
            }
        repaint();
    }

    void check() {
        boolean[][] vis = new boolean[n][n];
        dfs(0, 0, vis);
        JOptionPane.showMessageDialog(this, vis[n-1][n-1] ? "OK" : "NO");
    }

    void dfs(int r, int c, boolean[][] vis) {
        if (r < 0 || c < 0 || r >= n || c >= n || vis[r][c]) return;
        vis[r][c] = true;
        Cell cell = grid[r][c];

        if (!cell.top) dfs(r - 1, c, vis);
        if (!cell.right) dfs(r, c + 1, vis);
        if (!cell.bottom) dfs(r + 1, c, vis);
        if (!cell.left) dfs(r, c - 1, vis);
    }

    void save() {
        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("maze.ser"));
            o.writeObject(grid);
            o.close();
        } catch (Exception e) {}
    }

    void load() {
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream("maze.ser"));
            grid = (Cell[][]) o.readObject();
            n = grid.length;
            o.close();
            repaint();
        } catch (Exception e) {}
    }

    void exportPNG() {
        try {
            BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = img.createGraphics();
            paint(g2);
            ImageIO.write(img, "PNG", new File("maze.png"));
        } catch (Exception e) {}
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = Math.min(getWidth(), getHeight());
        int cell = size / n;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int x = j * cell;
                int y = i * cell;
                Cell c = grid[i][j];

                if (c.top) g.drawLine(x, y, x + cell, y);
                if (c.right) g.drawLine(x + cell, y, x + cell, y + cell);
                if (c.bottom) g.drawLine(x, y + cell, x + cell, y + cell);
                if (c.left) g.drawLine(x, y, x, y + cell);
            }
    }
}
