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

public class Maze {
    private char[][] grid;
    private int size;

    public Maze(int size) {
        this.size = size;
        grid = new char[size][size];

        // simplu: tot liber
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = '.';

        // exit
        grid[size - 1][size - 1] = 'E';
    }

    public boolean isValid(int r, int c) {
        return r >= 0 && c >= 0 && r < size && c < size;
    }

    public boolean isExit(int r, int c) {
        return grid[r][c] == 'E';
    }

    public int getSize() {
        return size;
    }
}