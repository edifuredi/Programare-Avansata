/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab_3;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author user
 */
public class Lab_3 {

    public static void main(String[] args) {
        ArrayList<Profile> lista;
        lista=new ArrayList<>();
        Designer d1= new Designer("FASHION",1,"EDI");
        Designer d2= new Designer("INTERIOR",2,"ALEX");
        Programmer p1= new Programmer("JAVA",3,"RADU");
        Programmer p2=new Programmer("PYTHON",4,"ANDREI");
        Company c1=new Company(5,"ALTEX");
        lista.add(d1);
        lista.add(d2);
        lista.add(p1);
        lista.add(p2);
        lista.add(c1);
        d1.addRelationship(d2, "FRIENDSHIP");
        d2.addRelationship(c1, "OWNERSHIP");
        d2.addRelationship(p1,"FRIENDSHIP");
        d2.addRelationship(p2,"BOSS");
        d1.addRelationship(c1, "EMPLOYEE");
        p1.addRelationship(p2,"COLEAGUE");
        System.out.println(lista);
        lista.sort(Comparator.comparing(Profile::getName));
        System.out.println(lista);
        System.out.println(d1.getImportance());
        System.out.println(d2.getImportance());
        System.out.println(p1.getImportance());
        System.out.println(p2.getImportance());
        System.out.println(c1.getImportance());
        SocialNetwork retea= new SocialNetwork();
        retea.addProfile(d1);
        retea.addProfile(d2);
        retea.addProfile(p1);
        retea.addProfile(p2);
        retea.addProfile(c1);
        System.out.print(retea);
    }
}
