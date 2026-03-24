/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

/**
 *
 * @author user
 */
public class Lab5 {

    public static void main(String[] args) {
        try{
            Catalog catalog=new Catalog();
            CatalogRepo repo=new CatalogRepo(catalog);
            Resource r1=new Resource("1","EXCEPTII","https://www.w3schools.com/java/java_try_catch.asp");
            Resource r2=new Resource("2","GRAFURI","C:\\Users\\user\\Desktop\\temagr");
            repo.add(r1);
            repo.add(r2);
            repo.list();
            repo.open(r1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
