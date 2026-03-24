/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author user
 */
public class Catalog {
    private final List<Resource> resources = new ArrayList<>();

    public Catalog() {
    }
    
    public void add(Resource r)
    {
        resources.add(r);
    }

    public List<Resource> getResources() {
        return resources;
    }
}
