/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9;

/**
 *
 * @author user
 */
public class Position {
    public int row, col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Position other) {
        return this.row == other.row && this.col == other.col;
    }
}