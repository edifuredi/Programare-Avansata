/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_2;

/**
 *
 * @author user
 */
public final class GasStation extends Location{
    private int gasPrice;

    public GasStation(int gasPrice, String name, String type, int x, int y) {
        super(name, type, x, y);
        this.gasPrice = gasPrice;
    }

    public int getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(int gasPrice) {
        this.gasPrice = gasPrice;
    }

    /*@Override
    public String toString() {
        return "GasStation{" + "gasPrice=" + gasPrice + '}';
    }*/
    
}
