/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

/**
 *
 * @author user
 */
public class CatalogRepo {
    private Catalog catalog;

    public CatalogRepo(Catalog catalog) {
        this.catalog = catalog;
    }
    
    public void add(Resource r) {
        catalog.add(r);
    }
    
    public void list()
    {
        for(var it : catalog.getResources())
        {
            System.out.println(it);
        }
    }
    
    public void open(Resource r) throws CatalogException
    {
        try{
            Desktop desktop=Desktop.getDesktop();
            if(r.getLocation().startsWith("http"))
            {
                desktop.browse(new URI(r.getLocation()));
            }
            else
            {
                desktop.open(new File(r.getLocation()));
            }
        } catch(Exception e)
        {
            throw new CatalogException("NU PUTEM DESCHIDE RESURSA");
        }
    }
}
