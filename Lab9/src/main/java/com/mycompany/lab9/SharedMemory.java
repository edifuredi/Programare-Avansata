/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9;

/**
 *
 * @author user
 */
public class SharedMemory {
    private Position bunnyLastSeen = null;

    public synchronized void updateBunny(Position pos) {
        bunnyLastSeen = pos;
    }

    public synchronized Position getBunny() {
        return bunnyLastSeen;
    }
}