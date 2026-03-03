/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_2;

import java.util.ArrayList;

public class Solution {
    private final Problem pb;
    private final Location start,finish;
    private final ArrayList<Location> bestWay = new ArrayList<>();

    public Solution(Problem pb, Location start, Location finish) {
        this.pb = pb;
        this.start = start;
        this.finish = finish;
    }
    
    public void dijkstra(){

    bestWay.clear();

    double[][] mat = pb.getCostMat();
    int n = pb.getLocations().size();

    int s = pb.getLocations().indexOf(start);
    int t = pb.getLocations().indexOf(finish);

    double[] dist = new double[n];
    int[] prev = new int[n];
    boolean[] used = new boolean[n];

    // initializare
    for (int i = 0; i < n; i++) {
        dist[i] = Double.POSITIVE_INFINITY;
        prev[i] = -1;
        used[i] = false;
    }

    dist[s] = 0;

    // algoritmul propriu-zis
    for (int step = 0; step < n; step++) {

        int u = -1;
        double best = Double.POSITIVE_INFINITY;

        // aleg nodul cu distanta minima
        for (int i = 0; i < n; i++) {
            if (!used[i] && dist[i] < best) {
                best = dist[i];
                u = i;
            }
        }

        if (u == -1) break;

        used[u] = true;

        // relaxare vecini
        for (int v = 0; v < n; v++) {
            if (mat[u][v] == Double.POSITIVE_INFINITY) continue;
            if (used[v]) continue;

            double nd = dist[u] + mat[u][v];
            if (nd < dist[v]) {
                dist[v] = nd;
                prev[v] = u;
            }
        }
    }

    // reconstruire drum
    int cur = t;
    java.util.LinkedList<Location> path = new java.util.LinkedList<>();

    while (cur != -1) {
        path.addFirst(pb.getLocations().get(cur));
        if (cur == s) break;
        cur = prev[cur];
    }

    bestWay.addAll(path);
}

    @Override
    public String toString() {
        return "Solution{" + "bestWay=" + bestWay + '}';
    }
    
}
