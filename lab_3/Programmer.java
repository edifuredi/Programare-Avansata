/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_3;

/**
 *
 * @author user
 */
public class Programmer extends Person{
    private String language;

    public Programmer(String language, int profileID, String name) {
        super(profileID, name);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Programmer{" + "language=" + language + '}';
    }
    
}
