/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

import java.util.List;
import java.util.Set;


/**
 *
 * @author user
 */
public class City {
    private Set<Intersection> intersection;
    private List<Street> streets;

    public City(Set<Intersection> intersection, List<Street> streets) {
        this.intersection = intersection;
        this.streets = streets;
    }

    public Set<Intersection> getIntersection() {
        return intersection;
    }

    public void setIntersection(Set<Intersection> intersection) {
        this.intersection = intersection;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    @Override
    public String toString() {
        return "City{" + "intersection=" + intersection + ", streets=" + streets + '}';
    }
    
}
