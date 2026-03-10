/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_3;
import java.util.*;

/**
 *
 * @author user
 */
public class SocialNetwork {
    private ArrayList<Profile> profiles=new ArrayList<>();

    public SocialNetwork() {
        
    }
    
    public void addProfile(Profile p)
    {
        profiles.add(p);
    }

    @Override
    public String toString() {
        ArrayList<Profile> temp= new ArrayList<>(profiles);
        temp.sort(Comparator.comparingInt(Profile::getImportance).reversed());
        return temp.toString();
    }
}
