/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab4;

/**
 *
 * @author user
 */
public class Street implements Comparable<Street>{
    private String name;
    private int len;
    private Intersection a,b;

    public Street(String name, int len, Intersection a, Intersection b) {
        this.name = name;
        this.len = len;
        this.a = a;
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public Intersection getA() {
        return a;
    }

    public void setA(Intersection a) {
        this.a = a;
    }

    public Intersection getB() {
        return b;
    }

    public void setB(Intersection b) {
        this.b = b;
    }

    @Override
    public int compareTo(Street o) {
        return Integer.compare(this.len,o.len);
    }

    @Override
    public String toString() {
        return "Street{" + "name=" + name + ", len=" + len + ", a=" + a + ", b=" + b + '}';
    }
}
