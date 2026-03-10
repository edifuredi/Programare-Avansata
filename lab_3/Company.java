/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_3;

import java.lang.Comparable;
import java.util.*;

/**
 *
 * @author user
 */
public class Company implements Comparable<Company>,Profile{
    
    private int profileID;
    private String name;
    private String street;
    private final Map<Profile,String> relationships=new HashMap<>();
    
    public Company() {
    }

    public Company(int profileID, String name) {
        this.profileID = profileID;
        this.name = name;
    }

    public String getStreet() {
        return street;
    }
    
    public void addRelationship(Profile p, String value) {
        relationships.put(p, value);
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    @Override
    public int getImportance()
    {
        return relationships.size();
    }

    @Override
    public String toString() {
        return "Company{" + "profileID=" + profileID + ", name=" + name + '}';
    }
    
    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return profileID;
    }
    
}
    
