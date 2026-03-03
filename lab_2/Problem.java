/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.lab_2;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Problem {
    private final ArrayList<Location> locations= new ArrayList<>();
    private final ArrayList<Road> roads= new ArrayList<>();
    private boolean[][] mat;

    public Problem() {
    }

    public void addLocation(Location l)
    {
        if(locations.contains(l))
        {
            return;
        }
        locations.add(l);
    }
    //METODELE addLocatin si addRoad verifica sa nu se adauge 2 locatii sau strazi identice
    public void addRoad(Road r)
    {
        if(roads.contains(r))
        {
            return;
        }
        roads.add(r);
    }
    
    public boolean isValid()
    {
        for (Location loc : locations) {
            if (loc.getX() < 0 || loc.getX() > 100 || loc.getY() < 0 || loc.getY() > 100)
            {
                return false;
            }
        }
    return true;
    }
    
    public void buildAdjMat()
    {
        int n=locations.size();
        if(this.isValid())
        {
            this.mat=new boolean[n][n];
        }
        for(Road r : roads)
        {
            int i=locations.indexOf(r.getL1());
            int j=locations.indexOf(r.getL2());
            mat[i][j]=true;
            mat[j][i]=true;
        }
    }
    
    private boolean DFS(int start,int target,boolean[][] mat,boolean[] viz)
    {
        
        if(start==target)
        {
            return true;
        }
        viz[start]=true;
        for(int ind=0;ind<locations.size();ind++)
        {
            if(viz[ind]==false && mat[start][ind]==true)
            {
                if(DFS(ind,target,mat,viz))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isPossible(Location l1,Location l2)
    {
        this.buildAdjMat();
        int i=locations.indexOf(l1);
        int j=locations.indexOf(l2);
        boolean[] viz=new boolean[locations.size()];
        return DFS(i,j,mat,viz);
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }
    
    public double[][] getCostMat()
    {
        int n=locations.size();
        double[][] costMat= new double[n][n];
        double INF = Double.POSITIVE_INFINITY;
        for(int line=0;line<n;line++)
        {
            for(int col=0;col<n;col++)
            {
                costMat[line][col]=INF;
            }
        }
        for(Road r: roads)
        {
            int i=locations.indexOf(r.getL1());
            int j=locations.indexOf(r.getL2());
            costMat[i][j]=r.getCost();
        }
        return costMat;
    }

    @Override
    public String toString() {
        return "Problem{" + "locations=" + locations + ", roads=" + roads + '}';
    }
    
}
