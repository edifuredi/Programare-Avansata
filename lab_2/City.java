/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_2;

/**
 *
 * @author user
 */
public final class City extends Location{
    private int population;

    public City(int population, String name, String type, int x, int y) {
        super(name, type, x, y);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    /*@Override
    public String toString() {
        return "City{" + "population=" + population + '}';
    }*/
    
}
