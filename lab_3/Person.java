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
public class Person implements Comparable<Person>,Profile{
    
    private int profileID;
    private int birthYear;
    private String name;
    private final Map<Profile,String> relationships=new HashMap<>();

    public Person(int profileID, String name) {
        this.profileID = profileID;
        this.name = name;
    }
    
    public Person() {
    }
    
    public void addRelationship(Profile p, String value) {
        relationships.put(p, value);
    }
    
    public int getImportance()
    {
        return relationships.size();
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    
    

    @Override
    public String toString() {
        return "Person{" + "profileID=" + profileID + ", name=" + name + '}';
    }
    
    
    @Override
    public int compareTo(Person o) {
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
