/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_3;

/**
 *
 * @author user
 */
public class Designer extends Person{
    private String field;

    public Designer(String field, int profileID, String name) {
        super(profileID, name);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Designer{" + "field=" + field + '}';
    }
}
