/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_2;

/**
 *
 * @author user
 */
public final class Airport extends Location{
    private int nbOfTerminals;

    public Airport(int nbOfTerminals, String name, String type, int x, int y) {
        super(name, type, x, y);
        this.nbOfTerminals = nbOfTerminals;
    }

    public int getNbOfTerminals() {
        return nbOfTerminals;
    }

    public void setNbOfTerminals(int nbOfTerminals) {
        this.nbOfTerminals = nbOfTerminals;
    }

    /*@Override
    public String toString() {
        return "Airport{" + "nbOfTerminals=" + nbOfTerminals + '}';
    }*/
    
}
