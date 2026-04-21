/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8;

/**
 *
 * @author user
 */
import java.io.Serializable;

public class Cell implements Serializable {
    int row, col;
    boolean top = true, right = true, bottom = true, left = true;

    public Cell(int r, int c) {
        row = r;
        col = c;
    }
}
